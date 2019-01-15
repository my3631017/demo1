package com.example.demo1.service;

import com.example.demo1.entity.WebSocketResponse;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-01-04 10:15
 */
public interface WebSocketService {
    void send(WebSocketResponse request) throws Exception;
}
