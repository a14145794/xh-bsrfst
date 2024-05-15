package com.xhnew.rfst.domain;

import lombok.Data;

import java.io.Serializable;
import java.util.List;


/**
 * cim查询返回集合
 *
 * @author mashiro
 * @date 2023-04-07
 */
@Data
public class CimBuildingResult<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 页数
     */
    private Long totalRows;

    /**
     * 行数
     */
    private Long totalPage;

    /**
     * 返回内容
     */
    private List<T> result;

}
