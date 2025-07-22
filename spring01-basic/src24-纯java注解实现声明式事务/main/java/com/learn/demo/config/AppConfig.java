package com.learn.demo.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@Configuration
@ComponentScan(basePackages = "com.learn.demo")
@EnableTransactionManagement
@PropertySource("classpath:db.properties")
public class AppConfig {
    @Value("${db.url}")
    String url;
    @Value("${db.username}")
    String username;
    @Value("${db.password}")
    String password;

    @Bean
    DataSource dataSource() {
        DruidDataSource ds = new DruidDataSource();
        ds.setUrl(url);
        ds.setUsername(username);
        ds.setPassword(password);
        return ds;
    }

    @Bean
    JdbcTemplate jdbcTemplate() {
        JdbcTemplate jt = new JdbcTemplate();
        jt.setDataSource(dataSource());
        return jt;
    }

    @Bean
    PlatformTransactionManager transactionManager() {
        DataSourceTransactionManager m = new DataSourceTransactionManager();
        m.setDataSource(dataSource());
        return m;
    }
}
