package com.administrator.day01_3.bean;

/**
 * Created by Administrator on 2019/5/27.
 */

public class IntergerBean {
    private Integer src;
    private String name;

    public IntergerBean(Integer src, String name) {
        this.src = src;
        this.name = name;
    }

    public Integer getSrc() {
        return src;
    }

    public void setSrc(Integer src) {
        this.src = src;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
