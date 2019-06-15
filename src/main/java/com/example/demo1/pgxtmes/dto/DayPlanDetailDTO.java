package com.example.demo1.pgxtmes.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-03-19 11:58
 */
@Data
public class DayPlanDetailDTO {
    @ApiModelProperty("基本目标产量,计划产量")
    private Double basicTargetYield;
    @ApiModelProperty("实际产量")
    private Double actualOutput;
    @ApiModelProperty("已生产时间")
    private Double WorkingTime;

    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("产线ID")
    private String productLineId;
    @ApiModelProperty("日期(年月日)")
    private Date day;
    @ApiModelProperty("班别ID --关联字典表（早班，晚班）")
    private String workTeamTypeId;
    @ApiModelProperty("班别名称,（早班，晚班）")
    private String workTeamTypeName;
    @ApiModelProperty("班组ID --关联字典表(甲、乙、丙、丁)")
    private String workTeamId;
    @ApiModelProperty("班组名称")
    private String workTeamName;
    @ApiModelProperty("排班规则,ID")
    private String schedulingRule;
    @ApiModelProperty("日计划转结状态")
    private Integer planStatus;
    @ApiModelProperty("计划检修时间,多个时间区间组成的数组，一个区间是一个对象，传json形式")
    private String plannedMaintenanceTime;
    @ApiModelProperty("计划检修时长")
    private Double plannedOverhaulTime;
    @ApiModelProperty("实际工作时长")
    private Double actualWorkingTime;
    @ApiModelProperty("奋斗目标产量")
    private Double struggleTargetYield;
    @ApiModelProperty("基本目标完成率")
    private Double basicTargetFinishPercent;
    @ApiModelProperty("奋斗目标完成率")
    private Double struggleTargetFinishPercent;
}
