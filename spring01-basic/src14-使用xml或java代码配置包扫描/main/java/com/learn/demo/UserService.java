package com.learn.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired // 不推荐是因为：UserService手动new出实例时，并不会提示userDao未赋值，运行会包空指针异常，而构造函数则会提示userDao未赋值
    private UserDao userDao;

    // public UserService() {
    // }

    /**
     * 当没有无参构造时：这里会自动扫描spring容器是否包含userDao
     * 当有多个构造时：给构造方法（所有参数都会扫描）/构造方法的参数（扫描指定参数？）添加@Autowired会扫描spring容器，否则会报空指针异常
     */
    // @Autowired
    // public UserService(UserDao userDao) {
    //     this.userDao = userDao;
    // }

    public User getUserByUsername(String username) {
        return userDao.getUserByUsername(username);
    }
}
