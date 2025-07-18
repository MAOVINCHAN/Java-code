package com.it.p1_map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        Student zs = new Student("zhangsan", 20);

        HashMap<String, Student> map = new HashMap<>();
        map.put("person1", zs);
        Student person1 = map.get("person1");


        System.out.println("是否为同一实例：" + (person1 == zs));

        // 遍历1
        Set<String> keys = map.keySet();
        for (String key : keys) {
            Student student = map.get(key);
            System.out.println("student: " + student.toString());
        }

        // 遍历2
        Set<Map.Entry<String, Student>> entries = map.entrySet();
        for (Map.Entry<String, Student> entry : entries) {
            String key = entry.getKey();
            Student value = entry.getValue();
            System.out.println("key: " + key + ",value: " + value);
        }
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
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

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
