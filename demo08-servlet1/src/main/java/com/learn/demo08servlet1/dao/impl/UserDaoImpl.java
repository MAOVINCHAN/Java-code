package com.learn.demo08servlet1.dao.impl;

import com.learn.demo08servlet1.dao.UserDao;
import com.learn.demo08servlet1.model.User;
import com.learn.demo08servlet1.utils.dbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class UserDaoImpl implements UserDao {
    QueryRunner qr = new QueryRunner(dbUtils.getDataSource());
    @Override
    public User getUserById(int id) {
        String sql = "select * from user_sheet where id = ?";
        User user = null;
        try {
            user = qr.query(sql, new BeanHandler<>(User.class), id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    @Override
    public List<User> getUsers() {
        String sql = "Select * from user_sheet";
        List<User> users = null;
        try {
            users = qr.query(sql, new BeanListHandler<>(User.class));
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return users;
    }

    @Override
    public boolean login(String username, String password) {
        String sql = "select * from user_sheet where username = ? and password = ?";
        String[] params = {username, password};
        User user = null;
        try {
            user = qr.query(sql, new BeanHandler<>(User.class), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user != null;
    }

    @Override
    public User getUserByUsername(String username) {
        User u = null;
        try {
            u =  qr.query("select * from user_sheet where username = ?", new BeanHandler<>(User.class), username);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return u;
    }

    @Override
    public int addUser(User user) {
        if(getUserByUsername(user.getUsername()) != null) {
            return -1;
        }
        Object[] params = {
                user.getUsername(),
                user.getPassword(),
                user.getAge(),
                user.getPhone_number(),
                user.getAddress(),
                user.getScore()
        };
        int num = 0;
        try {
            num =  qr.update("insert into user_sheet(username, password,age, phone_number, address, score) values (?,?,?,?,?,?)", params);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return num;
    }

    @Override
    public int deleteUserById(int id) {
        User user = this.getUserById(id);
        if(user == null) {
            return -1;
        }
        String sql = "delete from user_sheet where id = ?";
        int num = 0;
        try {
            num = qr.update(sql, id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num;
    }
}
