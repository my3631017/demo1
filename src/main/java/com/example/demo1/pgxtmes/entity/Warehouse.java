package com.example.demo1.pgxtmes.entity;

import lombok.Data;

import java.util.Date;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-04-15 15:48
 */
@Data
public class Warehouse {
    /**
     * 主键ID
     */
    private String id;
    /**
     * 班别时间
     */
    private Date workTime;
    /**
     * 产线id
     */
    private String productLineId;
    /**
     * 产线名称
     */
    private String productLineName;
    /**
     * 入库吨数
     */
    private Double tonneVale;
    /**
     * 入库包数
     */
    private Integer packetNumber;
    /**
     * 批次号
     */
    private String batch;
    /**
     * 品位值
     */
    private Double gradePercent;
    /**
     * 仓区id
     */
    private String warehouseId;
    /**
     * 入库时间
     */
    private Date warehouseTime;
    /**
     * 创建人id
     */
    private String createUserId;
    /**
     * 创建人名称
     */
    private String createUserName;
}
