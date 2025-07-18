package com.learn.demo08servlet1.service.impl;

import com.learn.demo08servlet1.dao.UserDao;
import com.learn.demo08servlet1.dao.impl.UserDaoImpl;
import com.learn.demo08servlet1.model.User;
import com.learn.demo08servlet1.service.UserService;

import java.util.List;

public class UserServiceImpl implements UserService {
    private UserDao userDao = new UserDaoImpl();
    @Override
    public User getUserById(int id) {
        return userDao.getUserById(id);
    }

    @Override
    public List<User> getUsers() {
        return userDao.getUsers();
    }

    @Override
    public boolean login(String username, String password) {
        return userDao.login(username, password);
    }

    @Override
    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }

    @Override
    public int addUser(User user) {
        return userDao.addUser(user);
    }

    @Override
    public int deleteUserById(int id) {
        return userDao.deleteUserById(id);
    }
}
