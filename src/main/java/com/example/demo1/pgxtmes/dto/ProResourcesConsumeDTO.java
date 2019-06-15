package com.example.demo1.pgxtmes.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-04-22 17:58
 */
@Data
public class ProResourcesConsumeDTO {
    @ApiModelProperty("id")
    private String id;
    @ApiModelProperty("开始日期")
    private Date beginDay;
    @ApiModelProperty("开始班组")
    private String beginWorkTeamCode;
    @ApiModelProperty("开始班组名称（甲乙丙丁）")
    private String beginWorkTeamName;
    @ApiModelProperty("开始班次")
    private String beginWorkTeamTypeCode;
    @ApiModelProperty("开始班次（白班夜班）")
    private String beginWorkTeamTypeName;
    @ApiModelProperty("结束日期")
    private Date endDay;
    @ApiModelProperty("结束班组")
    private String endWorkTeamCode;
    @ApiModelProperty("结束班组（甲乙丙丁）")
    private String endWorkTeamName;
    @ApiModelProperty("结束班次")
    private String endWorkTeamTypeCode;
    @ApiModelProperty("结束班次名称（白班夜班）")
    private String endWorkTeamTypeName;
    @ApiModelProperty("产线")
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

    private String resourcesTypeCode;
    @ApiModelProperty("资源类型名称（辅料、原料）")
    private String resourcesTypeName;
    @ApiModelProperty("资源详细code")
    private String resourcesInfoCode;
    @ApiModelProperty("资源详细名称（硫酸、原矿、湿矿等）")
    private String resourcesInfoName;
    @ApiModelProperty("用量")
    private Double usedCount;
    @ApiModelProperty("单位")
    private String unitCode;
    @ApiModelProperty("单位名")
    private String unitName;
    @ApiModelProperty("备注")
    private String remark;
    @ApiModelProperty("数据来源")
    private String dataSourcesCode;
    @ApiModelProperty("数据来源名")
    private String dataSourcesName;

    @ApiModelProperty("操作人id")
    private String createUserId;
    @ApiModelProperty("操作人名")
    private String createUsername;
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+excercise8")
    @ApiModelProperty("操作时间")
    private Date createTime;
}
