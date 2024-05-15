package com.xhnew.st.domain.bo;

import com.xhnew.st.domain.base.BaseEntity;
import com.xhnew.st.common.validate.AddGroup;
import com.xhnew.st.common.validate.EditGroup;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 人房上图业务对象 d_person_address
 *
 * @author mashiro
 * @date 2022-03-20
 */

@Data
@EqualsAndHashCode(callSuper = true)
@ApiModel("人房上图业务对象")
public class PersonAddressBo extends BaseEntity {

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
     * 证件类型
     */
    @ApiModelProperty(value = "证件类型", required = true)
    @NotBlank(message = "证件类型不能为空", groups = { AddGroup.class, EditGroup.class })
    private String idType;

    /**
     * 证件号码
     */
    @ApiModelProperty(value = "证件号码", required = true)
    @NotBlank(message = "证件号码不能为空", groups = { AddGroup.class, EditGroup.class })
    private String idNumber;

    /**
     * 联系电话
     */
    @ApiModelProperty(value = "联系电话", required = true)
    @NotBlank(message = "联系电话不能为空", groups = { AddGroup.class, EditGroup.class })
    private String phone;

    /**
     * 年龄
     */
    @ApiModelProperty(value = "年龄", required = true)
    @NotNull(message = "年龄不能为空", groups = { AddGroup.class, EditGroup.class })
    private Long age;

    /**
     * 标签
     */
    @ApiModelProperty(value = "标签", required = true)
    @NotBlank(message = "标签不能为空", groups = { AddGroup.class, EditGroup.class })
    private String tag;

    /**
     * 性别
     */
    @ApiModelProperty(value = "性别", required = true)
    @NotBlank(message = "性别不能为空", groups = { AddGroup.class, EditGroup.class })
    private String sex;

    /**
     * 户籍信息
     */
    @ApiModelProperty(value = "户籍信息", required = true)
    @NotBlank(message = "户籍信息不能为空", groups = { AddGroup.class, EditGroup.class })
    private String registrationStatus;

    /**
     * 居住信息
     */
    @ApiModelProperty(value = "居住信息", required = true)
    @NotBlank(message = "居住信息不能为空", groups = { AddGroup.class, EditGroup.class })
    private String registrationOver;

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


}
