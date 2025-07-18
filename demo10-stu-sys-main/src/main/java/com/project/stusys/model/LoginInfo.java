package com.project.stusys.model;

public class LoginInfo {
    private int code; // -1异常 0失败 1成功
    private String info; // msg
    private Object data; // user

    public LoginInfo() {
    }

    public LoginInfo(int code, String info, Object data) {
        this.code = code;
        this.info = info;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "LoginInfo{" +
                "code=" + code +
                ", info='" + info + '\'' +
                ", data=" + data +
                '}';
    }
}
