package com.example.demo1.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-01-04 17:28
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class User extends IdEntity implements Serializable {
    private String username;
    private Integer age;
    private String description;
    private String height;
}
