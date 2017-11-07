package com.pojo;

import java.util.List;

/**
 * Created by Elric on 2017/5/12.
 */
public class
PageBean<T> {
    private int currPage; // 当前页数
    private int pageSize; // 每页显示的记录数
    private int totalCount; // 总记录数
    private int totalPage; // 总页数
    private List<T> list; // 每页显示的数据
    private String type;//当前是哪种页面
    private Post post;
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;

    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public int getCurrPage() {
        return currPage;
    }

    public void setCurrPage(int currPage) {
        this.currPage = currPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
