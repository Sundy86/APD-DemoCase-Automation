package com.cccis.util;

/**
 * Created by HePing on 2017/6/19.
 */
public enum TaskType {
    PROPERTY("三者物"), THIRD_PARTY("三者车"), SURVEY("查勘"), FIRST_PARTY("标的车");

    private String desc;

    TaskType(String desc) {
        this.desc = desc;
    }

    public String getDesc() {
        return desc;
    }

}
