package com.learn.demo.service;

import com.learn.demo.dao.UserDao;
import com.learn.demo.model.User;

import java.util.List;

public class UserService {
    private UserDao userDao = new UserDao();
    public List<User> getUsers() {
        return userDao.getUsers();
    }
}
