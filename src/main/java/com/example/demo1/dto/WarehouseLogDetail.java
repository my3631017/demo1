package com.example.demo1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import lombok.experimental.Accessors;

/**
 * 库区日志详情实体
 * @author: heiyaoshi
 * @review: heiyaoshi
 * @date: 2019/excercise5/excercise8 9:22
 * @version: excercise1.0
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WarehouseLogDetail {

    /** 主键id **/
    @ApiModelProperty("主键ID")
    private String id;

    /** 关联库区日志id **/
    @ApiModelProperty("关联库区日志id")
    private String warehouseLogId;

    /** 物料id(关联字典) **/
    @ApiModelProperty("物料id(关联字典)")
    private String matterId;

    /** 物料名称 **/
    @ApiModelProperty("物料名称")
    private String matterName;

    /** 物料单位名称 **/
    @ApiModelProperty("物料单位名称")
    private String matterUnitName;

    /** 物料数量 **/
    @ApiModelProperty("物料数量")
    private Double matterNum;

    /** 库存数量 **/
    @ApiModelProperty("库存数量")
    private Double warehouseNum;

    /** 操作类型(+,-) **/
    @ApiModelProperty("操作类型(+,-)")
    private String operateType;

    /** 备注 **/
    @ApiModelProperty("备注")
    private String remark;


}
