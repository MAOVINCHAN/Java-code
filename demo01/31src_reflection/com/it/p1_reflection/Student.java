package com.it.p1_reflection;

public class Student extends Person {
    public String name;
    private int age;

    public Student() {
        super();
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void sayHi() {
        System.out.println("hello world!");
    }
}
