package com.xhnew.rfst.domain;

import lombok.Data;


/**
 * cim查询返回楼幢集合
 *
 * @author mashiro
 * @date 2023-04-07
 */
@Data
public class CimBuildingPersonInfo {

    private static final long serialVersionUID = 1L;

    /**
     * 姓名
     */
    private String xm;
    /**
     * 与户主关系
     */
    private String yhzgx;
    /**
     * 性别
     */
    private String xbmc;
    /**
     * 出生日期
     */
    private String csrq;
    /**
     * 西湖区地址库统一地址码
     */
    private String xhqtydzm;
    /**
     * 出生年月
     */
    private String csny;
    /**
     * 公民身份号码
     */
    private String gmsfhm;
    /**
     * 人员分类
     */
    private String ryfl;
    /**
     * 年龄
     */
    private String nl;
    /**
     * 联系电话
     */
    private String lxdh;
    /**
     * 政治面貌
     */
    private String zzmm;
    /**
     * 户籍地
     */
    private String hjdDzmc;
    /**
     * 工作单位
     */
    private String gzdw;
    /**
     * 个人标签汇总
     */
    private String qybqhz;


}
