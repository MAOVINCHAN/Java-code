package com.learn.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserDao {
    @Autowired
    JdbcTemplate jdbcTemplate;

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
