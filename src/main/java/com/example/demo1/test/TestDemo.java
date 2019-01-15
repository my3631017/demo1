package com.example.demo1.test;

import java.io.*;
import java.net.URL;
import java.net.URLConnection;
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

    public static String exchange(String s) {
        if (s == null) {
            System.out.println("数据为空");
            return "";
        }
        char[] chars = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char aChar : chars) {
            String s1 = Integer.toHexString(aChar);
            String s2 = Long.toHexString(aChar);
            //加toUpperCase把小写字母变大写
            sb.append(Long.toHexString(aChar).toUpperCase());
        }
        return sb.toString();
    }

    public static List<String> getNumber(String num) {
        StringBuilder sb = new StringBuilder();
        char[] chars = num.toCharArray();
        List<String> numbers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    //前3位
                    sb.append(num);
                    //第4位
                    sb.append(i);
                    //第5位
                    sb.append(k);
                    //第6位
                    sb.append(j);
                    //第7位
                    sb.append(k);
                    //第8位
                    sb.append(i);
                    //第9位
                    sb.append(chars[2]);
                    //第10位
                    sb.append(chars[1]);
                    //第11位
                    sb.append(chars[0]);
                    //添加到集合
                    numbers.add(sb.toString());
                    sb = new StringBuilder();
                }
            }
        }
        return numbers;
    }

    /**
     * 分析指定html页面返回的数据
     *
     * @param number 组成url的手机号
     * @return s
     * @throws IOException e
     */
    public static String html(String number) throws IOException {
        String uri = "http://www.69696969.com/cardlist-yys-0,hd-0,jg-0,ws-0,lh-0,ts-0,kd-0,px-0,page-0,key-";
        /*
          首先要和URL下的URLConnection对话。 URLConnection可以很容易的从URL得到。比如： // Using
           java.net.URL and //java.net.URLConnection
         */
        URL url = new URL(uri + number);
        URLConnection connection = url.openConnection();
        /*
         * 然后把连接设为输出模式。URLConnection通常作为输入来使用，比如下载一个Web页。
         * 通过把URLConnection设为输出，你可以把数据向你个Web页传送。下面是如何做：
         */
        connection.setDoOutput(true);
        /*
         * 最后，为了得到OutputStream，简单起见，把它约束在Writer并且放入POST信息中，例如： ...
         */
        OutputStreamWriter out = new OutputStreamWriter(connection
                .getOutputStream(), "8859_1");
        out.write("username=kevin&password=*********"); //post的关键所在！
        // remember to clean up
        out.flush();
        out.close();
        /*
         * 这样就可以发送一个看起来象这样的POST：
         * POST /jobsearch/jobsearch.cgi HTTP 1.0 ACCEPT:
         * text/plain Content-type: application/x-www-form-urlencoded
         * Content-length: 99 username=bob password=someword
         */
        // 一旦发送成功，用以下方法就可以得到服务器的回应：
        String sCurrentLine;
        StringBuilder sTotalString;
        sTotalString = new StringBuilder();
        InputStream l_urlStream;
        l_urlStream = connection.getInputStream();
        // 传说中的三层包装阿！
        BufferedReader l_reader = new BufferedReader(new InputStreamReader(l_urlStream));
        while ((sCurrentLine = l_reader.readLine()) != null) {
            sTotalString.append(sCurrentLine).append("/r/n");

        }
//        System.out.println(sTotalString);
        return sTotalString.toString();
    }

    public static String test(String phone) throws IOException {
        //发送请求到页面，返回数据
        String s = html(phone);
        //分析返回数据
        if (s.contains("号码已售")) {
            return "号码已售";
        } else {
            int x = s.indexOf("￥");
            int y = s.indexOf("元");
            return phone + "  " + s.substring(x, y + 1);
        }
    }

    public static void main(String[] args) throws Exception {
    }
}
