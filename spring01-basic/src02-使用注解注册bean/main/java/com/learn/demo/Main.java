package com.learn.demo;

import com.learn.demo.byJava.model.User;
import com.learn.demo.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 使用注解注册bean
 */

@Configuration
@ComponentScan
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        UserService userService = ctx.getBean(UserService.class);

        userService.register("1481861850@qq.com", "123456", "Tom");

        User user = userService.login("1481861850@qq.com", "123456");
        System.out.println("user.getName() = " + user.getName());
    }
}
