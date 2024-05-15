package com.xhnew.st.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xhnew.st.domain.base.BaseEntity;
import lombok.Data;

import java.util.Date;

/**
 * 人房上图对象 d_person_address_sb
 *
 * @author mashiro
 * @date 2022-04-06
 */
@Data
@TableName("d_person_address")
public class PersonAddressSb extends BaseEntity {

    private static final long serialVersionUID=1L;

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
     * 姓名
     */
    private String name;
    /**
     * 性别
     */
    private String sex;
    /**
     * 电话
     */
    private String phone;
    /**
     * 证件号码
     */
    private String idNumber;
    /**
     * 民族
     */
    private String national;
    /**
     * 户籍信息
     */
    private String registrationStatus;
    /**
     * 与户主关系
     */
    private String relationshipToHouseholder;
    /**
     * 地址
     */
    private String address;
    /**
     * 街道(乡镇)
     */
    private String town;
    /**
     * 村/社区
     */
    private String community;
    /**
     * 街路巷弄
     */
    private String street;
    /**
     * 门牌号
     */
    private String door;
    /**
     * 小区
     */
    private String residential_quarters;
    /**
     * 楼栋
     */
    private String build;
    /**
     * 单元
     */
    private String unit;
    /**
     * 楼层
     */
    private String roomFloor;
    /**
     * 户室
     */
    private String room;
    /**
     * 政治面貌
     */
    private String politicalLandscape;
    /**
     * 工作单位
     */
    private String workUnits;
    /**
     * 房屋类型
     */
    private String housingTypes;
    /**
     * 人口类型
     */
    private String populationType;
    /**
     * 居住类型
     */
    private String residentialType;
    /**
     * 承租时间
     */
    private Date leaseTime;
    /**
     * 个人标签1
     */
    private String tag1;
    /**
     * 个人标签2
     */
    private String tag2;
    /**
     * 个人标签3
     */
    private String tag3;

}
