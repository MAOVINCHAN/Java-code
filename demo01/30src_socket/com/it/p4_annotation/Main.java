package com.it.p4_annotation;

import java.lang.annotation.*;

public class Main {
    public static void main(String[] args) {
        boolean has = MyClass.class.isAnnotationPresent(MyAnnotation1.class);

        MyAnnotation1 annotation = MyClass.class.getAnnotation(MyAnnotation1.class);

        int max = annotation.max();
    }
}

@MyAnnotation1()
class MyClass {

}

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation1 {
    int min() default  0;
    int max() default 100;
}
