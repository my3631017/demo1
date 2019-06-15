package com.example.demo1.config.nettywebsocket;

import com.alibaba.fastjson.JSON;
import com.bici.saas.common.util.constants.SignConstants;
import com.bici.saas.common.util.enums.ResultEnum;
import com.example.demo1.entity.UrlParam;
import com.example.demo1.entity.WebSocketResponse;
import com.example.demo1.exeption.QtException;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.channel.*;
import io.netty.handler.codec.http.*;
import io.netty.handler.codec.http.websocketx.*;
import io.netty.util.AttributeKey;
import io.netty.util.CharsetUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.MapUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-01-04 17:28
 */
@Slf4j
@Component
@ChannelHandler.Sharable
public class WebSocketServerHandler extends SimpleChannelInboundHandler<Object> {
    private WebSocketServerHandshaker handshaker;

    private static ExecutorService executorService = Executors.newFixedThreadPool(50);
    /**
     * 连接的用户，这里是qt数据点的订阅者
     */
    private final static Map<String, Map<String, Channel>> SUBSCRIBER_MAP = new ConcurrentHashMap<>();

    /**
     * 处理收到的消息
     *
     * @param channelHandlerContext chanel
     * @param msg                   消息
     * @throws Exception 异常
     */
    @Override
    protected void messageReceived(ChannelHandlerContext channelHandlerContext, Object msg) throws Exception {
        // 传统的HTTP接入
        if (msg instanceof FullHttpRequest) {
            handleHttpRequest(channelHandlerContext, (FullHttpRequest) msg);
            // WebSocket接入
        } else if (msg instanceof WebSocketFrame) {
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
        if (!request.getDecoderResult().isSuccess() || (!WebsocketConstant.WEBSOCKET.equals(request.headers().get(WebsocketConstant.UP_GRADE)))) {
            sendHttpResponse(ctx, request, new DefaultFullHttpResponse(HttpVersion.HTTP_1_1, HttpResponseStatus.BAD_REQUEST));
            return;
        }
        // 正常WebSocket的Http连接请求，构造握手响应返回
        WebSocketServerHandshakerFactory wsFactory = new WebSocketServerHandshakerFactory(WebsocketConstant.PREFIX_WS + request.headers().get(HttpHeaders.Names.HOST), null, false);
        handshaker = wsFactory.newHandshaker(request);
        // 无法处理的webSocket版本
        if (handshaker == null) {
            WebSocketServerHandshakerFactory.sendUnsupportedWebSocketVersionResponse(ctx.channel());
        } else {
            Channel channel = ctx.channel();
            UrlParam urlParam = analysis(request);
            // TODO 如果是复杂感知,需要进行相应的处理
            if (urlParam.getType().equals(excercise2)) {

            }
            // 注册该channel
            addChannel(channel, urlParam);
            log.info("{}上线", channel.id());
            // 向客户端发送webSocket握手,完成握手
            handshaker.handshake(channel, request);
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
     * 处理webSocket消息
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
        log.info("收到消息,message is:{}", msg);
        // 后续可以做出应答
    }

    public static void send(WebSocketResponse response) {
        if (null == response || null == response.getType() || null == response.getId()) {
            log.info("消息为空或者消息格式不正确");
            return;
        }
        String key = response.getType() + SignConstants.SIGN_0 + response.getId();
        Map<String, Channel> channelMap = SUBSCRIBER_MAP.get(key);
        //增加SUBSCRIBER_MAP 的监控
        StringBuffer stringBuffer = new StringBuffer();
        SUBSCRIBER_MAP.forEach((k, v) -> {
            stringBuffer.append(k + "->");
            v.forEach((a, b) -> {
                stringBuffer.append(a + "_");
            });
            stringBuffer.append(" || ");
        });
        log.info("SUBSCRIBER_MAP 中 所有的 K : {}", stringBuffer);

        if (MapUtils.isEmpty(channelMap)) {
            log.info("无人订阅当前数据点:type:{},id:{}", response.getType(), response.getId());
            return;
        }
        for (Channel channel : channelMap.values()) {
            try {
                log.info("服务端IP:{},客户端:{}", channel.localAddress(), channel.remoteAddress());
                executorService.submit(() -> channel.writeAndFlush(new TextWebSocketFrame(JSON.toJSONString(response))));
            } catch (Exception e) {
                e.printStackTrace();
                log.error("向channel:{}发送消息失败", channel.id());
            }
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
        log.info("uri =  {}", uri);
        if (StringUtils.isEmpty(uri)) {
            throw QtException.build(ResultEnum.REQUEST_PARAM_IS_NULL);
        }
        String[] split = uri.split(SignConstants.SIGN_13);
        // split[0]是路径,split[excercise1]是参数
        if (split.length != excercise2) {
            throw QtException.build(ResultEnum.SERVLET_REQUEST_BINDING_EXCEPTION);
        }
        // 获取参数，key=value
        String[] pairs = split[1].split(SignConstants.SIGN_11);
        String[] type = pairs[0].split(SignConstants.SIGN_12);
        param.setType(Integer.valueOf(type[1]));
        String[] id = pairs[1].split(SignConstants.SIGN_12);
        param.setId(Long.valueOf(id[1]));
        return param;
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        log.debug("发生异常：", cause);
        ctx.channel().close();
    }

    /**
     * 握手取消
     *
     * @param ctx ChannelHandlerContext
     * @throws Exception 异常
     */
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        // 解除注册
        removeChannel(ctx.channel());
        log.info("{}下线", ctx.channel().id());
    }

    /**
     * 将channel添加到map
     *
     * @param channel  Channel
     * @param urlParam UrlParam
     */
    private synchronized void addChannel(Channel channel, UrlParam urlParam) {
        channel.attr(AttributeKey.valueOf(WebsocketConstant.TYPE)).set(urlParam.getType());
        channel.attr(AttributeKey.valueOf(WebsocketConstant.ID)).set(urlParam.getId());
        // 订阅的type和id组成唯一的key
        String key = urlParam.getType() + SignConstants.SIGN_0 + urlParam.getId();
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
    }

    /**
     * 移除map里面的channel
     *
     * @param channel Channel
     */
    private synchronized void removeChannel(Channel channel) {
        String type = channel.attr(AttributeKey.valueOf(WebsocketConstant.TYPE)).get().toString();
        String id = channel.attr(AttributeKey.valueOf(WebsocketConstant.ID)).get().toString();
        // TODO 如果是复杂感知,需要进行相应的处理
        if (type.equals("excercise2")) {

        }
        // 订阅的type和id组成唯一的key
        String key = type + SignConstants.SIGN_0 + id;
        Map<String, Channel> channelMap = SUBSCRIBER_MAP.get(key);
        if (null != channelMap && null != channelMap.get(channel.id().toString())) {
            channelMap.remove(channel.id().toString());
            if (channelMap.isEmpty()) {
                SUBSCRIBER_MAP.remove(key);
            } else {
                SUBSCRIBER_MAP.put(key, channelMap);
            }
        }
    }
}
