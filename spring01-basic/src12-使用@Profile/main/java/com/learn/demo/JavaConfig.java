package com.learn.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
public class JavaConfig {
    @Bean("ds") // 需要是同名bean
    @Profile("dev") // 参数可以有多个
    DataSource devDs() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/dev");
        ds.setUsername("root");
        ds.setPassword("pwd123456");
        return ds;
    }

    @Bean("ds") // 需要是同名bean
    @Profile("pro") // 参数可以有多个
    DataSource prodDs() {
        DataSource ds = new DataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://localhost:3306/prod");
        ds.setUsername("dla");
        ds.setPassword("fdlajsdflkas");
        return ds;
    }
}
