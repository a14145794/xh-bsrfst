package com.xhnew.st.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
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
@ApiModel("人房上图视图对象")
@ExcelIgnoreUnannotated
public class PersonAddressVo {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    @ApiModelProperty("主键")
    private Long id;

    /**
     * 姓名
     */
    @ExcelProperty(value = "姓名")
    @ApiModelProperty("姓名")
    private String name;

    /**
     * 证件类型
     */
    @ExcelProperty(value = "证件类型")
    @ApiModelProperty("证件类型")
    private String idType;

    /**
     * 证件号码
     */
    @ExcelProperty(value = "证件号码")
    @ApiModelProperty("证件号码")
    private String idNumber;

    /**
     * 联系电话
     */
    @ExcelProperty(value = "联系电话")
    @ApiModelProperty("联系电话")
    private String phone;

    /**
     * 年龄
     */
    @ExcelProperty(value = "年龄")
    @ApiModelProperty("年龄")
    private Long age;

    /**
     * 标签
     */
    @ExcelProperty(value = "标签")
    @ApiModelProperty("标签")
    private String tag;

    /**
     * 性别
     */
    @ExcelProperty(value = "性别")
    @ApiModelProperty("性别")
    private String sex;

    /**
     * 户籍信息
     */
    @ExcelProperty(value = "户籍信息")
    @ApiModelProperty("户籍信息")
    private String registrationStatus;

    /**
     * 居住信息
     */
    @ExcelProperty(value = "居住信息")
    @ApiModelProperty("居住信息")
    private String registrationOver;

    /**
     * 地址
     */
    @ExcelProperty(value = "地址")
    @ApiModelProperty("地址")
    private String address;

    /**
     * 楼栋
     */
    @ExcelProperty(value = "楼栋")
    @ApiModelProperty("楼栋")
    private String build;

    /**
     * 单元
     */
    @ExcelProperty(value = "单元")
    @ApiModelProperty("单元")
    private String unit;

    /**
     * 楼层
     */
    @ExcelProperty(value = "楼层")
    @ApiModelProperty("楼层")
    private String roomFloor;

    /**
     * 户室
     */
    @ExcelProperty(value = "户室")
    @ApiModelProperty("户室")
    private String room;

    /**
     * 户籍所在地
     */
    @ExcelProperty(value = "户籍所在地")
    @ApiModelProperty("户籍所在地")
    private String residenceAddrRk;
    /**
     * 籍贯
     */
    @ExcelProperty(value = "籍贯")
    @ApiModelProperty("籍贯")
    private String nativePlace;
    /**
     * 婚姻状态
     */
    @ExcelProperty(value = "婚姻状态")
    @ApiModelProperty("婚姻状态")
    private String martialrkfs;
    /**
     * 死亡情况
     */
    @ExcelProperty(value = "死亡情况")
    @ApiModelProperty("死亡情况")
    private String death;

    /**
     * 个人标签1
     */
    @ExcelProperty(value = "个人标签1")
    @ApiModelProperty("个人标签1")
    private String tag1;

    /**
     * 个人标签2
     */
    @ExcelProperty(value = "个人标签2")
    @ApiModelProperty("个人标签2")
    private String tag2;

    /**
     * 个人标签3
     */
    @ExcelProperty(value = "个人标签3")
    @ApiModelProperty("个人标签3")
    private String tag3;

    /**
     * 政治面貌
     */
    @ExcelProperty(value = "政治面貌")
    @ApiModelProperty("政治面貌")
    private String politicalLandscape;


}
