package com.example.demo1.pgxtmes.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-03-19 11:50
 */
@Data
public class YearPlanDetailDTO {
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("产线ID")
    private String productLineId;
    @ApiModelProperty("计划年度")
    private Integer plannedYear;
    @ApiModelProperty("工作天数")
    private Double workDayCount;
    @ApiModelProperty("基本目标产量")
    private Double basicTargetYield;
    @ApiModelProperty("奋斗目标产量")
    private Double struggleTargetYield;
    @ApiModelProperty("实际产量")
    private Double actualOutput;
    @ApiModelProperty("回收率")
    private Double rateOfRecovery;
    @ApiModelProperty("基本目标完成率")
    private Double basicTargetFinishPercent;
    @ApiModelProperty("奋斗目标完成率")
    private Double struggleTargetFinishPercent;
    @ApiModelProperty("年平均品位值")
    private Double yearAverageGradePercent;
    @ApiModelProperty("创建时间")
    private Date createTime;
    @ApiModelProperty("状态(1草稿、2进行中、3已完成)")
    private Integer planStatus;

    @ApiModelProperty("计划开始时间")
    private Date beginDate;
    @ApiModelProperty("计划结束时间")
    private Date endDate;
    @ApiModelProperty("产线名称")
    private String productLineName;
    @ApiModelProperty("计划品位")
    private String gradePercent;
    @ApiModelProperty("开始班别ID")
    private String beginWorkTeamTypeId;
    @ApiModelProperty("开始班别名称")
    private String beginWorkTeamTypeName;
    @ApiModelProperty("开始班组ID")
    private String beginWorkTeamId;
    @ApiModelProperty("开始班组名称")
    private String beginWorkTeamName;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("排班规则，ID")
    private String schedulingRule;
    @ApiModelProperty("对比年份")
    private Integer comparativeYear;
    @ApiModelProperty("创建人")
    private String createUsername;

    @ApiModelProperty("各月计划详情")
    private List<MonthPlanDetailDTO> monthPlanDetailDTOList;

    // 以下8个字段为干燥产线兼容字段
    @ApiModelProperty("idTwo")
    private String idTwo;
    @ApiModelProperty("产线IdTwo")
    private String productLineIdTwo;
    @ApiModelProperty("实际产量One")
    private Double actualOutputOne;
    @ApiModelProperty("实际产量Two")
    private Double actualOutputTwo;
    @ApiModelProperty("基本目标产量,计划产量One")
    private Double basicTargetYieldOne;
    @ApiModelProperty("基本目标完成率One")
    private Double basicTargetFinishPercentOne;
    @ApiModelProperty("基本目标产量,计划产量Two")
    private Double basicTargetYieldTwo;
    @ApiModelProperty("基本目标完成率Two")
    private Double basicTargetFinishPercentTwo;
}
