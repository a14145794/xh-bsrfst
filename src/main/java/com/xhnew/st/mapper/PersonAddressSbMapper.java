package com.xhnew.st.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.xhnew.st.domain.PersonAddressSb;
import com.xhnew.st.domain.vo.IndexMessageSbVo;
import com.xhnew.st.domain.vo.PersonAddressSbVo;
import com.xhnew.st.domain.vo.UnitRoomSbVo;
import com.xhnew.st.mapper.base.BaseMapperPlus;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 人房上图Mapper接口
 *
 * @author mashiro
 * @date 2022-04-06
 */
public interface PersonAddressSbMapper extends BaseMapperPlus<PersonAddressSbMapper, PersonAddressSb, PersonAddressSbVo> {
    IndexMessageSbVo getIndexMessage(@Param("address")String address, @Param("build")String build, @Param("unit")String unit);
    List<UnitRoomSbVo> getUnitRoomList(@Param("address")String address, @Param("build")String build, @Param("unit")String unit);
    List<PersonAddressSbVo> getPersonList(@Param("ew") Wrapper<PersonAddressSb> queryWrapper);
}
