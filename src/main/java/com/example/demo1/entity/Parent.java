package com.example.demo1.entity;

import lombok.Data;

/**
 * comment
 *
 * @author: 通天晓107
 * @review:
 * @date: 2018-11-08 15:39
 * @version: 1.0
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
