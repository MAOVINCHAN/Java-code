package com.learn.demo;

public class User {
    private String username;
    private String address;
    public void init() {
        System.out.println("这里可以执行初始化操作");
    }
    public void destroy() {
        System.out.println("这里可以执行销毁操作");
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
