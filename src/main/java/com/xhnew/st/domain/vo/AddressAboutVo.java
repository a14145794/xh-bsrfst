package com.xhnew.st.domain.vo;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;



/**
 * 地址简介视图对象 d_address_about
 *
 * @author mashiro
 * @date 2022-03-21
 */
@Data
@ApiModel("地址简介视图对象")
@ExcelIgnoreUnannotated
public class AddressAboutVo {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    @ApiModelProperty("主键")
    private Long id;

    /**
     * 建筑名称
     */
    @ExcelProperty(value = "建筑名称")
    @ApiModelProperty("建筑名称")
    private String buildingName;

    /**
     * 建筑位置
     */
    @ExcelProperty(value = "建筑位置")
    @ApiModelProperty("建筑位置")
    private String buildingLocation;

    /**
     * 建筑简介
     */
    @ExcelProperty(value = "建筑简介")
    @ApiModelProperty("建筑简介")
    private String buildingIntroduction;

    /**
     * 建筑类别
     */
    @ExcelProperty(value = "建筑类别")
    @ApiModelProperty("建筑类别")
    private String buildingCategory;

    /**
     * 所属单位
     */
    @ExcelProperty(value = "所属单位")
    @ApiModelProperty("所属单位")
    private String subordinateUnits;

    /**
     * 联系电话
     */
    @ExcelProperty(value = "联系电话")
    @ApiModelProperty("联系电话")
    private String phone;

    /**
     * 权级
     */
    @ExcelProperty(value = "权级")
    @ApiModelProperty("权级")
    private String rightLevel;

    /**
     * 所属场景
     */
    @ExcelProperty(value = "所属场景")
    @ApiModelProperty("所属场景")
    private String subordinateToScene;

    /**
     * 经度
     */
    @ExcelProperty(value = "经度")
    @ApiModelProperty("经度")
    private String longitude;

    /**
     * 纬度
     */
    @ExcelProperty(value = "纬度")
    @ApiModelProperty("纬度")
    private String latitude;


}
