package com.xhnew.st.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 人房上图视图对象 d_person_address_sb
 *
 * @author mashiro
 * @date 2022-03-20
 */
@Data
@ApiModel("上保统计信息")
public class IndexMessageSbVo {

    private static final long serialVersionUID = 1L;

    /**
     * 总户数
     */
    @ApiModelProperty("总户数")
    private Long roomCount;

    /**
     * 自住户数
     */
    @ApiModelProperty("自住户数")
    private Long oneself;

    /**
     * 出租户数
     */
    @ApiModelProperty("出租户数")
    private Long taxiNumber;

    /**
     * 空置户数
     */
    @ApiModelProperty("空置户数")
    private Long vacancyNumber;

    /**
     * 出租户数
     */
    @ApiModelProperty("其他类型")
    private Long otherSelf;

    /**
     * 实有人口
     */
    @ApiModelProperty("实有人口")
    private Long actualPopulation;

    /**
     * 常住人口
     */
    @ApiModelProperty("常住人口")
    private Long permanentPopulation;

    /**
     * 流动人口
     */
    @ApiModelProperty("流动人口")
    private Long floatingPopulation;

    /**
     * 其他人口
     */
    @ApiModelProperty("其他人口")
    private Long othersPopulation;

    /**
     * 唯一码
     */
    @ApiModelProperty("唯一码")
    private String onlyCode;
}
