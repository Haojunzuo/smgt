package com.wbz.system.utils;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wbz.system.domain.TableDataInfo;

import java.util.List;

public class PageUtils {
    public static void startMyPage(Integer pageNum, Integer pageSize, String orderBy) {
        if (BeanUtils.isNotEmpty(pageNum) && BeanUtils.isNotEmpty(pageSize)) {
            if (BeanUtils.isNotEmpty(orderBy) && orderBy.matches("[a-zA-Z0-9_\\ \\,\\.]+")) {
                orderBy = "";
            }
            PageHelper.startPage(pageNum, pageSize, orderBy);
        }
    }

    public static TableDataInfo getMyDataTable(List<?> list) {
        TableDataInfo rspData = new TableDataInfo();
        rspData.setCode(200);
        rspData.setRows(list);
        rspData.setMsg("查询成功");
        rspData.setTotal((new PageInfo(list)).getTotal());
        return rspData;
    }
}
