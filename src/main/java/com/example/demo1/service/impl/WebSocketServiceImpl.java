package com.example.demo1.service.impl;

import com.alibaba.fastjson.JSON;
import com.example.demo1.entity.WebSocketResponse;
import com.example.demo1.service.WebSocketService;
import com.google.common.base.Strings;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-01-04 10:15
 */
@Slf4j
@Service
public class WebSocketServiceImpl implements WebSocketService {

    private static final Map<String, WebSocketService> SubscriberMap = new ConcurrentHashMap<>();
    private ChannelHandlerContext ctx;

    public static boolean register(String requestId, WebSocketService callBack) {
        if (Strings.isNullOrEmpty(requestId) || SubscriberMap.containsKey(requestId)) {
            return false;
        }
        SubscriberMap.put(requestId, callBack);
        return true;
    }

    public static boolean logout(String requestId) {
        if (Strings.isNullOrEmpty(requestId) || !SubscriberMap.containsKey(requestId)) {
            return false;
        }
        SubscriberMap.remove(requestId);
        return true;
    }

    @Override
    public void send(WebSocketResponse request) throws Exception {
        if (this.ctx == null || this.ctx.isRemoved()) {
            throw new Exception("尚未握手成功，无法向客户端发送WebSocket消息");
        }
        this.ctx.channel().write(new TextWebSocketFrame(JSON.toJSONString(request)));
        this.ctx.flush();
    }
}
