package com.it.p4_annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * 标准注解：
 *  - @override 检查是否为重写方法
 *  - @SuppressWarnings 用于关闭对类、方法、成员编译时产生的特定警告。
 *  - @Deprecated 用于标明被修饰的类或类成员、类方法已经废弃、过时，不建议使用
 *  - @FunctionalInterface 用于指示被修饰的接口是函数式接口,在JDK8引入。
 *
 * 元注解：用于注解的注解
 *  - @Target 用于允许该注解使用的范围
 *  - @Retention 用来定义该注解在哪一个级别可用，在源代码中(SOURCE)、类文件中(CLASS)或者运行时(RUNTIME)
 *
 * 自定义注解：
 *  - @interface 声明
 */

public class Main {
    public static void main(String[] args) {
        Person tom = new Person("Tom", 10);

        try {
            check(tom);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // 检查使用Range注解的字段是否符合规范
    public static void check(Person person) throws IllegalArgumentException, ReflectiveOperationException {
        // 遍历所有Field:
        for (Field field : person.getClass().getDeclaredFields()) {
            // 获取Field定义的@Range:
            Range range = field.getAnnotation(Range.class);
            // 如果@Range存在:
            if (range != null) {
                // 获取Field的值:
                int value = (int) field.get(person);

                if(value == ((Integer)value).intValue()) {
                    if(value < range.min() || value > range.max()) {
                        throw new IllegalArgumentException("Invalid field: " + field.getName());
                    }
                }
            }
        }

        for (Field field :
                person.getClass().getDeclaredFields()) {
            Check check = field.getAnnotation(Check.class);
            if(check != null) {
                String value = (String) field.get(person);
                String[] allowValue = check.level();
                Integer index = -1;
                for (int i = 0; i < allowValue.length; i++) {
                    String item = allowValue[i];
                    if(item.equals(value)) {
                        index = i;
                    }
                }

                if(index == -1) {
                    throw new IllegalArgumentException(field.getName() + " allow: " + Arrays.toString(allowValue));
                }
            }
        }
    }

}


class Person {
    @Check
    String name;
    @Range(min = 0, max = 10)
    int age;

    public Person(String name, int age) {
        this.age = age;
        this.name = name;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name=" + name +
                ", age='" + age + '\'' +
                '}';
    }
}

// 定义注解
@Target({ElementType.FIELD, ElementType.TYPE}) // 必须写@Target
@Retention(RetentionPolicy.RUNTIME) // 必须写@Retention，一般为RUNTIME
@interface Range{
    int min() default 0;
    int max() default 100;
}


@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD, ElementType.CONSTRUCTOR})
@interface Check{
    String[] level() default  {"info", "success", "error"};
}
