package com.example.demo1.excel;

import lombok.Data;

import javax.persistence.Transient;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-04-18 16:36
 */
@Data
public class Plan {
    @Transient
    private String date;
    @Transient
    private String basic;
    @Transient
    private String plan;
    @Transient
    private String struggle;
    @Transient
    private String actual;
}
