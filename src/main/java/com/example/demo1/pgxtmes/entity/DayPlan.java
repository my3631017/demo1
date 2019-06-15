package com.example.demo1.pgxtmes.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-03-18 17:05
 */
@Data
public class DayPlan {
    /**
     * 主键ID
     */
    private String id;
    /**
     * 年度计划ID
     */
    private String planYearId;
    /**
     * 月计划ID
     */
    private String planMonthId;
    /**
     * 日期(年月日)
     */
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date day;
    /**
     * 工作班组、甲乙丙丁
     */
    private String workTeamName;
    /**
     * 工作班别、白班夜班
     */
    private String workTeamTypeName;
    /**
     * 工作时间段
     */
    private String workTimeSlot;
    /**
     * 计划检修时间
     */
    private String plannedMaintenanceTime;
    /**
     * 计划检修时长
     */
    private Double plannedOverhaulTime;
    /**
     * 实际工作时长
     */
    private Double actualWorkingTime;
    /**
     * 基本目标产量
     */
    private Double basicTargetYield;
    /**
     * 干燥1线基本目标产量
     */
    private Double basicTargetYieldOne;
    /**
     * 干燥2线基本目标产量
     */
    private Double basicTargetYieldTwo;
    /**
     * 奋斗目标产量
     */
    private Double struggleTargetYield;
    /**
     * 实际产量
     */
    private Double actualOutput;
    /**
     * 干燥1线实际产量
     */
    private Double actualOutputOne;
    /**
     * 干燥2线实际产量
     */
    private Double actualOutputTwo;
    /**
     * 基本目标完成率
     */
    private Double basicTargetFinishPercent;
    /**
     * 干燥1线基本目标完成率
     */
    private Double basicTargetFinishPercentOne;
    /**
     * 干燥2线基本目标完成率
     */
    private Double basicTargetFinishPercentTwo;
    /**
     * 奋斗目标完成率
     */
    private Double struggleTargetFinishPercent;
}
