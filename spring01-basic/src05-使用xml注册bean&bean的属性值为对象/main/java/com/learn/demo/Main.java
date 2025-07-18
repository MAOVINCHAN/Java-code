package com.learn.demo;

import com.learn.demo.byJava.model.Book;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        Book sgyy = ctx.getBean("book-sgyy", Book.class);
        System.out.println("sgyy = " + sgyy);

        Book hlm = ctx.getBean("book-hlm", Book.class);
        System.out.println("hlm = " + hlm);

        Book xyj = ctx.getBean("book-xyj", Book.class);
        System.out.println("xyj = " + xyj);
    }
}
