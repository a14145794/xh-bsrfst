package com.xhnew.st.domain.bo;

import com.xhnew.st.common.validate.AddGroup;
import com.xhnew.st.common.validate.EditGroup;
import com.xhnew.st.domain.base.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


/**
 * 地址简介业务对象 d_address_about
 *
 * @author mashiro
 * @date 2022-03-21
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("地址简介业务对象")
public class AddressAboutBo extends BaseEntity {

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键", required = true)
    @NotNull(message = "主键不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 建筑名称
     */
    @ApiModelProperty(value = "建筑名称", required = true)
    @NotBlank(message = "建筑名称不能为空", groups = { AddGroup.class, EditGroup.class })
    private String buildingName;

    /**
     * 建筑位置
     */
    @ApiModelProperty(value = "建筑位置")
    private String buildingLocation;

    /**
     * 建筑简介
     */
    @ApiModelProperty(value = "建筑简介")
    private String buildingIntroduction;

    /**
     * 建筑类别
     */
    @ApiModelProperty(value = "建筑类别")
    private String buildingCategory;

    /**
     * 所属单位
     */
    @ApiModelProperty(value = "所属单位")
    private String subordinateUnits;

    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话")
    private String phone;

    /**
     * 权级
     */
    @ApiModelProperty(value = "权级")
    private String rightLevel;

    /**
     * 所属场景
     */
    @ApiModelProperty(value = "所属场景")
    private String subordinateToScene;

    /**
     * 经度
     */
    @ApiModelProperty(value = "经度")
    private String longitude;

    /**
     * 纬度
     */
    @ApiModelProperty(value = "纬度")
    private String latitude;


}
