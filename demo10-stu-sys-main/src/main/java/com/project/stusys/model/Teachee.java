package com.project.stusys.model;

import java.util.List;
import java.util.Map;

public class Teachee {
    private Integer tid;
    private String number;
    private String name;
    private String gender;
    private String phone;
    private String qq;
    private List<Map<String, Object>> courseList;

    public List<Map<String, Object>> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Map<String, Object>> courseList) {
        this.courseList = courseList;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    @Override
    public String toString() {
        return "Teachee{" +
                "tid=" + tid +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", gender='" + gender + '\'' +
                ", phone='" + phone + '\'' +
                ", qq='" + qq + '\'' +
                '}';
    }
}
