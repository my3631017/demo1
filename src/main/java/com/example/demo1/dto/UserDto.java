package com.example.demo1.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * comment
 *
 * @author: 通天晓107
 * @review:
 * @date: 2018-11-02 14:05
 * @version: 1.0
 */
@Data
public class UserDto<T> implements Serializable {
    private String username;
    private Integer age;
    private T data;

    public UserDto(String username, Integer age, T data) {
        this.username = username;
        this.age = age;
        this.data = data;
    }
}
