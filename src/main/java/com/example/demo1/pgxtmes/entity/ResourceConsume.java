package com.example.demo1.pgxtmes.entity;

import lombok.Data;

import java.util.Date;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-04-15 15:42
 */
@Data
public class ResourceConsume {
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
     * 产品名称
     */
    private String pmName;
    /**
     * 作业区id
     */
    private String produceAreaId;
    /**
     * 作业区名称
     */
    private String produceAreaName;
    /**
     * 工序id
     */
    private String processesId;
    /**
     * 工序名称
     */
    private String processesName;
    /**
     * 消耗资源类型
     */
    private Integer consumeResourceType;
    /**
     * 消耗总量
     */
    private Double totalConsume;
    /**
     * 吨耗值
     */
    private Double tonneConsumptionValue;
    /**
     * 单位（id)
     */
    private String unitId;
    /**
     * 单位(名称)
     */
    private String unitName;
    /**
     * 备注
     */
    private String remark;
    /**
     * 消耗时间
     */
    private Date consumeTime;
    /**
     * 数据来源
     */
    private Integer dataSource;
    /**
     * 创建人id
     */
    private String createUserId;
    /**
     * 创建人名称
     */
    private String createUserName;
    /**
     * 创建时间
     */
    private Date createTime;
}
