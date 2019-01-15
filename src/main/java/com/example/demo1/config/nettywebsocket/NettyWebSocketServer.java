package com.example.demo1.config.nettywebsocket;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-01-11 11:45
 */
@Component
@Slf4j
public class NettyWebSocketServer {
    // webSocket端口
    @Value("${netty.port}")
    private Integer webSocketServerPort;
    @Value("${netty.maxContentLength}")
    private Integer maxContentLength;
    private final WebSocketServerHandler webSocketServerHandler;

    @Autowired
    public NettyWebSocketServer(WebSocketServerHandler webSocketServerHandler) {
        this.webSocketServerHandler = webSocketServerHandler;
    }

    public void run() throws Exception {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap b = new ServerBootstrap();
            b.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class).childHandler(new ChannelInitializer<Channel>() {
                @Override
                protected void initChannel(Channel channel) throws Exception {
                    channel.pipeline()
                            .addLast("http-codec", new HttpServerCodec())// Http消息编码解码
                            .addLast("aggregator", new HttpObjectAggregator(maxContentLength)) // Http消息组装
                            .addLast("http-chunked", new ChunkedWriteHandler()) // WebSocket通信支持
//                            .addLast(new WebSocketServerProtocolHandler("/ws", null, true))
                            .addLast("handler", webSocketServerHandler)// 自定义WebSocket服务端Handler
                    ;
                }
            });
            Channel channel = b.bind(webSocketServerPort).sync().channel();
            log.info("WebSocket 已经启动，端口：" + webSocketServerPort + ".");
            channel.closeFuture().sync();
        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
