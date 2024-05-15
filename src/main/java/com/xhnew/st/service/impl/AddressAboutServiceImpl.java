package com.xhnew.st.service.impl;

import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhnew.st.common.page.TableDataInfo;
import com.xhnew.st.domain.AddressAbout;
import com.xhnew.st.domain.base.PageQuery;
import com.xhnew.st.domain.bo.AddressAboutBo;
import com.xhnew.st.domain.vo.AddressAboutVo;
import com.xhnew.st.mapper.AddressAboutMapper;
import com.xhnew.st.service.IAddressAboutService;
import com.xhnew.st.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * 地址简介Service业务层处理
 *
 * @author mashiro
 * @date 2022-03-21
 */
@RequiredArgsConstructor
@Service
public class AddressAboutServiceImpl implements IAddressAboutService {

    private final AddressAboutMapper baseMapper;

    /**
     * 查询地址简介
     *
     * @param id 地址简介主键
     * @return 地址简介
     */
    @Override
    public AddressAboutVo queryById(Long id){
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询地址简介列表
     *
     * @param bo 地址简介
     * @return 地址简介
     */
    @Override
    public TableDataInfo<AddressAboutVo> queryPageList(AddressAboutBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<AddressAbout> lqw = buildQueryWrapper(bo);
        Page<AddressAboutVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询地址简介列表
     *
     * @param bo 地址简介
     * @return 地址简介
     */
    @Override
    public List<AddressAboutVo> queryList(AddressAboutBo bo) {
        LambdaQueryWrapper<AddressAbout> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<AddressAbout> buildQueryWrapper(AddressAboutBo bo) {
        Map<String, Object> params = bo.getParams();
        LambdaQueryWrapper<AddressAbout> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getBuildingName()), AddressAbout::getBuildingName, bo.getBuildingName());
        lqw.eq(StringUtils.isNotBlank(bo.getBuildingLocation()), AddressAbout::getBuildingLocation, bo.getBuildingLocation());
        lqw.eq(StringUtils.isNotBlank(bo.getBuildingIntroduction()), AddressAbout::getBuildingIntroduction, bo.getBuildingIntroduction());
        lqw.eq(StringUtils.isNotBlank(bo.getBuildingCategory()), AddressAbout::getBuildingCategory, bo.getBuildingCategory());
        lqw.eq(StringUtils.isNotBlank(bo.getSubordinateUnits()), AddressAbout::getSubordinateUnits, bo.getSubordinateUnits());
        lqw.eq(StringUtils.isNotBlank(bo.getPhone()), AddressAbout::getPhone, bo.getPhone());
        lqw.eq(StringUtils.isNotBlank(bo.getRightLevel()), AddressAbout::getRightLevel, bo.getRightLevel());
        lqw.eq(StringUtils.isNotBlank(bo.getSubordinateToScene()), AddressAbout::getSubordinateToScene, bo.getSubordinateToScene());
        lqw.eq(StringUtils.isNotBlank(bo.getLongitude()), AddressAbout::getLongitude, bo.getLongitude());
        lqw.eq(StringUtils.isNotBlank(bo.getLatitude()), AddressAbout::getLatitude, bo.getLatitude());
        return lqw;
    }

    /**
     * 新增地址简介
     *
     * @param bo 地址简介
     * @return 结果
     */
    @Override
    public Boolean insertByBo(AddressAboutBo bo) {
        AddressAbout add = BeanUtil.toBean(bo, AddressAbout.class);
        validEntityBeforeSave(add);
        boolean flag = baseMapper.insert(add) > 0;
        if (flag) {
            bo.setId(add.getId());
        }
        return flag;
    }

    /**
     * 修改地址简介
     *
     * @param bo 地址简介
     * @return 结果
     */
    @Override
    public Boolean updateByBo(AddressAboutBo bo) {
        AddressAbout update = BeanUtil.toBean(bo, AddressAbout.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(AddressAbout entity){
        //TODO 做一些数据校验,如唯一约束
    }

    /**
     * 批量删除地址简介
     *
     * @param ids 需要删除的地址简介主键
     * @return 结果
     */
    @Override
    public Boolean deleteWithValidByIds(Collection<Long> ids, Boolean isValid) {
        if(isValid){
            //TODO 做一些业务上的校验,判断是否需要校验
        }
        return baseMapper.deleteBatchIds(ids) > 0;
    }
}
