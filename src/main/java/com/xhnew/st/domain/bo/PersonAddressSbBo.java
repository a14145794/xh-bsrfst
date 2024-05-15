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
import java.util.Date;

/**
 * 人房上图业务对象 d_person_address_sb
 *
 * @author mashiro
 * @date 2022-04-06
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("人房上图业务对象")
public class PersonAddressSbBo extends BaseEntity {

    /**
     * 主键
     */
    @ApiModelProperty(value = "主键", required = true)
    @NotNull(message = "主键不能为空", groups = { EditGroup.class })
    private Long id;

    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名", required = true)
    @NotBlank(message = "姓名不能为空", groups = { AddGroup.class, EditGroup.class })
    private String name;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别", required = true)
    @NotBlank(message = "性别不能为空", groups = { AddGroup.class, EditGroup.class })
    private String sex;

    /**
     * 电话
     */
    @ApiModelProperty(value = "电话", required = true)
    @NotBlank(message = "电话不能为空", groups = { AddGroup.class, EditGroup.class })
    private String phone;

    /**
     * 证件号码
     */
    @ApiModelProperty(value = "证件号码", required = true)
    @NotBlank(message = "证件号码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String idNumber;

    /**
     * 民族
     */
    @ApiModelProperty(value = "民族", required = true)
    @NotBlank(message = "民族不能为空", groups = { AddGroup.class, EditGroup.class })
    private String national;

    /**
     * 户籍信息
     */
    @ApiModelProperty(value = "户籍信息", required = true)
    @NotBlank(message = "户籍信息不能为空", groups = { AddGroup.class, EditGroup.class })
    private String registrationStatus;

    /**
     * 与户主关系
     */
    @ApiModelProperty(value = "与户主关系", required = true)
    @NotBlank(message = "与户主关系不能为空", groups = { AddGroup.class, EditGroup.class })
    private String relationshipToHouseholder;

    /**
     * 地址
     */
    @ApiModelProperty(value = "地址", required = true)
    @NotBlank(message = "地址不能为空", groups = { AddGroup.class, EditGroup.class })
    private String address;

    /**
     * 楼栋
     */
    @ApiModelProperty(value = "楼栋", required = true)
    @NotBlank(message = "楼栋不能为空", groups = { AddGroup.class, EditGroup.class })
    private String build;

    /**
     * 单元
     */
    @ApiModelProperty(value = "单元", required = true)
    @NotBlank(message = "单元不能为空", groups = { AddGroup.class, EditGroup.class })
    private String unit;

    /**
     * 楼层
     */
    @ApiModelProperty(value = "楼层", required = true)
    @NotBlank(message = "楼层不能为空", groups = { AddGroup.class, EditGroup.class })
    private String roomFloor;

    /**
     * 户室
     */
    @ApiModelProperty(value = "户室", required = true)
    @NotBlank(message = "户室不能为空", groups = { AddGroup.class, EditGroup.class })
    private String room;

    /**
     * 政治面貌
     */
    @ApiModelProperty(value = "政治面貌", required = true)
    @NotBlank(message = "政治面貌不能为空", groups = { AddGroup.class, EditGroup.class })
    private String politicalLandscape;

    /**
     * 工作单位
     */
    @ApiModelProperty(value = "工作单位", required = true)
    @NotBlank(message = "工作单位不能为空", groups = { AddGroup.class, EditGroup.class })
    private String workUnits;

    /**
     * 房屋类型
     */
    @ApiModelProperty(value = "房屋类型", required = true)
    @NotBlank(message = "房屋类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private String housingTypes;


    /**
     * 人口类型
     */
    @ApiModelProperty(value = "人口类型", required = true)
    @NotBlank(message = "人口类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private String populationType;

    /**
     * 居住类型
     */
    @ApiModelProperty(value = "居住类型", required = true)
    @NotBlank(message = "居住类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private String residentialType;

    /**
     * 承租时间
     */
    @ApiModelProperty(value = "承租时间", required = true)
    @NotNull(message = "承租时间不能为空", groups = { AddGroup.class, EditGroup.class })
    private Date leaseTime;

    /**
     * 个人标签1
     */
    @ApiModelProperty(value = "个人标签1", required = true)
    @NotBlank(message = "个人标签1不能为空", groups = { AddGroup.class, EditGroup.class })
    private String tag1;

    /**
     * 个人标签2
     */
    @ApiModelProperty(value = "个人标签2", required = true)
    @NotBlank(message = "个人标签2不能为空", groups = { AddGroup.class, EditGroup.class })
    private String tag2;

    /**
     * 个人标签3
     */
    @ApiModelProperty(value = "个人标签3", required = true)
    @NotBlank(message = "个人标签3不能为空", groups = { AddGroup.class, EditGroup.class })
    private String tag3;


}
