package com.xhnew.st.domain;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableName;
import com.xhnew.st.domain.base.BaseEntity;
import lombok.Data;

/**
 * 人房上图对象 d_person_address
 *
 * @author mashiro
 * @date 2022-03-20
 */
@Data
@TableName("d_person_address")
public class PersonAddress extends BaseEntity {

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
     * 证件类型
     */
    private String idType;
    /**
     * 证件号码
     */
    private String idNumber;
    /**
     * 联系电话
     */
    private String phone;
    /**
     * 年龄
     */
    private Long age;
    /**
     * 标签
     */
    private String tag;
    /**
     * 性别
     */
    private String sex;
    /**
     * 户籍信息
     */
    private String registrationStatus;
    /**
     * 居住信息
     */
    private String registrationOver;
    /**
     * 地址
     */
    private String address;
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

}
