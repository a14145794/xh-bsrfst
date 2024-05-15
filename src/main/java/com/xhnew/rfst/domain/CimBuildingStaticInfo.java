package com.xhnew.rfst.domain;

import lombok.Data;


/**
 * cim查询返回楼幢集合
 *
 * @author mashiro
 * @date 2023-04-07
 */
@Data
public class CimBuildingStaticInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 市地址库楼幢码
     */
    private String belongBuilding;
    /**
     * 楼幢所属社区
     */
    private String community;
    /**
     * 地址
     */
    private String address;
    /**
     * 户室数量
     */
    private String roomNum;
    /**
     * 单元清单
     */
    private String unitList;
    /**
     * 出租户数
     */
    private String czhs;
    /**
     * 自住户数
     */
    private String zzhs;
    /**
     * 空置户数
     */
    private String vacancyNum;
    /**
     * 户籍人口
     */
    private String hjrk;
    /**
     * 流动人口
     */
    private String ldrk;
    /**
     * 活跃人口(其他)
     */
    private String hyrk;
    /**
     * 实有人口
     */
    private String syrk;


}
