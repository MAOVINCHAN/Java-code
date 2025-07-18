package com.it.p7_set_project_student_manage;

public class Student {
    private int id;
    private String name;
    private int age;
    private float score;

    public Student(int id, String name, int age, float score) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof Student stu) {
            return stu.getId() == this.id &&
                    stu.getName() == this.name &&
                    stu.getAge() == this.age &&
                    stu.getScore() == this.score;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name=" + name +
                ", age=" + age +
                ", score=" + score +
                '}';
    }
}
