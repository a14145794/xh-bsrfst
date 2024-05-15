package com.xhnew.st.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.List;


/**
 * 单元下的户室集合
 *
 * @author mashiro
 * @date 2022-03-20
 */
@Data
@ApiModel("单元下的户室集合")
public class UnitRoomVo {

    private static final long serialVersionUID = 1L;

    /**
     * 总户数
     */
    @ApiModelProperty("单元")
    private String unit;

    /**
     * 自住户数
     */
    @ApiModelProperty("单元下户室(逗号分隔)")
    private String rooms;

    /**
     * 居住总人数
     */
    @ApiModelProperty("户室集合")
    private List<String> roomList;


}
