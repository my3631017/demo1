package com.example.demo1.entity;

import lombok.Data;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-01-04 17:28
 */
@Data
public class Parent {
    private Long id;
    private String hello = "Hello PoBing!";

    private int sum(int a, int b) {
        return a + b;
    }

    public int multiplication(int a, int b) {
        return a * b;
    }
}
