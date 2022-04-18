package com.wbz.system.domain;

import com.alibaba.excel.annotation.ExcelIgnore;

import java.io.Serializable;

public class BaseEntity implements Serializable {

    @ExcelIgnore
    private Integer pageNum;
    @ExcelIgnore
    private Integer pageSize;
    @ExcelIgnore
    private String orderBy;

    public BaseEntity() {
    }

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
}
