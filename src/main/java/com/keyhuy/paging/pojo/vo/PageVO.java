package com.keyhuy.paging.pojo.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.keyhuy.paging.pojo.dto.PageDTO;

import java.util.List;

/**
 * 分页值对象
 *  - 显示到前台的分页信息
 *
 * @author Key
 * @date 2022/01/22/10:01
 **/
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PageVO<T> {

    /**
     * 当前页码
     */
    private Integer currPage;

    /**
     * 每页显示数量
     */
    private Integer pageSize;

    /**
     * 总页码
     */
    private Integer totalPage;

    /**
     * 总记录数
     */
    private Integer totalCount;

    /**
     * 每页显示的数据
     */
    private List<T> pageDataList;

    public PageVO() {
    }

    /**
     * 通过分页dto设置vo的当前页码和每页数量
     */
    public PageVO<T> setCurrAndSize(PageDTO<?> pageDTO) {

        // 将dto中当前页码和每页数量设置为vo对对应成员变量，也可以使用BeanUtils实现
        this.setCurrPage(pageDTO.getCurrPage());
        this.setPageSize(pageDTO.getPageSize());
        return this;
    }

    /**
     * 根据总记录数设置总记录数，同时计算出总页码并设置
     */
    public void setTotalPageAndCount(Integer totalCount) {
        // 计算总页码
        int totalPage = totalCount / pageSize + (totalCount % pageSize == 0 ? 0 : 1);

        // 设置总页码和总记录数
        this.setTotalCount(totalCount);
        this.setTotalPage(totalPage);
    }

    public Integer getCurPage() {
        return currPage;
    }

    public void setCurrPage(Integer currPage) {
        this.currPage = currPage;
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

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getPageDataList() {
        return pageDataList;
    }

    public void setPageDataList(List<T> pageDataList) {
        this.pageDataList = pageDataList;
    }

    @Override
    public String toString() {
        return "PageVO{" +
                "curPage=" + currPage +
                ", pageSize=" + pageSize +
                ", totalPage=" + totalPage +
                ", totalCount=" + totalCount +
                ", pageDataList=" + pageDataList +
                '}';
    }
}
