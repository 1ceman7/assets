package com.yize.www.utils;

import java.util.List;

public class PageModel {
    //默认第一页
    private int pageNum = 1;
    //显示几条数据
    private int pageCount =5;
    //总数
    private int pageTotal;
    //页码最大值（总页数）
    private int maxPageNum;
    private List rows ;
    private int start ;
    //从第几条开始(比如第3页就是当前页减去1 = 2 乘以显示数量10 = 20；从下标20开始显示)
    public int getStart() {
        return (pageNum - 1) * pageCount;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public void setPageTotal(int pageTotal) {
        this.pageTotal = pageTotal;
        //计算最大页码数
        maxPageNum = (pageTotal + pageCount - 1) / pageCount;
        //解决pageNum初始化问题
        if (pageNum < 1)pageNum=1;
        if (pageNum > maxPageNum) pageNum = maxPageNum;
    }
    public int getMaxPageNum() {
        return maxPageNum;
        //return (getPageTotal() + getPageCount() - 1) / getPageCount();
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
