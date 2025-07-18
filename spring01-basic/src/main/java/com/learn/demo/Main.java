package com.learn.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        ICalculator calculator = ctx.getBean(ICalculator.class);
        int add = calculator.add(7, 9);
        System.out.println("-------------------------------");
        calculator.min(88, 6);
    }
}
