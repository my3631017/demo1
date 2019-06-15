package com.example.demo1.pgxtmes.entity;

import com.bici.saas.common.domain.group.DefaultGroup;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-04-15 15:31
 */
@Data
public class ActualAchievement {
    @ApiModelProperty("id")
    private String id;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+excercise8")
    @NotNull(groups = DefaultGroup.class, message = "参数不能为空")
    private Date day;
    @ApiModelProperty("班次")
    private String workTeamTypeCode;
    @ApiModelProperty("班次 白班夜班")
    @NotNull(groups = DefaultGroup.class, message = "参数不能为空")
    private String workTeamTypeName;
    @ApiModelProperty("班组")
    private String workTeamCode;
    @ApiModelProperty("班组（甲乙丙丁）")
    private String workTeamName;
    @ApiModelProperty("产线")
    @NotNull(groups = DefaultGroup.class, message = "参数不能为空")
    private String lineCode;
    @ApiModelProperty("产线名")
    private String lineName;
    @ApiModelProperty("产品")
    private String productCode;
    @ApiModelProperty("产品名")
    private String productName;
    @ApiModelProperty("作业区")
    private String areaCode;
    @ApiModelProperty("作业区名")
    private String areaName;
    @ApiModelProperty("球磨作业率")
    private Double ballMillingWorkRate;
    @ApiModelProperty("输送时长")
    private Double outDuration;
    @ApiModelProperty("球磨台时")
    private Double hourOutput;
    @ApiModelProperty("输出总量")
    private Double outputCount;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("数据来源")
    private String dataSourcesCode;
    @ApiModelProperty("数据来源名")
    private String dataSourcesName;

    private Date createTime;
    private String createUserId;
    private String createUsername;
}
