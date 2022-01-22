package com.keyhuy.paging.pojo.dto;

/**
 * 分页传输对象
 *
 * @author Key
 * @date 2022/01/16/22:49
 **/
public class PageDTO<T extends PageDTO<?>> {

    /**
     * 当前页码
     */
    private Integer currPage;
    /**
     * 每页显示数据的数量
     */
    private Integer pageSize;
    /**
     * 查询分页数据的关键词
     */
    private String pageDataKey;

    public PageDTO() {
    }

    public PageDTO(Integer currPage, Integer pageSize, String pageDataKey) {
        this.currPage = currPage;
        this.pageSize = pageSize;
        this.pageDataKey = pageDataKey;
    }

    public PageDTO(Integer currPage, Integer pageSize) {
        this.currPage = currPage;
        this.pageSize = pageSize;
    }

    /**
     * 修改当前页码为当前页的起始页码，方便数据库查询
     *  - 将this强转成泛型T会产生警告，添加@SuppressWarning注解可以抑制编译器产生警告
     */
    @SuppressWarnings("unchecked")
    public T calcCurrPage() {
        // 起始页码 = （当前页码 - 1） * 每页数据数量
        currPage = (currPage - 1) * pageSize;
        // 直接返回泛型对应的对象
        return (T) this;
    }

    public Integer getCurrPage() {
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

    public String getPageDataKey() {
        return pageDataKey;
    }

    public void setPageDataKey(String pageDataKey) {
        this.pageDataKey = pageDataKey;
    }

    @Override
    public String toString() {
        return "PageDTO{" +
                "currPage=" + currPage +
                ", pageSize=" + pageSize +
                ", pageDataKey='" + pageDataKey + '\'' +
                '}';
    }
}
