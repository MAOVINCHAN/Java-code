package com.learn.demo;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class Test01 {
    ClassPathXmlApplicationContext ctx;
    @Before
    public void before() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void test01() throws IOException {
        User user = ctx.getBean("user", User.class);
        System.out.println("user = " + user);
    }

    @After
    public void after() {
        ctx.close();
    }
}
