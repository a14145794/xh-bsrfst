package com.xhnew.st.service;


import com.xhnew.st.common.page.TableDataInfo;
import com.xhnew.st.domain.base.PageQuery;
import com.xhnew.st.domain.bo.AddressAboutBo;
import com.xhnew.st.domain.vo.AddressAboutVo;

import java.util.Collection;
import java.util.List;

/**
 * 地址简介Service接口
 *
 * @author mashiro
 * @date 2022-03-21
 */
public interface IAddressAboutService {

    /**
     * 查询地址简介
     *
     * @param id 地址简介主键
     * @return 地址简介
     */
    AddressAboutVo queryById(Long id);

    /**
     * 查询地址简介列表
     *
     * @param bo 地址简介
     * @return 地址简介集合
     */
    TableDataInfo<AddressAboutVo> queryPageList(AddressAboutBo bo, PageQuery pageQuery);

    /**
     * 查询地址简介列表
     *
     * @param bo 地址简介
     * @return 地址简介集合
     */
    List<AddressAboutVo> queryList(AddressAboutBo bo);

    /**
     * 修改地址简介
     *
     * @param bo 地址简介
     * @return 结果
     */
    Boolean insertByBo(AddressAboutBo bo);

    /**
     * 修改地址简介
     *
     * @param bo 地址简介
     * @return 结果
     */
    Boolean updateByBo(AddressAboutBo bo);

    /**
     * 校验并批量删除地址简介信息
     *
     * @param ids 需要删除的地址简介主键集合
     * @param isValid 是否校验,true-删除前校验,false-不校验
     * @return 结果
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
