package com.learn.demo.service;

import com.learn.demo.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    UserDao userDao;
    @Transactional // 需要使用事务的方法添加次注解即可，也可给类添加，表示类内所有方法都需要用到事务
    public void transferMoney(String from, String to, Double money) {
        userDao.min(from, money);
        userDao.add(to, money);
    }
}
