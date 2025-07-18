package com.learn.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @Profile 底层实现是@Conditional
 * 使用步骤：
 * 1. 给需要注册的bean添加注解@Profile("dev") // 参数可以有多个
 * 2. 获取上下文ctx对象时，先不指定配置类.class
 * 3. 使用ctx.getEnvironment().setActiveProfiles("xxx")设置环境
 * 4. ctx.register(JavaConfig.class)
 * 5. ctx.refresh()
 * 6. 获取bean
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        // 设置环境
        ctx.getEnvironment().setActiveProfiles("pro"); // 参数可以有多个
        ctx.register(JavaConfig.class);
        ctx.refresh();

        // 获取bean
        DataSource ds = ctx.getBean("ds", DataSource.class);
        System.out.println("ds = " + ds);
    }
}
