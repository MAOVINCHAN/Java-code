package com.learn.demo.byJava;

import com.learn.demo.byJava.config.JavaConfig;
import com.learn.demo.byJava.dao.UserDao;
import com.learn.demo.byJava.model.User;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class MainDemo {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext(JavaConfig.class);
        UserDao userDao = ctx.getBean(UserDao.class);
        int i = userDao.addUser();
        System.out.println("i = " + i); // 1 success

        User user = userDao.getUserById(1);
        System.out.println("user = " + user);

        List<User> users = userDao.getUsers();
        System.out.println("users.size() = " + users.size());

        Integer userCounts = userDao.getUserCounts();
        System.out.println("userCounts = " + userCounts);
    }
}
