package com.learn.demo.service;

import com.learn.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    UserDao userDao;

    @Transactional
    public void transferMoney1(String from, String to, Double money) {
        userDao.min(from, money);
        // int i = 5 / 0;
        userDao.add(to, money);
    }
}
