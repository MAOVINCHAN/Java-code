package com.project.stusys.model;

import java.util.List;

public class Grade {
    private Integer gid;
    private String gradeName;
    private List<Course> gradeCourse;

    public Grade() {
    }

    public Grade(Integer gid) {
        this.gid = gid;
    }

    public Grade(Integer gid, String gradeName) {
        this.gid = gid;
        this.gradeName = gradeName;
    }

    public List<Course> getGradeCourse() {
        return gradeCourse;
    }

    public void setGradeCourse(List<Course> gradeCourse) {
        this.gradeCourse = gradeCourse;
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

    @Override
    public String toString() {
        return "Grade{" +
                "gid=" + gid +
                ", gradeName='" + gradeName + '\'' +
                '}';
    }
}
