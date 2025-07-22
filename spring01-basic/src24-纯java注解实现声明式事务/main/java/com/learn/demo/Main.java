package com.learn.demo;

import com.learn.demo.config.AppConfig;
import com.learn.demo.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.transferMoney1("Tom", "Jerry", 200.0);
    }
}
