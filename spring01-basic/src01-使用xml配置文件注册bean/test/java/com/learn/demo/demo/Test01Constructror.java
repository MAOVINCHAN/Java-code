package com.learn.demo.demo;

import com.learn.demo.byJava.model.User;
import org.junit.After;
import org.junit.Test;
import org.junit.Before;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test01Constructror {
    private ClassPathXmlApplicationContext ctx;
    // 在单元测试方法执行之前自动执行此方法
    @Before
    public void before() {
        ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    }

    @Test
    public void test03() {

    }

    @Test
    public void test02() {
        User u4 = ctx.getBean("user4", User.class);
        System.out.println("u4 = " + u4);
    }

    @Test
    public void test01() {
        // 调用无参构造bean
        User u1 = ctx.getBean("user1", User.class);
        System.out.println("u1 = " + u1);
        User u2 = ctx.getBean("user2", User.class);
        System.out.println("u2 = " + u2);
    }

    // 在单元测试方法执行之后自动执行此方法
    @After
    public void after() {
        ctx.close();
    }
}
