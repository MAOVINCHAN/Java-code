package com.project.stusys.model;

public class Clazz {
    private Integer cid;
    private String clazzName;
    private String gradeName;

    public Clazz() {
    }

    public Clazz(Integer id) {
        this.cid = id;
    }

    public Clazz(Integer cid, String clazzName) {
        this.cid = cid;
        this.clazzName = clazzName;
    }

    public Clazz(String clazzName, String gradeName) {
        this.clazzName = clazzName;
        this.gradeName = gradeName;
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getClazzName() {
        return clazzName;
    }

    public void setClazzName(String clazzName) {
        this.clazzName = clazzName;
    }

    public String getGradeName() {
        return gradeName;
    }

    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
    }

    @Override
    public String toString() {
        return "Clazz{" +
                "clazzName='" + clazzName + '\'' +
                ", gradeName='" + gradeName + '\'' +
                '}';
    }
}
