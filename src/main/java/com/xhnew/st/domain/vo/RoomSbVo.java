package com.xhnew.st.domain.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;


/**
 * 单元下的户室集合
 *
 * @author mashiro
 * @date 2022-03-20
 */
@Data
@ApiModel("上保单元下的户室集合")
public class RoomSbVo {

    private static final long serialVersionUID = 1L;

    /**
     * 房间号
     */
    @ApiModelProperty("房间号")
    private String room_num;

    /**
     * 房间状态
     */
    @ApiModelProperty("房间状态")
    private String room_status;


}
