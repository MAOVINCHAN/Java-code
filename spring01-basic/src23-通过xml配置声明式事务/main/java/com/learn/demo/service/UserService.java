package com.learn.demo.service;

import com.learn.demo.dao.UserDao;

public class UserService {
    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    // 这里只用实现业务代码即可，无其他代码侵入
    public void transferMoney(String from, String to, Double money) {
        userDao.min(from, money);
        userDao.add(to, money);
    }
}
