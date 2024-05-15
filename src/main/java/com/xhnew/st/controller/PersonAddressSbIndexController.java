package com.xhnew.st.controller;

import com.xhnew.st.common.page.TableDataInfo;
import com.xhnew.st.common.validate.QueryGroup;
import com.xhnew.st.controller.base.BaseController;
import com.xhnew.st.domain.base.R;
import com.xhnew.st.domain.bo.PersonAddressSbBo;
import com.xhnew.st.domain.vo.IndexMessageSbVo;
import com.xhnew.st.domain.vo.PersonAddressSbVo;
import com.xhnew.st.domain.vo.UnitRoomSbVo;
import com.xhnew.st.service.IPersonAddressSbService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 人房上图Controller
 *
 * @author mashiro
 * @date 2022-03-20
 */
@Validated
@Api(value = "上保社区-人房上图", tags = {"上保-人房上图管理-大屏"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/personAddressSbIndex")
public class PersonAddressSbIndexController extends BaseController {

    private final IPersonAddressSbService iPersonAddressSbService;

    /**
     * 获取人房上图详细信息
     */
    @ApiOperation("获取统计信息")
    @GetMapping("/getIndexMessage")
    public R<IndexMessageSbVo> getIndexMessage(@ApiParam("模糊地址(小区)")  String address,
                                               @ApiParam("楼幢") String build,
                                               @ApiParam("单元") String unit) {
        return R.ok(iPersonAddressSbService.getIndexMessage(address, build, unit));
    }

    /**
     * 查询人房上图列表
     */
    @ApiOperation("获取各单元下的户室集合")
    @GetMapping("/getUnitRoomList")
    public TableDataInfo<UnitRoomSbVo> getUnitRoomList(@ApiParam("模糊地址(小区)") String address,
                                                       @ApiParam("楼幢") String build,
                                                       @ApiParam("单元") String unit) {
        return iPersonAddressSbService.getUnitRoomList(address, build, unit);
    }

    /**
     * 查询人房上图列表
     */
    @ApiOperation("查询人员数据")
    @GetMapping("/getPersonList")
    public TableDataInfo<PersonAddressSbVo> getPersonList(@Validated(QueryGroup.class) PersonAddressSbBo bo) {
        return iPersonAddressSbService.getPersonList(bo);
    }

}
