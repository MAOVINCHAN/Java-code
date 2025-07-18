package com.learn.demo;


import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用步骤：
 * 1. applicationContext.xml添加<beans profile="xxx"></beans>标签,并在标签内配置bean
 * 2. 创建ctx时先不指定xml的calsspath
 * 3. 设置环境
 */
public class Main {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext();
        ctx.getEnvironment().setActiveProfiles("pro"); // 设置环境
        ctx.setConfigLocation("applicationContext.xml"); // 加载配置文件
        ctx.refresh(); // 刷新上下文

        // 获取bean
        DataSource ds = ctx.getBean("ds", DataSource.class);
        System.out.println("ds = " + ds);
    }
}
