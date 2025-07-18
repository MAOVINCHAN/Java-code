package com.learn.demo;

import com.learn.demo.byJava.config.JavaConfig;
import com.learn.demo.byJava.model.Book;
import com.learn.demo.byJava.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        User user1 = ctx.getBean(User.class);
        System.out.println("user1 = " + user1);
        User user2 = ctx.getBean(User.class);
        System.out.println("user2 = " + user2);
        System.out.println(user1 == user2); // false scope=prototype


        Book book = ctx.getBean(Book.class);
        System.out.println("book = " + book);
    }
}
