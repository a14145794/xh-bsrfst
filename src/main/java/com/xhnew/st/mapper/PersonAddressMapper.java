package com.xhnew.st.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.xhnew.st.domain.PersonAddress;
import com.xhnew.st.domain.vo.IndexMessageVo;
import com.xhnew.st.domain.vo.PersonAddressVo;
import com.xhnew.st.domain.vo.UnitRoomVo;
import com.xhnew.st.mapper.base.BaseMapperPlus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 人房上图Mapper接口
 *
 * @author mashiro
 * @date 2022-03-20
 */
public interface PersonAddressMapper extends BaseMapperPlus<PersonAddressMapper, PersonAddress, PersonAddressVo> {
    IndexMessageVo getIndexMessage(@Param("address")String address, @Param("build")String build, @Param("unit")String unit);
    List<UnitRoomVo> getUnitRoomList(@Param("address")String address, @Param("build")String build, @Param("unit")String unit);
    List<PersonAddressVo> getPersonList(@Param("ew") Wrapper<PersonAddress> queryWrapper);
}
