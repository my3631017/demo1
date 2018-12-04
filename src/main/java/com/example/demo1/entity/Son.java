package com.example.demo1.entity;

/**
 * comment
 *
 * @author: 通天晓107
 * @review:
 * @date: 2018-11-08 15:43
 * @version: 1.0
 */
public class Son extends Parent {
    public static void main(String[] args) {
        Son son=new Son();
        System.out.println(son.getHello());
        System.out.println(son.multiplication(5,6));
    }
}
