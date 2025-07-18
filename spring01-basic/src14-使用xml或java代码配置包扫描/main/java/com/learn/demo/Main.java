package com.learn.demo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 配置包扫描
 * 1. 注册bean
 * @Repository 一般用于dao层
 * @Component 一般用于其他组件的注册
 * @Contronl 一般用于控制层，如servlet
 * @Service 一般用于业务层
 * 2. 获取bean
 *      a. 通过有参构造获取(官方推荐)
 *      b. 通过@Autowried自动注入(日常使用更多)
 * 3. 配置包扫描
 *      a. 添加@Configrution注解
 *      b. 添加@ComponentScan注解，可以指定一个包名称，表示仅扫描该包及其所有子包
 */

@Configuration
@ComponentScan(basePackages = "com.learn.demo") // 默认为注解所在包及其所有子包
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(Main.class);
        UserServlet userServlet = ctx.getBean(UserServlet.class);
        User tom = userServlet.getUserByUsername("Tom");
        System.out.println("tom = " + tom);
    }
}
