package com.example.demo1.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-01-04 17:28
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
