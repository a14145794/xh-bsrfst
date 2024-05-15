package com.xhnew.st.controller;

import com.xhnew.st.common.page.TableDataInfo;
import com.xhnew.st.common.validate.AddGroup;
import com.xhnew.st.common.validate.EditGroup;
import com.xhnew.st.common.validate.QueryGroup;
import com.xhnew.st.controller.base.BaseController;
import com.xhnew.st.domain.base.PageQuery;
import com.xhnew.st.domain.base.R;
import com.xhnew.st.domain.bo.AddressAboutBo;
import com.xhnew.st.domain.vo.AddressAboutVo;
import com.xhnew.st.service.IAddressAboutService;
import com.xhnew.st.utils.poi.ExcelUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.List;

/**
 * 地址简介Controller
 *
 * @author mashiro
 * @date 2022-03-21
 */
@Validated
@Api(value = "地址简介控制器", tags = {"地址简介管理"})
@RequiredArgsConstructor
@RestController
@RequestMapping("/address/addressAbout")
public class AddressAboutController extends BaseController {

    private final IAddressAboutService iAddressAboutService;

    /**
     * 查询地址简介列表
     */
    @ApiOperation("查询地址简介列表")
    @GetMapping("/list")
    public TableDataInfo<AddressAboutVo> list(@Validated(QueryGroup.class) AddressAboutBo bo, PageQuery pageQuery) {
        return iAddressAboutService.queryPageList(bo, pageQuery);
    }

    /**
     * 导出地址简介列表
     */
    @ApiOperation("导出地址简介列表")
    @PostMapping("/export")
    public void export(@Validated AddressAboutBo bo, HttpServletResponse response) {
        List<AddressAboutVo> list = iAddressAboutService.queryList(bo);
        ExcelUtil.exportExcel(list, "地址简介", AddressAboutVo.class, response);
    }

    /**
     * 获取地址简介详细信息
     */
    @ApiOperation("获取地址简介详细信息")
    @GetMapping("/{id}")
    public R<AddressAboutVo> getInfo(@ApiParam("主键")
                                     @NotNull(message = "主键不能为空")
                                     @PathVariable("id") Long id) {
        return R.ok(iAddressAboutService.queryById(id));
    }

    /**
     * 新增地址简介
     */
    @ApiOperation("新增地址简介")
    //@RepeatSubmit()
    @PostMapping()
    public R<Void> add(@Validated(AddGroup.class) @RequestBody AddressAboutBo bo) {
        return toAjax(iAddressAboutService.insertByBo(bo) ? 1 : 0);
    }

    /**
     * 修改地址简介
     */
    @ApiOperation("修改地址简介")
    //@RepeatSubmit()
    @PutMapping()
    public R<Void> edit(@Validated(EditGroup.class) @RequestBody AddressAboutBo bo) {
        return toAjax(iAddressAboutService.updateByBo(bo) ? 1 : 0);
    }

    /**
     * 删除地址简介
     */
    @ApiOperation("删除地址简介")
    @DeleteMapping("/{ids}")
    public R<Void> remove(@ApiParam("主键串")
                          @NotEmpty(message = "主键不能为空")
                          @PathVariable Long[] ids) {
        return toAjax(iAddressAboutService.deleteWithValidByIds(Arrays.asList(ids), true) ? 1 : 0);
    }
}
