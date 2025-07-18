package com.it.p3_reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Objects;

public class Main {
    public static void main(String[] args) throws Exception {
        // 获取类对应的Class实例
        // 这三种方式获取的Class实例都是同一个实例，因为JVM对每个加载的Class只创建一个Class实例来表示它的类型。
        // 方式一：通过类名获取
        Class cls1 = Person.class;
        // 方式二：通过实例获取
        Class cls2 = new Person("Tom", 18, 100).getClass();
        // 方式三：通过完整包名获取
        Class cls3 = Class.forName("java.lang.String");

        // printClassInfo(cls1);

        // 通过获取的Class创建实例
        Person cls1o = (Person) cls1.newInstance(); // 只能调用public的无参构造方法,没有则报错
        int age = cls1o.getAge();
        System.out.println("age is: " + age);

        // getFieldAndValue();
        //getMethodAndExecute();
        // getConstructor();
        getExtendRela();
    }

    // 打印Class信息
    public static void printClassInfo(Object o) {
        Class cls = o.getClass();
        System.out.println("package: " + cls.getPackage());
        System.out.println("is annotation: " + cls.isAnnotation());
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("class: " + cls.getClass());
        System.out.println("name: " + cls.getName());
        System.out.println("simple name: " + cls.getSimpleName());
        System.out.println("declared fields: " + Arrays.toString(cls.getDeclaredFields()));
        System.out.println("declared method: " + Arrays.toString(cls.getDeclaredMethods()));
    }

    // 获取字段 - 获取值 - 设置值
    public static void getFieldAndValue() throws Exception {
        Person tom = new Person("Tom", 18, 100);
        Class cls = tom.getClass();

        Field id1 = cls.getField("id"); // 获取单个包括父类的public字段
        Field id2 = cls.getDeclaredField("id"); // 获取单个不包括父类的字段
        System.out.println("id is: " + id1);

        Field[] fields1 = cls.getFields(); // 获取多个包括父类的public字段
        Field[] fields2 = cls.getDeclaredFields(); // 获取多个不包括父类的字段
        System.out.println("多个包括父类的public字段: " + Arrays.toString(fields1));

        // 获取字段值
        Object id_val = id2.get(tom);
        System.out.println("id's value: " + id_val);

        // 设置字段值
        id2.set(tom, 22222);
        Object res = id2.get(tom);
        System.out.println("new id's value: " + res);
    }


    // 获取方法 - 执行方法
    public static void getMethodAndExecute() throws Exception {
        Person jerry = new Person("Jerry", 20, 100);
        Class cls = jerry.getClass();

        Method getName = cls.getMethod("getName"); // 获取单个包括父类的public方法
        Method testPrint = cls.getDeclaredMethod("testPrint"); // 获取单个不包括父类的方法
        testPrint.setAccessible(true); // 允许被invoke调用private方法

        Object invoke = getName.invoke(jerry);
        System.out.println("invoke name: " + invoke);

        testPrint.invoke(jerry); // 第二个参数开始为调用方法需要传入的参数
    }


    // 调用构造方法
    public static void getConstructor() throws Exception {
        Person tony = new Person("Tony", 19, 100);
        Class cls = tony.getClass();
        Person newInst = (Person)cls.newInstance(); // 缺陷：只能调用无参构造
        System.out.println(newInst.toString());

        // 获取并调用有参构造
        // Person(String name, int age, float score)
        Constructor constructor = cls.getConstructor(String.class, int.class, float.class); // 传入每个参数类型的Class
        Person blob = (Person)constructor.newInstance("Blob", 25, 100);
        System.out.println(blob.toString());
    }


    // 获取继承关系
    public static void getExtendRela() {
        Class<Integer> integerClass = Integer.class;
        System.out.println("integerClass: " + integerClass);

        // 获取父类Class
        Class superclass = integerClass.getSuperclass();
        System.out.println("superclass: " + superclass);

        // 获取interface
        Class[] interfaces = integerClass.getInterfaces();

        for (Class is :
                interfaces) {
            System.out.println("is: " + is);
            /**
             * 得出结论：
             * Integer实现了：
             * interface java.lang.Comparable
             * interface java.lang.constant.Constable
             * interface java.lang.constant.ConstantDesc
             */
        }
    }

}

class Person {
    public int id = 101010;
    private String name;
    private int age;
    private float score;

    public Person() {
        this.name = "";
        this.age = 0;
        this.score = 0;
    }

    private void testPrint() {
        System.out.println("此方法为私密方法");
    }


    public Person(String name, int age, float score) {
        this.name = name;
        this.age = age;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getScore() {
        return score;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setScore(float score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", score=" + score +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Float.compare(person.score, score) == 0 && Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, score);
    }
}
