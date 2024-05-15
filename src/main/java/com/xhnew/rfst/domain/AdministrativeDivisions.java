package com.xhnew.rfst.domain;

import com.alibaba.excel.annotation.ExcelIgnoreUnannotated;
import com.alibaba.excel.annotation.ExcelProperty;
import lombok.Data;


/**
 * 行政区划视图对象 rc_administrative_divisions
 *
 * @author mashiro
 * @date 2023-04-07
 */
@Data
@ExcelIgnoreUnannotated
public class AdministrativeDivisions {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @ExcelProperty(value = "主键")
    private Long id;

    /**
     * 父id
     */
    @ExcelProperty(value = "父id")
    private Long parentId;

    /**
     * 祖级列表
     */
    @ExcelProperty(value = "祖级列表")
    private String ancestors;

    /**
     * 完整地址
     */
    @ExcelProperty(value = "完整地址")
    private String fullPath;

    /**
     * 名称
     */
    @ExcelProperty(value = "名称")
    private String name;

    /**
     * 预测名称
     */
    @ExcelProperty(value = "预测名称")
    private String poi;

    /**
     * 代码
     */
    @ExcelProperty(value = "代码")
    private String code;

    /**
     * 层级
     */
    @ExcelProperty(value = "层级")
    private Long level;

    /**
     * 排序
     */
    private Integer sort;

    /**
     * geoJson
     */
    @ExcelProperty(value = "geoJson")
    private String geoJson;


}
