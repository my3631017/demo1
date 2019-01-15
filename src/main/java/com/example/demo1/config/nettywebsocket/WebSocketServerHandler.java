package com.example.demo1.config.nettywebsocket;

import com.alibaba.fastjson.JSON;
import com.example.demo1.entity.UrlParam;
import com.example.demo1.entity.WebSocketResponse;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.AttributeKey;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * WebSocket服务端Handler
 */
@Slf4j
@Component
@ChannelHandler.Sharable
public class WebSocketServerHandler extends SimpleChannelInboundHandler<Object> {
    //    private ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
    private WebSocketServerHandshaker handshaker;

    /*
    连接的用户，这里是qt数据点的订阅者
     */
    private final static Map<String, Map<String, Channel>> SUBSCRIBER_MAP = new ConcurrentHashMap<>();
    public static final Map<String, Map<String, Channel>> SUBSCRIBER_MAP1 = SUBSCRIBER_MAP;

    /**
     * 处理收到的消息
     *
     * @param channelHandlerContext chanel
     * @param msg                   消息
     * @throws Exception 异常
     */
    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, Object msg) throws Exception {
        if (msg instanceof FullHttpRequest) { // 传统的HTTP接入
            handleHttpRequest(channelHandlerContext, (FullHttpRequest) msg);
        } else if (msg instanceof WebSocketFrame) { // WebSocket接入
            handleWebSocketFrame(channelHandlerContext, (WebSocketFrame) msg);
        }
    }

    /**
     * 处理Http请求，完成WebSocket握手,WebSocket连接第一次请求使用的是Http
     *
     * @param ctx     ctx
     * @param request request
     * @throws Exception 异常
     */
    private void handleHttpRequest(ChannelHandlerContext ctx, FullHttpRequest request) throws Exception {
        // 如果HTTP解码失败，返回HTTP异常
        if (!request.getDecoderResult().isSuccess() || (!"websocket".equals(request.headers().get("Upgrade")))) {
            sendHttpResponse(ctx, request, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
            return;
        }
        // 正常WebSocket的Http连接请求，构造握手响应返回
        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory("ws://" + request.headers().get(HttpHeaders.Names.HOST), null, false);
        handshaker = wsFactory.newHandshaker(request);
        if (handshaker == null) { // 无法处理的webSocket版本
            WebSocketServerHandshakerFactory.sendUnsupportedWebSocketVersionResponse(ctx.channel());
        } else { // 向客户端发送webSocket握手,完成握手
            UrlParam urlParam = analysis(request);
            Channel channel = ctx.channel();
            log.info("订阅信息:type:{},id:{}", urlParam.getType(), urlParam.getId());
            // 订阅的type和id组成唯一的key
            String key = urlParam.getType() + "_" + urlParam.getId();
            channel.attr(AttributeKey.valueOf("type")).set(urlParam.getType());
            channel.attr(AttributeKey.valueOf("id")).set(urlParam.getId());
            Map<String, Channel> channelMap = SUBSCRIBER_MAP.get(key);
            // 该id没被任何人订阅
            if (null == channelMap) {
                Map<String, Channel> ch = new ConcurrentHashMap<>();
                ch.put(channel.id().toString(), channel);
                SUBSCRIBER_MAP.put(key, ch);
            }
            // 该id被订阅过,但是订阅者不包含当前订阅者
            if (null != channelMap && null == channelMap.get(channel.id().toString())) {
                channelMap.put(channel.id().toString(), channel);
                SUBSCRIBER_MAP.put(key, channelMap);
            }
            log.info("订阅者:{}", SUBSCRIBER_MAP);
            handshaker.handshake(channel, request);
            // 定时推送假数据
//            service.scheduleAtFixedRate(() -> {
//                try {
//                    UrlParam analysis = analysis(request);
//                    WebSocketResponse response = new WebSocketResponse();
//                    BeanUtils.copyProperties(analysis, response);
//                    response.setValue(Math.random());
//                    log.info("{}",response);
//                    send(response);
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//            }, 0, 40, TimeUnit.SECONDS);
        }
    }

    /**
     * HTTP返回
     *
     * @param ctx      ctx
     * @param request  request
     * @param response response
     */
    private static void sendHttpResponse(ChannelHandlerContext ctx, FullHttpRequest request, FullHttpResponse response) {
        // 返回应答给客户端
        if (response.getStatus().code() != 200) {
            ByteBuf buf = Unpooled.copiedBuffer(response.getStatus().toString(), CharsetUtil.UTF_8);
            response.content().writeBytes(buf);
            buf.release();
            HttpHeaders.setContentLength(response, response.content().readableBytes());
        }
        // 如果是非Keep-Alive，关闭连接
        ChannelFuture f = ctx.channel().writeAndFlush(response);
        if (!HttpHeaders.isKeepAlive(request) || response.getStatus().code() != 200) {
            f.addListener(ChannelFutureListener.CLOSE);
        }
    }

    /**
     * 处理webSocket请求
     *
     * @param ctx   ctx
     * @param frame frame
     * @throws Exception 异常
     */
    private void handleWebSocketFrame(ChannelHandlerContext ctx, WebSocketFrame frame) throws Exception {
        // 判断是否是关闭链路的指令
        if (frame instanceof CloseWebSocketFrame) {
            handshaker.close(ctx.channel(), (CloseWebSocketFrame) frame.retain());
            return;
        }
        // 判断是否是Ping消息
        if (frame instanceof PingWebSocketFrame) {
            ctx.channel().write(new PongWebSocketFrame(frame.content().retain()));
            return;
        }
        // 当前只支持文本消息，不支持二进制消息
        if (!(frame instanceof TextWebSocketFrame)) {
            throw new UnsupportedOperationException("当前只支持文本消息，不支持二进制消息");
        }
        String msg = ((TextWebSocketFrame) frame).text();
        // 打印收到的webSocket消息
        log.info("message is:{}", msg);
        // 后续可以做出应答
    }

    private void send(WebSocketResponse response) throws Exception {
        String key = response.getType() + "_" + response.getId();
        Map<String, Channel> channelMap = SUBSCRIBER_MAP.get(key);
        log.info("订阅该消息的所有channel:{}", channelMap);
        if (channelMap == null || channelMap.isEmpty()) {
            log.info("无人订阅当前数据点:type:{},id:{}", response.getType(), response.getId());
            return;
        }
        for (String s : channelMap.keySet()) {
            Channel channel = channelMap.get(s);
            channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(response)));
        }
    }


    @Scheduled(fixedRate = 1000 * 10)
    private void sendToAll() {
        Map<String, Map<String, Channel>> subscriberMap = SUBSCRIBER_MAP;
        List<Channel> channelList = new ArrayList<>();
        for (String s : subscriberMap.keySet()) {
            Map<String, Channel> channelMap = subscriberMap.get(s);
            for (String s1 : channelMap.keySet()) {
                channelList.add(channelMap.get(s1));
            }
        }
        WebSocketResponse response = new WebSocketResponse();
        log.info("channelList:{}",channelList);
        for (Channel channel : channelList) {
            response.setType(666);
            response.setId(888L);
            response.setValue(Math.random());
            channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(response)));
            log.info("向{}发送了定时消息", channel.id());
        }
    }

    /**
     * 解析出第一次握手建立连接时HTTP请求中的参数
     *
     * @param request FullHttpRequest
     * @return WebSocketResponse
     * @throws Exception 异常
     */
    private UrlParam analysis(FullHttpRequest request) throws Exception {
        UrlParam param = new UrlParam();
        String uri = request.getUri();
        if (StringUtils.isEmpty(uri)) {
            throw new Exception("请求参数为空");
        }
        String[] split = uri.split("\\?");
        // split[0]是路径,split[1]是参数
        if (split.length != 2) {
            throw new Exception("缺少参数");
        }
        // 获取参数，key=value
        String[] pairs = split[1].split("&");
        String[] type = pairs[0].split("=");
        param.setType(Integer.valueOf(type[1]));
        String[] id = pairs[1].split("=");
        param.setId(Long.valueOf(id[1]));
        return param;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.debug("发生异常：", cause);
        ctx.channel().close();
    }

    /**
     * 握手建立
     *
     * @param ctx ChannelHandlerContext
     * @throws Exception 异常
     */
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        log.info("握手建立");
    }

    /**
     * 握手取消
     *
     * @param ctx ChannelHandlerContext
     * @throws Exception 异常
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        String type = ctx.channel().attr(AttributeKey.valueOf("type")).get().toString();
        String id = ctx.channel().attr(AttributeKey.valueOf("id")).get().toString();
        // 订阅的type和id组成唯一的key
        String key = type + "_" + id;
        Map<String, Map<String, Channel>> subscriberMap = SUBSCRIBER_MAP;
        Map<String, Channel> channelMap = subscriberMap.get(key);
        if (null != channelMap && null != channelMap.get(ctx.channel().id().toString())) {
            channelMap.remove(ctx.channel().id().toString());
            if (channelMap.isEmpty()) {
                SUBSCRIBER_MAP.remove(key);
            } else {
                SUBSCRIBER_MAP.put(key, channelMap);
            }
        }
        log.info("订阅者:{}", SUBSCRIBER_MAP);
        log.info("握手取消");
    }
}
