package com.learn.demo;

import com.learn.demo.config.JavaConfig;
import com.learn.demo.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * 1. 配置类开启 @EnableTransactionManagement, 无需再开启@EnableAspectjAutoProxy
 * 2. 需要用到事务的方法添加 @Transactional
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        UserService userService = ctx.getBean(UserService.class);
        userService.transferMoney("Tom", "Jerry", 500.0); // transaction success
    }
}
