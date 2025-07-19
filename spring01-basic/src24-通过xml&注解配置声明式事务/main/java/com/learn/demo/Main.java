package com.learn.demo;

import com.learn.demo.service.UserService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 通过xml + 注解形式配置事务
 * 主要是1. xml中配置<tx:annotation-driven />开启事务代理，2. 需要拦截的方法出添加注解@Transactinal
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = ctx.getBean(UserService.class);
        userService.transferMoney("Tom", "Jerry", 500.0);
    }
}
