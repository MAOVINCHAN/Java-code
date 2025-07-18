package com.instance.stusys.model;

import java.util.List;

public class Pagination {
    private Integer total;
    private Integer page_count;
    private Integer current;

    public Integer getPage_count() {
        return page_count;
    }

    public void setPage_count(Integer page_count) {
        this.page_count = page_count;
    }

    private Integer limit;
    private boolean first;
    private boolean last;
    private String pre_url;
    private String next_url;
    private String first_url;
    private String last_url;
    private List<User> data;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public boolean isFirst() {
        return first;
    }

    public void setFirst(boolean first) {
        this.first = first;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    public String getPre_url() {
        return pre_url;
    }

    public void setPre_url(String pre_url) {
        this.pre_url = pre_url;
    }

    public String getNext_url() {
        return next_url;
    }

    public void setNext_url(String next_url) {
        this.next_url = next_url;
    }

    public String getFirst_url() {
        return first_url;
    }

    public void setFirst_url(String first_url) {
        this.first_url = first_url;
    }

    public String getLast_url() {
        return last_url;
    }

    public void setLast_url(String last_url) {
        this.last_url = last_url;
    }

    public List<User> getData() {
        return data;
    }

    public void setData(List<User> data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Pagination{" +
                "total=" + total +
                ", page_count=" + page_count +
                ", current=" + current +
                ", limit=" + limit +
                ", first=" + first +
                ", last=" + last +
                ", pre_url='" + pre_url + '\'' +
                ", next_url='" + next_url + '\'' +
                ", first_url='" + first_url + '\'' +
                ", last_url='" + last_url + '\'' +
                ", data=" + data +
                '}';
    }
}
