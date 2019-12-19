package com.tjpu.bs.netsc.pojo;

import java.io.Serializable;
import java.util.List;

/**
 * 分页返回的实体类
 * @author zxp
 *
 */
public class PageResult implements Serializable{
	private long total; // 总记录数
	private long pageSize; // 分页大小
	private long pages; // 总页数
	private long current; // 当前页码
	private List rows; // 返回每页的数据的集合

    public PageResult(long total, long pageSize, long pages, long current, List rows) {
        super();
        this.total = total;
        this.pageSize = pageSize;
        this.pages = pages;
        this.current = current;
        this.rows = rows;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public long getPages() {
        return pages;
    }

    public void setPages(long pages) {
        this.pages = pages;
    }

    public long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }
}
