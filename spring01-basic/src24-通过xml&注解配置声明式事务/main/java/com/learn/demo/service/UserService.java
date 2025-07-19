package com.learn.demo.service;

import com.learn.demo.dao.UserDao;
import org.springframework.transaction.annotation.Transactional;

public class UserService {
    UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Transactional
    public void transferMoney(String from, String to, Double money) {
        userDao.min(from, money);
        userDao.add(to, money);
    }
}
