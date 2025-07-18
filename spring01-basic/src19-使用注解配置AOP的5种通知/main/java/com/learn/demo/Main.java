package com.learn.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 用注解的方式使用AOP
 *
 * 项目需要添加依赖： org.aspectj:aspectjrt:1.9.8     org.aspectj:aspectjweaver:1.9.8
 */
@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        ICalculator calculator = ctx.getBean(ICalculator.class);
        calculator.add(9, 9);
        System.out.println("---------------------------------");
        calculator.min(35, 6);
    }
}
