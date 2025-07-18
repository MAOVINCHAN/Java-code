package com.learn.demo.byJava.model;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class User {
    private String name;
    private Integer age;
    private Cat[] cats;
    private List<Car> cars;
    private Set<String> weChart;
    private Map<String, Hobby> hobby;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Cat[] getCats() {
        return cats;
    }

    public void setCats(Cat[] cats) {
        this.cats = cats;
    }

    public List<Car> getCars() {
        return cars;
    }

    public void setCars(List<Car> cars) {
        this.cars = cars;
    }

    public Set<String> getWeChart() {
        return weChart;
    }

    public void setWeChart(Set<String> weChart) {
        this.weChart = weChart;
    }

    public Map<String, Hobby> getHobby() {
        return hobby;
    }

    public void setHobby(Map<String, Hobby> hobby) {
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", cats=" + Arrays.toString(cats) +
                ", cars=" + cars +
                ", weChart=" + weChart +
                ", hobby=" + hobby +
                '}';
    }
}
