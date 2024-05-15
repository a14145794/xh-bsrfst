package com.xhnew.st.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;



/**
 * 人房上图视图对象 d_person_address_sb
 *
 * @author mashiro
 * @date 2022-04-06
 */
@Data
@ApiModel("上保人房上图视图对象")
@ExcelIgnoreUnannotated
public class PersonAddressSbVo {

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
     * 性别
     */
    @ExcelProperty(value = "性别")
    @ApiModelProperty("性别")
    private String sex;

    /**
     * 电话
     */
    @ExcelProperty(value = "电话")
    @ApiModelProperty("电话")
    private String phone;

    /**
     * 证件号码
     */
    @ExcelProperty(value = "证件号码")
    @ApiModelProperty("证件号码")
    private String idNumber;

    /**
     * 民族
     */
    @ExcelProperty(value = "民族")
    @ApiModelProperty("民族")
    private String national;

    /**
     * 户籍状态
     */
    @ExcelProperty(value = "户籍状态")
    @ApiModelProperty("户籍状态")
    private String registrationStatus;

    /**
     * 户籍地址
     */
    @ExcelProperty(value = "户籍地址")
    @ApiModelProperty("户籍地址")
    private String registrationAddress;

    /**
     * 与户主关系
     */
    @ExcelProperty(value = "与户主关系")
    @ApiModelProperty("与户主关系")
    private String relationshipToHouseholder;

    /**
     * 地址
     */
    @ExcelProperty(value = "地址")
    @ApiModelProperty("地址")
    private String address;

    /**
     * 街道(乡镇)
     */
    @ExcelProperty(value = "街道(乡镇)")
    @ApiModelProperty("街道(乡镇)")
    private String town;

    /**
     * 村/社区
     */
    @ExcelProperty(value = "村/社区")
    @ApiModelProperty("村/社区")
    private String community;

    /**
     * 街路巷弄
     */
    @ExcelProperty(value = "街路巷弄")
    @ApiModelProperty("街路巷弄")
    private String street;

    /**
     * 门牌号
     */
    @ExcelProperty(value = "门牌号")
    @ApiModelProperty("门牌号")
    private String door;

    /**
     * 小区
     */
    @ExcelProperty(value = "小区")
    @ApiModelProperty("小区")
    private String residential_quarters;

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
     * 政治面貌
     */
    @ExcelProperty(value = "政治面貌")
    @ApiModelProperty("政治面貌")
    private String politicalLandscape;

    /**
     * 工作单位
     */
    @ExcelProperty(value = "工作单位")
    @ApiModelProperty("工作单位")
    private String workUnits;

    /**
     * 房屋类型
     */
    @ExcelProperty(value = "房屋类型")
    @ApiModelProperty("房屋类型")
    private String housingTypes;


    /**
     * 人口类型
     */
    @ExcelProperty(value = "人口类型")
    @ApiModelProperty("人口类型")
    private String populationType;

    /**
     * 居住类型
     */
    @ExcelProperty(value = "居住类型")
    @ApiModelProperty("居住类型")
    private String residentialType;

    /**
     * 承租时间
     */
    @ExcelProperty(value = "承租时间")
    @ApiModelProperty("承租时间")
    private Date leaseTime;

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


}
