package com.xhnew.st.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhnew.st.common.page.TableDataInfo;
import com.xhnew.st.domain.PersonAddress;
import com.xhnew.st.domain.base.PageQuery;
import com.xhnew.st.domain.bo.PersonAddressBo;
import com.xhnew.st.domain.vo.IndexMessageVo;
import com.xhnew.st.domain.vo.PersonAddressVo;
import com.xhnew.st.domain.vo.UnitRoomVo;
import com.xhnew.st.mapper.PersonAddressMapper;
import com.xhnew.st.service.IPersonAddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 人房上图Service业务层处理
 *
 * @author mashiro
 * @date 2022-03-20
 */
@RequiredArgsConstructor
@Service
public class PersonAddressServiceImpl implements IPersonAddressService {

    private final PersonAddressMapper baseMapper;

    @Override
    public IndexMessageVo getIndexMessage(String address, String build, String unit) {
        return baseMapper.getIndexMessage(address, build, unit);
    }

    @Override
    public TableDataInfo<UnitRoomVo> getUnitRoomList(String address, String build, String unit) {
        List<UnitRoomVo> unitRoomList = baseMapper.getUnitRoomList(address, build, unit);
        unitRoomList.stream().filter(r -> StrUtil.isNotBlank(r.getRooms())).forEach(r -> r.setRoomList(StrUtil.split(r.getRooms(), ",")));
        return TableDataInfo.build(unitRoomList);
    }

    @Override
    public TableDataInfo<PersonAddressVo> getPersonList(PersonAddressBo bo) {
        LambdaQueryWrapper<PersonAddress> lqw = buildQueryWrapper(bo);
        lqw.apply("( death = '否' or death is null) ");
        lqw.groupBy(PersonAddress::getIdNumber);
        List<PersonAddressVo> unitRoomList = baseMapper.getPersonList(lqw);
        return TableDataInfo.build(unitRoomList);
    }

    /**
     * 查询人房上图
     *
     * @param id 人房上图主键
     * @return 人房上图
     */
    @Override
    public PersonAddressVo queryById(Long id) {
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询人房上图列表
     *
     * @param bo 人房上图
     * @return 人房上图
     */
    @Override
    public TableDataInfo<PersonAddressVo> queryPageList(PersonAddressBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<PersonAddress> lqw = buildQueryWrapper(bo);
        Page<PersonAddressVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询人房上图列表
     *
     * @param bo 人房上图
     * @return 人房上图
     */
    @Override
    public List<PersonAddressVo> queryList(PersonAddressBo bo) {
        LambdaQueryWrapper<PersonAddress> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<PersonAddress> buildQueryWrapper(PersonAddressBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<PersonAddress> lqw = Wrappers.lambdaQuery();
        lqw.like(StrUtil.isNotBlank(bo.getName()), PersonAddress::getName, bo.getName());
        lqw.eq(StrUtil.isNotBlank(bo.getIdType()), PersonAddress::getIdType, bo.getIdType());
        lqw.eq(StrUtil.isNotBlank(bo.getIdNumber()), PersonAddress::getIdNumber, bo.getIdNumber());
        lqw.eq(StrUtil.isNotBlank(bo.getPhone()), PersonAddress::getPhone, bo.getPhone());
        lqw.eq(bo.getAge() != null, PersonAddress::getAge, bo.getAge());
        lqw.eq(StrUtil.isNotBlank(bo.getTag()), PersonAddress::getTag, bo.getTag());
        lqw.eq(StrUtil.isNotBlank(bo.getSex()), PersonAddress::getSex, bo.getSex());
        lqw.eq(StrUtil.isNotBlank(bo.getRegistrationStatus()), PersonAddress::getRegistrationStatus, bo.getRegistrationStatus());
        lqw.eq(StrUtil.isNotBlank(bo.getRegistrationOver()), PersonAddress::getRegistrationOver, bo.getRegistrationOver());

        lqw.like(StrUtil.isNotBlank(bo.getAddress()), PersonAddress::getAddress, bo.getAddress());
        if (StrUtil.isNotBlank(bo.getBuild())) {
            lqw.and(x->x.eq(PersonAddress::getBuild, bo.getBuild())
                    .or().eq( PersonAddress::getBuild, bo.getBuild() + "号1")
                    .or().eq( PersonAddress::getBuild, bo.getAddress() + bo.getBuild() + "号1")
                    .or().eq( PersonAddress::getBuild, bo.getBuild() + "号")
                    .or().eq( PersonAddress::getBuild, bo.getAddress() + bo.getBuild() + "号")
                    .or().eq( PersonAddress::getBuild, bo.getBuild() + "幢")
                    .or().eq( PersonAddress::getBuild, bo.getAddress() + bo.getBuild() + "幢")
            );
        }

        if (StrUtil.isNotBlank(bo.getUnit())) {
            lqw.and(x->x.eq(PersonAddress::getUnit, bo.getUnit())
                    .or().eq( PersonAddress::getUnit, bo.getUnit() + "单元")
            );
        }

        lqw.eq(StrUtil.isNotBlank(bo.getRoomFloor()), PersonAddress::getRoomFloor, bo.getRoomFloor());
        lqw.eq(StrUtil.isNotBlank(bo.getRoom()), PersonAddress::getRoom, bo.getRoom());
        return lqw;
    }

    /**
     * 新增人房上图
     *
     * @param bo 人房上图
     * @return 结果
     */
    @Override
    public Boolean insertByBo(PersonAddressBo bo) {
        PersonAddress add = BeanUtil.toBean(bo, PersonAddress.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改人房上图
     *
     * @param bo 人房上图
     * @return 结果
     */
    @Override
    public Boolean updateByBo(PersonAddressBo bo) {
        PersonAddress update = BeanUtil.toBean(bo, PersonAddress.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(PersonAddress entity) {
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除人房上图
     *
     * @param ids 需要删除的人房上图主键
     * @return 结果
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if (isValid) {
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
