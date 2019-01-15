package com.example.demo1.config.springwebsocket;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-01-04 10:15
 */
@Component
@ServerEndpoint(value = "/myWebSocket")
@Slf4j
public class MyWebSocket {
    //用来存放每个客户端对应的MyWebSocket对象
    private static CopyOnWriteArraySet<MyWebSocket> user = new CopyOnWriteArraySet<>();

    //与某个客户端的连接会话，需要通过它来给客户端发送数据
    private Session session;

    /**
     * 收到客户端消息后调用的方法
     *
     * @param message 客户端发送过来的消息
     */
    @OnMessage
    public void onMessage(String message, Session session) throws IOException {
        //群发消息
        for (MyWebSocket myWebSocket : user) {
            myWebSocket.session.getBasicRemote().sendText(session.getId() + "说：" + message);
            //myWebSocket.session.getBasicRemote().sendText("<img src=''/>");
        }
    }

    /**
     * 实现服务器主动推送
     */
    public void sendMessage(String message) throws IOException {
        this.session.getBasicRemote().sendText(message);
    }

    /**
     * 群发自定义消息
     */
    public static void sendInfo(String message, @PathParam("sid") String sid) throws IOException {
        log.info("推送消息到窗口" + sid + "，推送内容:" + message);
        for (MyWebSocket item : user) {
            try {
                //这里可以设定只推送给这个sid的，为null则全部推送
                if (sid == null) {
                    item.sendMessage(message);
                } else if (item.session.getId().equals(sid)) {
                    item.sendMessage(message);
                }
            } catch (IOException ignored) {
            }
        }
    }

    /**
     * 连接建立成功调用的方法
     */
    @OnOpen
    public void onOpen(Session session) {
        System.out.println(session.getId() + " open...");
        this.session = session;
        user.add(this);
    }

    /**
     * 连接关闭调用的方法
     */
    @OnClose
    public void onClose() {
        System.out.println(this.session.getId() + " close...");
        user.remove(this);
    }

    @OnError
    public void onError(Session session, Throwable error) {
        System.out.println(this.session.getId() + " error...");
        error.printStackTrace();
    }
}
