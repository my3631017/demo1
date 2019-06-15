package com.example.demo1.pgxtmes.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-03-18 17:25
 */
@Data
public class YearPlan {
    // 主键ID
    private String id;
    // 计划开始时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date beginDate;
    // 计划结束时间
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date endDate;
    // 产线ID
    private String productLineId;
    // 产线名称
    private String productLineName;
    // 基本目标产量
    private Double basicTargetYield;
    // 奋斗目标产量
    private Double struggleTargetYield;
    // 计划品位
    private String gradePercent;
    // 开始班组ID
    private String beginWorkTeamId;
    // 开始班组名称
    private String beginWorkTeamName;
    // 开始班别ID
    private String beginWorkTeamTypeId;
    // 开始班别名称
    private String beginWorkTeamTypeName;
    // 排班规则，ID
    private String schedulingRule;
    // 对比年份
    private Integer comparativeYear;
    // 计划年度
    private Integer plannedYear;
    // 工作天数
    private Double workDayCount;
    // 实际产量
    private Double actualOutput;
    // 回收率
    private Double rateOfRecovery;
    // 基本目标完成率
    private Double basicTargetFinishPercent;
    // 奋斗目标完成率
    private Double struggleTargetFinishPercent;
    // 状态(1草稿、2进行中、3已完成)
    private Integer planStatus;
    // 年平均品位值
    private Double yearAverageGradePercent;
    // 备注
    private String remark;
    // 状态（-excercise1:删除，excercise1：正常 excercise2：禁用 ）
    private Integer dataStatus;
    // 创建时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;
    // 创建人ID
    private String createUserId;
    // 创建人名称
    private String createUsername;
    // 修改时间
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;
    // 修改人ID
    private String updateUserId;
    // 修改人名称
    private String updateUsername;
}
