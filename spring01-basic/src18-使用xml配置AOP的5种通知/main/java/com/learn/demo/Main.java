package com.learn.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ICalculator calculator = ctx.getBean(ICalculator.class);
        calculator.add(5, 7);

        System.out.println("-------------------------");

        calculator.minus(1555, 59);
    }
}
