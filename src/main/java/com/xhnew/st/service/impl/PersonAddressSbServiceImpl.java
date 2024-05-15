package com.xhnew.st.service.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xhnew.st.common.page.TableDataInfo;
import com.xhnew.st.domain.PersonAddressSb;
import com.xhnew.st.domain.base.PageQuery;
import com.xhnew.st.domain.bo.PersonAddressSbBo;
import com.xhnew.st.domain.vo.IndexMessageSbVo;
import com.xhnew.st.domain.vo.PersonAddressSbVo;
import com.xhnew.st.domain.vo.RoomSbVo;
import com.xhnew.st.domain.vo.UnitRoomSbVo;
import com.xhnew.st.mapper.PersonAddressSbMapper;
import com.xhnew.st.service.IPersonAddressSbService;
import com.xhnew.st.utils.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 人房上图Service业务层处理
 *
 * @author mashiro
 * @date 2022-04-06
 */
@RequiredArgsConstructor
@Service
public class PersonAddressSbServiceImpl implements IPersonAddressSbService {

    private final PersonAddressSbMapper baseMapper;

    @Override
    public IndexMessageSbVo getIndexMessage(String address, String build, String unit) {
        return baseMapper.getIndexMessage(address, build, unit);
    }

    @Override
    public TableDataInfo<UnitRoomSbVo> getUnitRoomList(String address, String build, String unit) {
        List<UnitRoomSbVo> unitRoomList = baseMapper.getUnitRoomList(address, build, unit);
        //unitRoomList.stream().filter(r -> StrUtil.isNotBlank(r.getRooms())).forEach(r -> r.setRoomList(StrUtil.split(r.getRooms(), ",")));
        for (UnitRoomSbVo unitRoomSbVo : unitRoomList) {
            if (StrUtil.isNotBlank(unitRoomSbVo.getRooms())) {
                String data = unitRoomSbVo.getRooms();
                Map<String, List<String>> roomMap = Arrays.stream(data.split(","))
                        .map(room -> room.split(":"))
                        .collect(Collectors.groupingBy(room -> room[0], LinkedHashMap::new,
                                Collectors.mapping(room -> room[1], Collectors.toList())));
                List<RoomSbVo> roomList = convertMapToList(roomMap);
                unitRoomSbVo.setRoomList(roomList);
            }
        }
        return TableDataInfo.build(unitRoomList);
    }

    // 将 Map 转换为 List<RoomSbVo> 的方法
    private List<RoomSbVo> convertMapToList(Map<String, List<String>> roomMap) {
        List<RoomSbVo> roomList = new ArrayList<>();
        for (String key : roomMap.keySet()) {
            List<String> list = roomMap.get(key);
            String value = "";
            if (list.contains("自住")) {
                value = "自住";
            } else if (list.contains("出租")) {
                value = "出租";
            } else if (list.contains("空置")) {
                value = "空置";
            } else {
                value = "其他";
            }
            RoomSbVo roomSbVo = new RoomSbVo();
            roomSbVo.setRoom_num(key);
            roomSbVo.setRoom_status(value);
            roomList.add(roomSbVo);
        }
        return roomList;
    }

    @Override
    public TableDataInfo<PersonAddressSbVo> getPersonList(PersonAddressSbBo bo) {
        LambdaQueryWrapper<PersonAddressSb> lqw = buildQueryWrapper(bo);
        List<PersonAddressSbVo> unitRoomList = baseMapper.selectVoList(lqw);
        return TableDataInfo.build(unitRoomList);
    }

    /**
     * 查询人房上图
     *
     * @param id 人房上图主键
     * @return 人房上图
     */
    @Override
    public PersonAddressSbVo queryById(Long id) {
        return baseMapper.selectVoById(id);
    }

    /**
     * 查询人房上图列表
     *
     * @param bo 人房上图
     * @return 人房上图
     */
    @Override
    public TableDataInfo<PersonAddressSbVo> queryPageList(PersonAddressSbBo bo, PageQuery pageQuery) {
        LambdaQueryWrapper<PersonAddressSb> lqw = buildQueryWrapper(bo);
        Page<PersonAddressSbVo> result = baseMapper.selectVoPage(pageQuery.build(), lqw);
        return TableDataInfo.build(result);
    }

    /**
     * 查询人房上图列表
     *
     * @param bo 人房上图
     * @return 人房上图
     */
    @Override
    public List<PersonAddressSbVo> queryList(PersonAddressSbBo bo) {
        LambdaQueryWrapper<PersonAddressSb> lqw = buildQueryWrapper(bo);
        return baseMapper.selectVoList(lqw);
    }

