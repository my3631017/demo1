package com.example.demo1.test;

import java.text.SimpleDateFormat;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-01-16 14:38
 */
public class Test implements Runnable {
    public static final Double DOUBLE_ZERO = 0.0000;

    private static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @Override
    public void run() {

    }

    public void nineXnine() {
        for (int i = 1; i < 10; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + "*" + i + "=" + i * j + "  ");
            }
            System.out.println();
        }
    }

    public void shuixianhua() {
        for (int i = 1; i <= 9; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= 9; k++) {
                    int x = i * i * i + j * j * j + k * k * k;
                    int y = i * 100 + j * 10 + k;
                    if (x == y) {
                        System.out.println(x);
                    }
                }
            }
        }
    }

    private static String replaceDataCode(String expression) {
        expression = expression.replace(" ", "")
                .replaceAll("(Count)(\\d{10})", "0.156155");
        return expression;
    }

    public static void main(String[] args) {

    }
}
