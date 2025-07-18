package com.learn.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import java.time.ZoneId;

/**
 * 定制bean
 * 1. 可选注入： 使用@Autowried(required = false)
 * 2. 创建第三方bean: 在@Configuration类中编写一个Java方法创建并返回它，注意给方法标记一个@Bean注解
 */

@Configuration
@ComponentScan
public class Main {
    @Bean(name = "zoneId")
    static ZoneId createZoneId() {
        return ZoneId.of("Z");
    }
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        Validators validators = ctx.getBean(Validators.class);
        Boolean valid = validators.validate("1481861850@qq.com", "123456", "Tom");
        System.out.println(valid ? "校验成功" : "校验失败");

        ZoneId zoneId = ctx.getBean("zoneId", ZoneId.class);
        String id = zoneId.getId();
        System.out.println("id = " + id); // Z
    }
}
