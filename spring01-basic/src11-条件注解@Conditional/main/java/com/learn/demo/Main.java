package com.learn.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 条件注解： 用于在不同条件下注册不用的bean
 * 使用方式：
 * 1. 给需要注册的bean添加注解 @Conditional(实现Condition.class)
 * 2. 编写(实现Condition.java)并实现Condition重写matches方法
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        IShowCmd showCmd = ctx.getBean("showCmd", IShowCmd.class);
        String cmd = showCmd.show();
        System.out.println("cmd = " + cmd);
    }
}
