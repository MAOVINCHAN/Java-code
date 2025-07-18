package com.learn.demo.dao;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int add(String username, Double money) {
        int i = jdbcTemplate.update("update user_balance set balance=balance + ? where username = ?", money, username);
        System.out.println(username + "新增：" + money);
        return i;
    }

    public int minus(String username, Double money) {
        int i = jdbcTemplate.update("update user_balance set balance=balance - ? where username = ?", money, username);
        System.out.println(username + "减少：" + money);
        return i;
    }
}
