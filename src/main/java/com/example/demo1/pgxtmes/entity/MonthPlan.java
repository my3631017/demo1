package com.example.demo1.pgxtmes.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-03-18 17:18
 */
@Data
public class MonthPlan {
    /**
     * 主键ID
     */
    private String id;
    /**
     * 年度计划ID
     */
    private String planYearId;
    /**
     * 日期(年月)
     */
    @DateTimeFormat(pattern = "yyyy-MM")
    private Date yearMonth;
    /**
     * 当月日历天数
     */
    private Integer calendarDays;
    /**
     * 计划检修时间
     */
    private String plannedMaintenanceTime;
    /**
     * 计划检修时长
     */
    private Double plannedOverhaulTime;
    /**
     * 实际工作天数
     */
    private Double actualWorkingDays;
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
}
