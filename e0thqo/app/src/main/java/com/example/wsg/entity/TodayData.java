package com.example.wsg.entity;

/**
 * 项目名：App
 * 包名：com.example.wsg.app.entity
 * 文件名：TodayData
 * 创建者：wsg
 * 创建时间：2017/3/18  13:49
 * 描述：TODO
 */

public class TodayData {
    private String title;
    private String lunar;
    private String des;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLunar() {
        return lunar;
    }

    public void setLunar(String lunar) {
        this.lunar = lunar;
    }

    public String getDes() {
        return des;
    }

    public void setDes(String des) {
        this.des = des;
    }

    @Override
    public String toString() {
        return "TodayData{" +
                "title='" + title + '\'' +
                ", lunar='" + lunar + '\'' +
                ", des='" + des + '\'' +
                '}';
    }
}
