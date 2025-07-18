package com.learn.model;

import java.util.List;

public class Grade {
    private Integer gid;
    private String gradeName;
    private List<Course> courseList;

    public Grade() {
    }

    public Grade(Integer gid, String gradeName) {
        this.gid = gid;
        this.gradeName = gradeName;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Override
    public String toString() {
        return "Grade{" +
                "gid=" + gid +
                ", gradeName='" + gradeName + '\'' +
                ", courseList=" + courseList +
                '}';
    }
}
