package com.learn.demo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * aop前置通知：
 * 1. 新增一个Advice类并implements MethodBeforeAdvice接口，重写before方法，before方法内无需手动调用函数且无返回值
 * 2. xml新增<aop:config></aop:config>标签
 * 3. 注册需要拦截的类bean，注册advice类bean
 * 4. 切点定义：
 *      当拦截的类是由接口实现，则execution内的类需要指定该类实现的接口，<bean>注册为该接口的具体实现；(切点为接口，bean为接口实现)
 *      当拦截的类未由接口实现，则execution内的类指定该类即可，<bean>注册为该类即可。(切点为该类，bean也是该类)
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        ICalculator calculator = ctx.getBean(ICalculator.class);
        calculator.add(3, 5);
    }
}
