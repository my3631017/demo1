package com.example.demo1.panel;

import lombok.extern.slf4j.Slf4j;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-02-19 11:50
 */
@Slf4j
public class Panel1 extends JPanel {

    public Panel1(){
        super();
        setBorder(BorderFactory.createTitledBorder("王小虎"));
        setLayout(new GridLayout(1,1));

        JButton test = new JButton("测试");
        test.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
               log.info("鼠标点击测试");
            }
        });
    }
}
