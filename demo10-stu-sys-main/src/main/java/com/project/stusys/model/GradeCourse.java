package com.project.stusys.model;

public class GradeCourse {
    private Integer id;
    private String gradeName;
    private String courseName;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "GradeCourse{" +
                "gradeName='" + gradeName + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
