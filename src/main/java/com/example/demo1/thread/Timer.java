package com.example.demo1.thread;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-02-27 11:47
 */
public class Timer extends Thread {

    public static String trans(Double value) {
        if (value.toString().contains("E")) {
            String value2 = value.toString();
            String[] split = value2.split("E");
            Integer b = Integer.valueOf(split[1]);
            StringBuilder sb = new StringBuilder(split[0]);
            sb.deleteCharAt(1);
            sb.insert(1 + b, ".");
            return sb.toString();
        } else {
            return value.toString();
        }
    }

    public static void main(String[] args) {
        Double value = 2.227340543395435E50;
        System.out.println(trans(value));
    }

}
