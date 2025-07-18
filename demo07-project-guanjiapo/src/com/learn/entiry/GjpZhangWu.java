package com.learn.entiry;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

public class GjpZhangWu implements Serializable {
    private int zwid;
    private String flname;
    private double money;
    private String zhangHu;
    private Date createtime;
    private String description;

    public GjpZhangWu() {
    }

    public GjpZhangWu(int zwid, String flname, double money, String zhangHu, Date createtime, String description) {
        this.zwid = zwid;
        this.flname = flname;
        this.money = money;
        this.zhangHu = zhangHu;
        this.createtime = createtime;
        this.description = description;
    }

    public int getZwid() {
        return zwid;
    }

    public void setZwid(int zwid) {
        this.zwid = zwid;
    }

    public String getFlname() {
        return flname;
    }

    public void setFlname(String flname) {
        this.flname = flname;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public String getZhangHu() {
        return zhangHu;
    }

    public void setZhangHu(String zhangHu) {
        this.zhangHu = zhangHu;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "GjpZhangWu{" +
                "zwid=" + zwid +
                ", flname='" + flname + '\'' +
                ", money=" + money +
                ", zhangHu='" + zhangHu + '\'' +
                ", createtime=" + createtime +
                ", description='" + description + '\'' +
                '}';
    }
}