    private LambdaQueryWrapper<PersonAddressSb> buildQueryWrapper(PersonAddressSbBo bo) {
        LambdaQueryWrapper<PersonAddressSb> lqw = Wrappers.lambdaQuery();
        lqw.like(StringUtils.isNotBlank(bo.getName()), PersonAddressSb::getName, bo.getName());
        lqw.eq(StringUtils.isNotBlank(bo.getSex()), PersonAddressSb::getSex, bo.getSex());
        lqw.eq(StringUtils.isNotBlank(bo.getPhone()), PersonAddressSb::getPhone, bo.getPhone());
        lqw.like(StringUtils.isNotBlank(bo.getIdNumber()), PersonAddressSb::getIdNumber, bo.getIdNumber());
        lqw.eq(StringUtils.isNotBlank(bo.getNational()), PersonAddressSb::getNational, bo.getNational());
        lqw.eq(StringUtils.isNotBlank(bo.getRegistrationStatus()), PersonAddressSb::getRegistrationStatus, bo.getRegistrationStatus());

        lqw.eq(StringUtils.isNotBlank(bo.getRelationshipToHouseholder()), PersonAddressSb::getRelationshipToHouseholder, bo.getRelationshipToHouseholder());
        lqw.like(StrUtil.isNotBlank(bo.getAddress()), PersonAddressSb::getAddress, bo.getAddress());
        if (StrUtil.isNotBlank(bo.getBuild())) {
            lqw.and(x -> x.eq(PersonAddressSb::getBuild, bo.getBuild())
                    .or().eq(PersonAddressSb::getBuild, bo.getBuild() + "号1")
                    .or().eq(PersonAddressSb::getBuild, bo.getAddress() + bo.getBuild() + "号1")
                    .or().eq(PersonAddressSb::getBuild, bo.getBuild() + "号")
                    .or().eq(PersonAddressSb::getBuild, bo.getAddress() + bo.getBuild() + "号")
                    .or().eq(PersonAddressSb::getBuild, bo.getBuild() + "幢")
                    .or().eq(PersonAddressSb::getBuild, bo.getAddress() + bo.getBuild() + "幢")
            );
        }

        if (StrUtil.isNotBlank(bo.getUnit())) {
            lqw.and(x -> x.eq(PersonAddressSb::getUnit, bo.getUnit())
                    .or().eq(PersonAddressSb::getUnit, bo.getUnit() + "单元")
            );
        }
        lqw.eq(StringUtils.isNotBlank(bo.getRoomFloor()), PersonAddressSb::getRoomFloor, bo.getRoomFloor());
        lqw.eq(StringUtils.isNotBlank(bo.getRoom()), PersonAddressSb::getRoom, bo.getRoom());
        lqw.eq(StringUtils.isNotBlank(bo.getPoliticalLandscape()), PersonAddressSb::getPoliticalLandscape, bo.getPoliticalLandscape());
        lqw.eq(StringUtils.isNotBlank(bo.getWorkUnits()), PersonAddressSb::getWorkUnits, bo.getWorkUnits());
        lqw.eq(StringUtils.isNotBlank(bo.getHousingTypes()), PersonAddressSb::getHousingTypes, bo.getHousingTypes());
        lqw.eq(StringUtils.isNotBlank(bo.getPopulationType()), PersonAddressSb::getPopulationType, bo.getPopulationType());
        lqw.eq(StringUtils.isNotBlank(bo.getResidentialType()), PersonAddressSb::getResidentialType, bo.getResidentialType());
        lqw.eq(bo.getLeaseTime() != null, PersonAddressSb::getLeaseTime, bo.getLeaseTime());
        lqw.eq(StringUtils.isNotBlank(bo.getTag1()), PersonAddressSb::getTag1, bo.getTag1());
        lqw.eq(StringUtils.isNotBlank(bo.getTag2()), PersonAddressSb::getTag2, bo.getTag2());
        lqw.eq(StringUtils.isNotBlank(bo.getTag3()), PersonAddressSb::getTag3, bo.getTag3());
        return lqw;
    }

    /**
     * 新增人房上图
     *
     * @param bo 人房上图
     * @return 结果
     */
    @Override
    public Boolean insertByBo(PersonAddressSbBo bo) {
        PersonAddressSb add = BeanUtil.toBean(bo, PersonAddressSb.class);
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
    public Boolean updateByBo(PersonAddressSbBo bo) {
        PersonAddressSb update = BeanUtil.toBean(bo, PersonAddressSb.class);
        validEntityBeforeSave(update);
        return baseMapper.updateById(update) > 0;
    }

    /**
     * 保存前的数据校验
     *
     * @param entity 实体类数据
     */
    private void validEntityBeforeSave(PersonAddressSb entity) {
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
