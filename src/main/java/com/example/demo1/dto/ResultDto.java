package com.example.demo1.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-01-04 17:28
 */
@Data
public class ResultDto<T> implements Serializable {
    private Integer code;
    private String message;
    private T data;
}
