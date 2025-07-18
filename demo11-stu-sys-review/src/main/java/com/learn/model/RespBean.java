package com.learn.model;

public class RespBean {
    private int status;
    private String message;
    private Object data;

    public RespBean() {
    }

    public RespBean(int status, String message, Object data) {
        this.status = status;
        this.message = message;
        this.data = data;
    }

    public static RespBean success(String message, Object data) {
        return new RespBean(200, message, data);
    }
    public static RespBean success(String message) {
        return new RespBean(200, message, null);
    }

    public static RespBean error(String message, Object data) {
        return new RespBean(500, message, data);
    }
    public static RespBean error(String message) {
        return new RespBean(500, message, null);
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "RespBean{" +
                "status=" + status +
                ", message='" + message + '\'' +
                ", data=" + data +
                '}';
    }
}
