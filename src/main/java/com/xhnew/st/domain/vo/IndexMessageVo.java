package com.xhnew.st.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 人房上图视图对象 d_person_address
 *
 * @author mashiro
 * @date 2022-03-20
 */
@Data
@ApiModel("统计信息")
public class IndexMessageVo {

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
     * 出租户数
     */
    @ApiModelProperty("其他类型")
    private Long otherSelf;

    /**
     * 空置数
     */
    @ApiModelProperty("空置数")
    private Long vacancyNumber;

    /**
     * 居住总人数
     */
    @ApiModelProperty("居住总人数")
    private Long personSum;

    /**
     * 唯一码
     */
    @ApiModelProperty("唯一码")
    private String onlyCode;


}
