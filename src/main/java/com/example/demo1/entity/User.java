package com.example.demo1.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * comment
 *
 * @author: 通天晓107
 * @review:
 * @date: 2018-10-30 10:59
 * @version: 1.0
 */
@Data
public class User extends IdEntity implements Serializable {
    //    private Integer id;
    private String username;
    private Integer age;
}
