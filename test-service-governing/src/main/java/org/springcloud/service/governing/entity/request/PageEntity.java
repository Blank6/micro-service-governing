package org.springcloud.service.governing.entity.request;

import java.util.List;

public class PageEntity<T> {
    //当前页
    private Long total;
    //当前页记录
    private List<T> obj;


    public PageEntity(Long total, List<T> result) {
        this.total = total;
        this.obj = result;
    }

    public PageEntity() {

    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getObj() {
        return obj;
    }

    public void setObj(List<T> obj) {
        this.obj = obj;
    }

    @Override
    public String toString() {
        return "PageEntity{" +
                "total=" + total +
                ", obj=" + obj +
                '}';
    }
}
