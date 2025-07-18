package com.learn.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用xml配置包扫描
 */
public class XmlMain {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("basePackage.xml");
        UserServlet userServlet = ctx.getBean(UserServlet.class);
        User jerry = userServlet.getUserByUsername("Jerry");
        System.out.println("jerry = " + jerry);
    }
}
