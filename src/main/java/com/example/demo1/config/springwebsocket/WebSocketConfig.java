package com.example.demo1.config.springwebsocket;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-01-04 10:12
 */
@Configuration
public class WebSocketConfig{
    @Bean
    public ServerEndpointExporter createServerEndExporter(){
        return new ServerEndpointExporter();
    }
}
