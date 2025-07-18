package com.learn.demo08servlet1.model;

public class RespBean {
    private int status;
    private String msg;

    private RespBean() {}

    private RespBean(int status, String msg) {
        this.status = status;
        this.msg = msg;
    }

    public static RespBean success(String msg) {
        return new RespBean(200, msg);
    }

    public static RespBean error(String msg) {
        return new RespBean(500, msg);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
