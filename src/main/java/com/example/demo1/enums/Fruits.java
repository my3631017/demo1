package com.example.demo1.enums;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-01-04 17:28
 */
public enum Fruits {
    apple("苹果", 2), banana("香蕉", 3), watermelon("西瓜", 1);

    private String name;
    private Integer code;

    private Fruits(String name, Integer code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public static void main(String[] args) {
        System.out.println(Fruits.apple.getName());
    }
}
