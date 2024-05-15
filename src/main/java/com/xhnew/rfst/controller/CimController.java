package com.xhnew.rfst.controller;

import cn.hutool.core.util.StrUtil;
import com.dtflys.forest.annotation.Query;
import com.xhnew.rfst.CIMBuildingClient;
import com.xhnew.rfst.CIMClient;
import com.xhnew.rfst.domain.*;
import com.xhnew.st.common.page.TableDataInfo;
import com.xhnew.st.controller.base.BaseController;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * 地址简介Controller
 *
 * @author mashiro
 * @date 2022-03-21
 */
@Validated
@RequiredArgsConstructor
@RestController
@RequestMapping("/cim")
public class CimController extends BaseController {

    private final CIMClient cimClient;
    private final CIMBuildingClient buildingClient;

    /**
     * 根据名称查询行政区划范围
     */
    @GetMapping("/list")
    public TableDataInfo<AdministrativeDivisions> list(String name, Boolean isExpand) {
        String xzqhList = getXZQHList(name);
        if (StrUtil.isNotBlank(xzqhList)) {
            TableDataInfo<AdministrativeDivisions> dataInfo = cimClient.getDataInfo(xzqhList, null, null);
            if (isExpand) {
                List<AdministrativeDivisions> data = dataInfo.getData();
                List<String> collect = data.stream().filter(i -> i.getLevel() > 4).map(s -> s.getAncestors() + "," + s.getId()).collect(Collectors.toList());
                // 有毛病
                collect.add("00000,111111");
                TableDataInfo<AdministrativeDivisions> info = cimClient.getDataInfo(null, 6, collect);
                data.addAll(info.getData());
                return TableDataInfo.build(data);
            }
            return TableDataInfo.build(dataInfo.getData());
        }
        return TableDataInfo.build();
    }


    /**
     * 通过市楼幢码查询对应楼幢的单元、楼层、户室信息
     *
     * @param pageSize       最大条数1000条
     * @param pageNumber     页码
     * @param belongBuilding 市地址楼幢码
     */
    @GetMapping("/getBuildingRoomInfo")
    public CimBuildingResult<CimBuildingRoomInfo> getBuildingRoomInfo(@Query("pageSize") Integer pageSize, @Query("pageNumber") Integer pageNumber, @Query("belong_building") String belongBuilding) {
        return buildingClient.getBuildingRoomInfo(pageSize, pageNumber, belongBuilding);
    }

    /**
     * 通过社区和市楼幢码查询楼幢统计信息
     *
     * @param pageSize       最大条数1000条
     * @param pageNumber     页码
     * @param belongBuilding 市地址楼幢码
     * @param community      楼幢所属社区
     */
    @GetMapping("/getBuildingStaticInfo")
    public CimBuildingResult<CimBuildingStaticInfo> getBuildingStaticInfo(@Query("pageSize") Integer pageSize, @Query("pageNumber") Integer pageNumber, @Query("belong_building") String belongBuilding, @Query("community") String community) {
        return buildingClient.getBuildingStaticInfo(pageSize, pageNumber, belongBuilding, community);
    }

    /**
     * 通过西湖区地址库地址码、身份证号码查询人口信息
     *
     * @param pageSize   最大条数1000条
     * @param pageNumber 页码
     * @param xhqtydzm   市地址楼幢码
     * @param gmsfhm     公民身份号码
     */
    @GetMapping("/getBuildingPersonInfo")
    public CimBuildingResult<CimBuildingPersonInfo> getBuildingPersonInfo(@Query("pageSize") Integer pageSize, @Query("pageNumber") Integer pageNumber, @Query("xhqtydzm") String xhqtydzm, @Query("gmsfhm") String gmsfhm) {
        return buildingClient.getBuildingPersonInfo(pageSize, pageNumber, xhqtydzm, gmsfhm);
    }


    private static final Map<String, String> xzqhMap = new HashMap<>();

    static {
        xzqhMap.put("古荡街道", "古荡街道,嘉绿苑社区");
        xzqhMap.put("嘉绿苑未来社区", "嘉绿苑社区");
        xzqhMap.put("灵隐街道", "灵隐街道,灵隐社区");
        xzqhMap.put("东沙弄未来社区", "灵隐社区");
        xzqhMap.put("文新街道", "文新街道,德加社区");
        xzqhMap.put("德加未来社区", "德加社区");
        xzqhMap.put("留下街道", "留下街道,杨家牌楼社区");
        xzqhMap.put("杨家牌楼未来社区", "杨家牌楼社区");
        xzqhMap.put("西溪街道", "西溪街道,溪畔社区,求智社区");
        xzqhMap.put("溪畔未来社区", "溪畔社区");
        xzqhMap.put("翠苑街道", "翠苑街道,翠苑四区社区");
        xzqhMap.put("翠苑四区未来社区", "翠苑四区社区");
        xzqhMap.put("蒋村街道", "蒋村街道,河滨社区,府苑社区");
        xzqhMap.put("河滨未来社区", "河滨社区");
        xzqhMap.put("转塘街道", "转塘街道,象山社区,龙心社区,龙王沙社区,狮子社区,桕联社区,贤家庄社区");
        xzqhMap.put("之江家园未来社区", "象山社区,龙心社区,龙王沙社区,狮子社区,桕联社区,贤家庄社区");
        xzqhMap.put("府苑未来社区", "府苑社区");
        xzqhMap.put("求智未来社区", "求智社区");
        xzqhMap.put("北山街道", "北山街道,上保社区,松木场社区");
        xzqhMap.put("上保未来社区", "上保社区,松木场社区");
        xzqhMap.put("政苑未来社区", "政苑社区");
        xzqhMap.put("山联未来社区", "山联社区");
        xzqhMap.put("同仁家园未来社区", "罗家村社区,陆板桥社区,同仁家园");


    }

    public String getXZQHList(String name) {
        //1	古荡街道	嘉绿苑未来社区	嘉绿苑
        //2	灵隐街道	东沙弄未来社区	灵隐
        //3	文新街道	德加未来社区	德加
        //4	留下街道	杨家牌楼未来社区	杨家牌楼
        //5	西溪街道	溪畔未来社区	溪畔
        //6	翠苑街道	翠苑四区未来社区	翠苑四区
        //7	蒋村街道	河滨未来社区	河滨
        //8	转塘街道	之江家园未来社区	象山、龙心、龙王沙、狮子口、桕联、贤家庄
        //9	蒋村街道	府苑未来社区	府苑社区
        //10 西溪街道 求智未来社区	求智社区
        //11 北山街道 上保未来社区	上保社区、松木场社区
        return xzqhMap.getOrDefault(name, null);
    }
}
