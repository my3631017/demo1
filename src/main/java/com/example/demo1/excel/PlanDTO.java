package com.example.demo1.excel;

import lombok.Data;

import java.util.Date;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-04-12 17:31
 */
@Data
public class PlanDTO {
    private String line;
    private Date month;
    private Double basic;
    private Double plan;
    private Double struggle;
    private Double actual;
}
