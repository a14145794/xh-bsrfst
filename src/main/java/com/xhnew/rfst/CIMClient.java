package com.xhnew.rfst;

import com.dtflys.forest.annotation.BaseRequest;
import com.dtflys.forest.annotation.Get;
import com.dtflys.forest.annotation.Query;
import com.xhnew.rfst.domain.AdministrativeDivisions;
import com.xhnew.st.common.page.TableDataInfo;

import java.util.List;

/**
 * com.ruoyi.client
 *
 * @author Mashiro
 * @date 2022/12/1
 */
@BaseRequest(
        baseURL = "https://xxxx"     // 默认域名
)
public interface CIMClient {

    @Get("/list")
    TableDataInfo<AdministrativeDivisions> getDataInfo(@Query("searchValue") String searchValue, @Query("params[maxLevel]") Integer maxLevel, @Query("ancestorsList") List<String> ancestorsList);
}
