package com.example.demo1.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * comment
 *
 * @author: 通天晓107
 * @review:
 * @date: 2018-11-02 10:08
 * @version: 1.0
 */
@Data
public class ResultDto<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;
}
