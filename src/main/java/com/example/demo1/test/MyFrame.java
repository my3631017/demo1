package com.example.demo1.test;

import com.example.demo1.panel.Panel1;

import javax.swing.*;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-02-14 16:56
 */
public class MyFrame extends JFrame {

    public MyFrame() throws Exception {
        super();
        setTitle("博智擎天OPC客户端");
        setBounds(100, 100, 1080, 720);
        add(new Panel1());
    }

    public static void main(String[] args) throws Exception {
        new MyFrame().setVisible(true);
    }
}
