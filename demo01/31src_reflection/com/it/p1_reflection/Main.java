package com.it.p1_reflection;


import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws Exception {
        // 获取class的Class方式1: 通过类本身.class获取
        Class<Student> stu1 = Student.class;
        // 获取class的Class方式2: 通过实例.getClass()获取
        Class<? extends Student> stu2 = new Student("aa", 18).getClass();
        // 获取class的Class方式3: 通过Class.forName(“类的完整类名（如：java.lang.String）”)
        Class<?> stu3 = Class.forName("com.it.p1_reflection.Student");


        // 获取到的都是同一个Class实例对象
        //System.out.println(stu1 == stu2); // true
        //System.out.println(stu1 == stu3); // true


        // printClassInfo("".getClass());
        // printClassInfo(Runnable.class);
        // printClassInfo(java.time.Month.class);
        // printClassInfo(String[].class);
        // printClassInfo(int.class);


        // 访问Class实例对象的字段
        // 根据字段名获取public的Field，包括父类
        Field color = stu1.getField("color");
        //System.out.println("color is: " + color); // public java.lang.String com.it.p1_reflection.Student.color
        // 获取所有public的Field，包括父类
        Field[] PublicFields = stu1.getFields();
        //System.out.println("PublicFields is: " + Arrays.toString(PublicFields)); // [..]
        // 根据字段名获取public的Field，不包括父类
        Field name = stu1.getDeclaredField("name");
        //System.out.println("name is: " + name); // public java.lang.String com.it.p1_reflection.Student.name
        // 获取所有public的Field，不包括父类
        Field[] declaredFields = stu1.getDeclaredFields();
        //System.out.println("declaredFields is: " + Arrays.toString(declaredFields)); // [..]


        // 访问Class实例对象的方法
        // 根据字段名获取public的Method，包括父类
        Method sayHi = stu2.getMethod("sayHi");
        sayHi.invoke(new Student());
    }

    // Class实例对象相关方法
    static void printClassInfo(Class cls) {
        System.out.println("Class name: " + cls.getName());
        System.out.println("Simple name: " + cls.getSimpleName());
        if (cls.getPackage() != null) {
            System.out.println("Package name: " + cls.getPackage().getName());
        }
        System.out.println("is interface: " + cls.isInterface());
        System.out.println("is enum: " + cls.isEnum());
        System.out.println("is array: " + cls.isArray());
        System.out.println("is primitive: " + cls.isPrimitive());
        System.out.println("-------------------------------------------");
    }
}
