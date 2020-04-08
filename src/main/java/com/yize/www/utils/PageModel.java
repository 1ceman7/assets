package com.yize.www.utils;

import java.util.List;

public class PageModel {
    //第几页
    private int pageNum = 1;
    //显示几条数据
    private int pageCount =5;
    //总数
    private int pageTotal;
    //页码最大值
    private int maxPageNum;
    //从第几条开始，比如第3页减去1 = 2 乘以显示数量10 = 20；从下标20开始显示
    private int start;
    private List rows ;

    public int getStart() {
        return (pageNum - 1) * pageCount;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setPageTotal(int pageTotal) {
        if (pageNum < 1){
            this.pageNum = 1 ;
        }else {
            this.pageTotal = pageTotal;
        }
    }
    public int getMaxPageNum() {

        return (getPageTotal() + getPageCount() - 1) / getPageCount();
    }


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    public int getPageTotal() {
        return pageTotal;
    }

    public void setMaxPageNum(int maxPageNum) {
        this.maxPageNum = maxPageNum;
    }

    public List getRows() {
        return rows;
    }

    public void setRows(List rows) {
        this.rows = rows;
    }





}
