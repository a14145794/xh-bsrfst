package com.xhnew.st.controller;

import com.xhnew.st.common.page.TableDataInfo;
import com.xhnew.st.common.validate.QueryGroup;
import com.xhnew.st.controller.base.BaseController;
import com.xhnew.st.domain.base.R;
import com.xhnew.st.domain.bo.PersonAddressBo;
import com.xhnew.st.domain.vo.IndexMessageVo;
import com.xhnew.st.domain.vo.PersonAddressVo;
import com.xhnew.st.domain.vo.UnitRoomVo;
import com.xhnew.st.service.IPersonAddressService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;

/**
 * 人房上图Controller
 *
 * @author mashiro
 * @date 2022-03-20
 */
@Validated
@Api(value = "人房上图", tags = {"人房上图管理-大屏"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/personAddressIndex")
public class PersonAddressIndexController extends BaseController {

    private final IPersonAddressService iPersonAddressService;

    /**
     * 获取人房上图详细信息
     */
    @ApiOperation("获取统计信息")
    @GetMapping("/getIndexMessage")
    public R<IndexMessageVo> getIndexMessage(@ApiParam("模糊地址(小区)") @NotNull(message = "模糊地址(小区)不能为空") String address,
                                             @ApiParam("楼幢") String build,
                                             @ApiParam("单元") String unit) {
        return R.ok(iPersonAddressService.getIndexMessage(address, build, unit));
    }

    /**
     * 查询人房上图列表
     */
    @ApiOperation("获取各单元下的户室集合")
    @GetMapping("/getUnitRoomList")
    public TableDataInfo<UnitRoomVo> getUnitRoomList(@ApiParam("模糊地址(小区)") @NotNull(message = "模糊地址(小区)不能为空") String address,
                                                     @ApiParam("楼幢") String build,
                                                     @ApiParam("单元") String unit) {
        return iPersonAddressService.getUnitRoomList(address, build, unit);
    }

    /**
     * 查询人房上图列表
     */
    @ApiOperation("查询人员数据")
    @GetMapping("/getPersonList")
    public TableDataInfo<PersonAddressVo> getPersonList(@Validated(QueryGroup.class) PersonAddressBo bo) {
        return iPersonAddressService.getPersonList(bo);
    }

}
