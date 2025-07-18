package com.learn.demo;

import com.learn.demo.byJava.model.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        User tom = ctx.getBean("Tom", User.class);
        System.out.println("tom = " + tom);
    }
}
