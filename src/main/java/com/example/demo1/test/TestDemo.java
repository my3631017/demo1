package com.example.demo1.test;

import java.util.ArrayList;
import java.util.List;

/**
 * comment
 *
 * @author: 通天晓107
 * @review:
 * @date: 2018-11-02 14:08
 * @version: 1.0
 */
public class TestDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(2);
        System.out.println(list.toString());
        System.out.println(list.toString().equals("[2]"));
    }
}
