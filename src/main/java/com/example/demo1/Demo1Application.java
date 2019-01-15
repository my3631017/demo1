package com.example.demo1;

import com.example.demo1.config.nettywebsocket.NettyWebSocketServer;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@MapperScan("com.example.demo1.dao")
@EnableScheduling
public class Demo1Application {

    public static void main(String[] args) throws Exception{
        ConfigurableApplicationContext context = SpringApplication.run(Demo1Application.class, args);
        NettyWebSocketServer webSocketServer = context.getBean(NettyWebSocketServer.class);
        webSocketServer.run();
    }
}
