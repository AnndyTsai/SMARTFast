package com.smartfast.common.pojo;

import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author li
 * @param <T> 泛型的写法
 */
public class PageResult<T> {

    /**
     * 总条数
     */
    @ApiModelProperty(value = "总条数")
    private Long total;
    /**
     * 总页数
     */
    @ApiModelProperty(value = "总页数")
    private Integer totalPage;
    /**
     * 当前页数据
     */
    @ApiModelProperty(value = "数据对象")
    private List<T> items;

    public PageResult() {
    }

    public PageResult(Long total, List<T> items) {
        this.total = total;
        this.items = items;
    }

    public PageResult(Long total, Integer totalPage, List<T> items) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    public Integer getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Integer totalPage) {
        this.totalPage = totalPage;
    }
}