package com.xhnew.st.service;

import com.xhnew.st.common.page.TableDataInfo;
import com.xhnew.st.domain.base.PageQuery;
import com.xhnew.st.domain.bo.PersonAddressSbBo;
import com.xhnew.st.domain.vo.IndexMessageSbVo;
import com.xhnew.st.domain.vo.PersonAddressSbVo;
import com.xhnew.st.domain.vo.UnitRoomSbVo;

import java.util.Collection;
import java.util.List;

/**
 * 人房上图Service接口
 *
 * @author mashiro
 * @date 2022-04-06
 */
public interface IPersonAddressSbService {

    IndexMessageSbVo getIndexMessage(String address, String build, String unit);

    TableDataInfo<UnitRoomSbVo> getUnitRoomList(String address, String build, String unit);

    TableDataInfo<PersonAddressSbVo> getPersonList(PersonAddressSbBo bo);

    /**
     * 查询人房上图
     *
     * @param id 人房上图主键
     * @return 人房上图
     */
    PersonAddressSbVo queryById(Long id);

    /**
     * 查询人房上图列表
     *
     * @param bo 人房上图
     * @return 人房上图集合
     */
    TableDataInfo<PersonAddressSbVo> queryPageList(PersonAddressSbBo bo, PageQuery pageQuery);

    /**
     * 查询人房上图列表
     *
     * @param bo 人房上图
     * @return 人房上图集合
     */
    List<PersonAddressSbVo> queryList(PersonAddressSbBo bo);

    /**
     * 修改人房上图
     *
     * @param bo 人房上图
     * @return 结果
     */
    Boolean insertByBo(PersonAddressSbBo bo);

    /**
     * 修改人房上图
     *
     * @param bo 人房上图
     * @return 结果
     */
    Boolean updateByBo(PersonAddressSbBo bo);

    /**
     * 校验并批量删除人房上图信息
     *
     * @param ids 需要删除的人房上图主键集合
     * @param isValid 是否校验,true-删除前校验,false-不校验
     * @return 结果
     */
    Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid);
}
