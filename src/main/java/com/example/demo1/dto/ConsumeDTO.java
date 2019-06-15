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
public class ConsumeDTO {
    @ApiModelProperty("消耗类型")
    private String resourcesInfoName;

    @ApiModelProperty("白班用量")
    private Double dayUsedCount;
    @ApiModelProperty("白班吨耗")
    private Double dayTonneConsumptionValue;

    @ApiModelProperty("夜班用量")
    private Double nightUsedCount;
    @ApiModelProperty("夜班吨耗")
    private Double nightTonneConsumptionValue;

    private String xys;
    @ApiModelProperty("全天用量")
    private Double allDayUsedCount;
    @ApiModelProperty("全天吨耗")
    private Double allDayTonneConsumptionValue;
}
