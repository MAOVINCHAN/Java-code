package com.learn.demo.byJava.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
@ComponentScan("com.learn.demo")
/**
 * 加载properties文件到spring容器中
 * 与xml标签<context:property-placeholder location="db.properties" />等价
 * 可以在本文件中加载文件，在xml中通过value="${属性}"的方式读取，也可以xml中加载，在Java代码中使用@Value("属性")读取，可以交叉使用
 */
@PropertySource("classpath:db.properties")
public class JavaConfig {
    @Value("${db.url}")
    private String url;
    @Value("${db.username}")
    private String username;
    @Value("${db.password}")
    private String password;
    @Bean
    DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }



    // @Bean
    // DataSource dataSource() {
    //     DruidDataSource ds = new DruidDataSource();
    //     ds.setUrl("jdbc:mysql://localhost:3306/stu_manage?serverTimezone=UTC");
    //     ds.setUsername("root");
    //     ds.setPassword("Root123456!#");
    //     return ds;
    // }

    @Bean
    JdbcTemplate jdbcTemplate() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        jdbcTemplate.setDataSource(dataSource());
        return jdbcTemplate;
    }
}
