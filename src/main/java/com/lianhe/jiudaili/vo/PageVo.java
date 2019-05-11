package com.lianhe.jiudaili.vo;

import java.util.List;

public class PageVo<T> {
    private Integer currentPage;//当前页
    private Integer pageSize=5;//每页行数
    private Integer totalPage;//总页数
    private List<T> pageInfo;//每页的内容

    public PageVo() {
    }

    public PageVo(Integer currentPage, Integer pageSize, Integer totalPage, List<T> pageInfo) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalPage = totalPage;
        this.pageInfo = pageInfo;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(List<T> pageInfo) {
        this.pageInfo = pageInfo;
    }
}
