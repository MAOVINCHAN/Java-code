package com.qf.entity;

import java.io.Serializable;

/**
 * 实体类：用户表
 * 类名对应表名
 */
public class UserSheet implements Serializable {
    // 私有的属性对应数据库的列名
    private int id;
    private String username;
    private String password;
    private int age;
    private String phone_number;
    private String address;
    private double score;

    public UserSheet() {
    }

    public UserSheet(int id, String username, String password, int age, String phone_number, String address, double score) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.age = age;
        this.phone_number = phone_number;
        this.address = address;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "UserSheet{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", age=" + age +
                ", phone_number='" + phone_number + '\'' +
                ", address='" + address + '\'' +
                ", score=" + score +
                '}';
    }
}
