package com.project.stusys.model;

public class Student {
    private Integer sid;
    private String number;
    private String name;
    private String gender;
    private String phone;
    private String qq;
    private Clazz clazz;
    private Grade grade;

    public Student() {
    }

    public Student(Integer sid, String number, String name, String gender, String phone, String qq) {
        this.sid = sid;
        this.number = number;
        this.name = name;
        this.gender = gender;
        this.phone = phone;
        this.qq = qq;
    }

    public Integer getSid() {
        return sid;
    }

    public void setSid(Integer sid) {
        this.sid = sid;
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

    public Clazz getClazz() {
        return clazz;
    }

    public void setClazz(Clazz clazz) {
        this.clazz = clazz;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }
}
