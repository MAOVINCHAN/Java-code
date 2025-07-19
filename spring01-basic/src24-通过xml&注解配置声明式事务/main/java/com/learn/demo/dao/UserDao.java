package com.learn.demo.dao;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
    JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public int add(String username, Double money) {
        int i = 0;
        try {
            i = jdbcTemplate.update("update user_account set balance = balance + ? where username = ?", money, username);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        System.out.println(username + "新增：" + money);
        return i;
    }

    public void min(String username, Double money) {
        try {
            jdbcTemplate.update("update user_account set balance = balance - ? where username = ?", money, username);
        } catch (DataAccessException e) {
            e.printStackTrace();
        }
        System.out.println(username + "减少：" + money);
    }
}
