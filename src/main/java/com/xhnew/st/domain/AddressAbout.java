package com.xhnew.st.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xhnew.st.domain.base.BaseEntity;
import lombok.Data;


/**
 * 地址简介对象 d_address_about
 *
 * @author mashiro
 * @date 2022-03-21
 */
@Data
@TableName("d_address_about")
public class AddressAbout extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id")
    private Long id;
    /**
     * 删除标志
     */
    @TableLogic
    private String delFlag;
    /**
     * 建筑名称
     */
    private String buildingName;
    /**
     * 建筑位置
     */
    private String buildingLocation;
    /**
     * 建筑简介
     */
    private String buildingIntroduction;
    /**
     * 建筑类别
     */
    private String buildingCategory;
    /**
     * 所属单位
     */
    private String subordinateUnits;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 权级
     */
    private String rightLevel;
    /**
     * 所属场景
     */
    private String subordinateToScene;
    /**
     * 经度
     */
    private String longitude;
    /**
     * 纬度
     */
    private String latitude;

}
