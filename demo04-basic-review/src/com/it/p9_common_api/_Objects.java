package com.it.p9_common_api;


import java.util.Objects;
import java.util.StringJoiner;

public class _Objects {
    public static void main(String[] args) throws CloneNotSupportedException {
        // 对象克隆步骤
        // 1. 重写Object的clone方法
        // 2. Java bean类实现Cloneable接口
        // 3. 调用实例的clone方法

        int[] data = {1,2,3,4,5,6,7,8,9};
        User tom1 = new User("Tom", 18, data);
        System.out.println("tom1" + tom1);

        User tom2 = (User)tom1.clone(); // 父类Object中的clone是浅拷贝
        int[] data1 = tom1.getData();
        data1[0] = 100; // tom2如果data[0]变成了100，则为浅拷贝，否则为深拷贝
        System.out.println("tom2" + tom2.toString());


        // 判断对象是否相等
        boolean result1 = Objects.equals(tom1, tom2);
        System.out.println(result1);

        // 判断是否为null
        boolean result2 = Objects.isNull(null);
        System.out.println(result2);
    }
}

class User implements Cloneable {
    private String name;
    private int age;
    private int[] data;

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

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    public User(String name, int age, int[] data) {
        this.name = name;
        this.age = age;
        this.data = data;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", data=" + arrayToString() +
                "}";
    }

    public String arrayToString() {
        StringJoiner sj = new StringJoiner(",", "[", "]");
        for (int i :
                data) {
            sj.add(String.valueOf(i));
        }
        return sj.toString();
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        // return super.clone();  //浅拷贝

        // 重写深拷贝clone方法
        // 主要对除非基本类型非字符串的引用数据类型，重新分配地址值
        int[] newData = new int[this.data.length];
        for (int i = 0; i < this.data.length; i++) {
            newData[i] = this.data[i];
        }
        User user = (User) super.clone();
        user.data = newData;
        return user;
    }
}
