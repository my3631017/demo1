package com.example.demo1.pgxtmes.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-03-19 11:08
 */
@Data
public class MonthPlanDetailDTO {
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("日期(年月)")
    private Date yearMonth;
    @ApiModelProperty("实际产量")
    private Double actualOutput;
    @ApiModelProperty("当月工作天数,实际工作天数")
    private Double actualWorkingDays;
    @ApiModelProperty("产线ID")
    private String ha;

    @ApiModelProperty("当月日历天数")
    private Integer calendarDays;
    @ApiModelProperty("计划检修时间,多个时间区间组成的数组，一个区间是一个对象，传json形式")
    private String plannedMaintenanceTime;
    @ApiModelProperty("计划检修时长")
    private Double plannedOverhaulTime;
    @ApiModelProperty("基本目标产量")
    private Double basicTargetYield;
    @ApiModelProperty("奋斗目标产量")
    private Double struggleTargetYield;
    @ApiModelProperty("基本目标完成率")
    private Double basicTargetFinishPercent;
    @ApiModelProperty("奋斗目标完成率")
    private Double struggleTargetFinishPercent;
    @ApiModelProperty("状态(1未开始、2进行中、3已完成)")
    private Integer planStatus;
}
