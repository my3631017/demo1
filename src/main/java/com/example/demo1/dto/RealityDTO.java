package com.example.demo1.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * comment
 *
 * @author 破冰
 * @review 破冰
 * @date: 2019-04-25 09:57
 */
@Data
public class RealityDTO {
    @ApiModelProperty("白班产量")
    private Double dayYield;
    @ApiModelProperty("白班计划产量")
    private Double dayPlanYield;
    @ApiModelProperty("白班完成率")
    private Double dayPercent;

    @ApiModelProperty("夜班产量")
    private Double nightYield;
    @ApiModelProperty("夜班计划产量")
    private Double nightPlanYield;
    @ApiModelProperty("夜班完成率")
    private Double nightPercent;

    @ApiModelProperty("全天产量")
    private Double allDayYield;
    @ApiModelProperty("全天计划产量")
    private Double allDayPlanYield;
    @ApiModelProperty("全天完成率")
    private Double allDayPercent;

    @ApiModelProperty("进行中的班次，day:白班，night:夜班，null:都没在进行中")
    private String isOngoing;
}
