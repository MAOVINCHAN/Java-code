package com.learn.demo.service;

import com.learn.demo.dao.UserDao;

public class UserService {
    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void transferMoney1(String from, String to, Double money) {
        userDao.min(from, money);
        int i = 5 / 0;
        userDao.add(to, money);
    }
}
