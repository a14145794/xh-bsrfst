package com.xhnew.st.service;

import com.xhnew.st.common.page.TableDataInfo;
import com.xhnew.st.domain.base.PageQuery;
import com.xhnew.st.domain.bo.PersonAddressBo;
import com.xhnew.st.domain.vo.IndexMessageVo;
import com.xhnew.st.domain.vo.PersonAddressVo;
import com.xhnew.st.domain.vo.UnitRoomVo;

import java.util.Collection;
import java.util.List;

/**
 * 人房上图Service接口
 *
 * @author mashiro
 * @date 2022-03-20
 */
public interface IPersonAddressService {

    IndexMessageVo getIndexMessage(String address, String build, String unit);

    TableDataInfo<UnitRoomVo> getUnitRoomList(String address, String build, String unit);

    TableDataInfo<PersonAddressVo> getPersonList(PersonAddressBo bo);

    /**
     * 查询人房上图
     *
     * @param id 人房上图主键
     * @return 人房上图
     */
    PersonAddressVo queryById(Long id);

    /**
     * 查询人房上图列表
     *
     * @param bo 人房上图
     * @return 人房上图集合
     */
    TableDataInfo<PersonAddressVo> queryPageList(PersonAddressBo bo, PageQuery pageQuery);

    /**
     * 查询人房上图列表
     *
     * @param bo 人房上图
     * @return 人房上图集合
     */
    List<PersonAddressVo> queryList(PersonAddressBo bo);

    /**
     * 修改人房上图
     *
     * @param bo 人房上图
     * @return 结果
     */
    Boolean insertByBo(PersonAddressBo bo);

    /**
     * 修改人房上图
     *
     * @param bo 人房上图
     * @return 结果
     */
    Boolean updateByBo(PersonAddressBo bo);

    /**
     * 校验并批量删除人房上图信息
     *
     * @param ids 需要删除的人房上图主键集合
     * @param isValid 是否校验,true-删除前校验,false-不校验
     * @return 结果
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
