package com.example.demo1.pgxtmes.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * 库区日志实体
 *
 * @author: heiyaoshi
 * @review: heiyaoshi
 * @date: 2019/excercise5/excercise7 17:37
 * @version: excercise1.0
 */

@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
public class WarehouseLog {

    /**
     * 主键id
     **/
    @ApiModelProperty("主键ID")
    private String id;

    /**
     * 关联库区ID
     **/
    @ApiModelProperty("关联库区ID")
    private String warehouseId;

    /**
     * 关联订单表ID
     **/
    @ApiModelProperty("关联订单表ID")
    private String orderId;

    /**
     * 日志名称
     **/
    @ApiModelProperty("日志名称")
    private String recordName;

    /**
     * 出/入/盘库记录时间
     **/
    @ApiModelProperty("出/入/盘库记录时间")
    private Date recordTime;

    /**
     * 类型(excercise1:出库、excercise2:入库、excercise3:盘库)
     **/
    @ApiModelProperty("类型(excercise1:出库、excercise2:入库、excercise3:盘库)")
    private Integer recordType;

    /**
     * 管理用户
     **/
    @ApiModelProperty("管理用户")
    private String manageUser;

    /**
     * 目标用户
     **/
    @ApiModelProperty("目标用户")
    private String destUser;

    /**
     * (目标用户)所属产线ID
     **/
    @ApiModelProperty("(目标用户)所属产线ID")
    private String destUserLineId;

    /**
     * (操作用户)所属部门ID
     **/
    @ApiModelProperty("(操作用户)所属部门ID")
    private String destUserDeptId;

    /**
     * 来源类型(excercise1:手动、excercise2:自动)
     **/
    @ApiModelProperty("来源类型(excercise1:手动、excercise2:自动)")
    private Integer dataSourceType;

    /**
     * 盘库类型(1盘盈，2盘亏)
     **/
    @ApiModelProperty("盘库类型(1盘盈，2盘亏)")
    private Integer inventoryType;

    /**
     * 盘库数量(多个物料的时候无法计算)
     **/
    @ApiModelProperty("盘库数量(多个物料的时候无法计算)")
    private Integer inventoryCount;

    /**
     * 物料名称
     **/
    @ApiModelProperty("物料名称")
    private String materielName;

    /**
     * 描述
     **/
    @ApiModelProperty("描述")
    private String remark;

    /**
     * 创建时间
     **/
    @ApiModelProperty("创建时间")
    private Date createTime;

    /**
     * 创建人ID
     **/
    @ApiModelProperty("创建人ID")
    private String createUserId;

    /**
     * 创建人名称
     **/
    @ApiModelProperty("创建人名称")
    private String createUsername;


}
