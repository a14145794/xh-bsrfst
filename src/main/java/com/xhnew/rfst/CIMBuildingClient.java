package com.xhnew.rfst;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Query;
import com.dtflys.forest.extensions.BasicAuth;
import com.xhnew.rfst.domain.CimBuildingPersonInfo;
import com.xhnew.rfst.domain.CimBuildingRoomInfo;
import com.xhnew.rfst.domain.CimBuildingResult;
import com.xhnew.rfst.domain.CimBuildingStaticInfo;

/**
 * com.ruoyi.client
 *
 * @author Mashiro
 * @date 2022/12/1
 */
@BaseRequest(
        baseURL = "http://xxxxx:xxx/service/api"     // 默认域名
)
@BasicAuth(username = "xxxxx", password = "xxxx")
public interface CIMBuildingClient {

    /**
     * 通过市楼幢码查询对应楼幢的单元、楼层、户室信息
     *
     * @param pageSize       最大条数1000条
     * @param pageNumber     页码
     * @param belongBuilding 市地址楼幢码
     */
    @Get("/xhq/community/rfsj/BuildingRoomInfo")
    CimBuildingResult<CimBuildingRoomInfo> getBuildingRoomInfo(@Query("pageSize") Integer pageSize, @Query("pageNumber") Integer pageNumber, @Query("belong_building") String belongBuilding);

    /**
     * 通过社区和市楼幢码查询楼幢统计信息
     *
     * @param pageSize       最大条数1000条
     * @param pageNumber     页码
     * @param belongBuilding 市地址楼幢码
     * @param community      楼幢所属社区
     */
    @Get("/xhq/community/rfsj/BuildingStaticInfo")
    CimBuildingResult<CimBuildingStaticInfo> getBuildingStaticInfo(@Query("pageSize") Integer pageSize, @Query("pageNumber") Integer pageNumber, @Query("belong_building") String belongBuilding, @Query("community") String community);

    /**
     * 通过西湖区地址库地址码、身份证号码查询人口信息
     *
     * @param pageSize   最大条数1000条
     * @param pageNumber 页码
     * @param xhqtydzm   市地址楼幢码
     * @param gmsfhm     公民身份号码
     */
    @Get("/xhq/community/rfsj/BuildingPersonInfo")
    CimBuildingResult<CimBuildingPersonInfo> getBuildingPersonInfo(@Query("pageSize") Integer pageSize, @Query("pageNumber") Integer pageNumber, @Query("xhqtydzm") String xhqtydzm, @Query("gmsfhm") String gmsfhm);
}
