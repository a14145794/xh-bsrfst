package com.xhnew.rfst.domain;

import lombok.Data;


/**
 * cim查询返回楼幢集合
 *
 * @author mashiro
 * @date 2023-04-07
 */
@Data
public class CimBuildingRoomInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 西湖区地址库统一地址码
     */
    private String xhqtydzm;
    /**
     * 市地址库楼幢码
     */
    private String belongBuilding;
    /**
     * 地址工作台统一地址码
     */
    private String guid;
    /**
     * 户室所在楼层
     */
    private String roomFloor;
    /**
     * 单元
     */
    private String unit;
    /**
     * 户室
     */
    private String room;
    /**
     * 房屋类型
     */
    private String fwlx;


}
