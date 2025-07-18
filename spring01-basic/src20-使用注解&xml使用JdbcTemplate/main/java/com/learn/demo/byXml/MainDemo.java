package com.learn.demo.byXml;

import com.learn.demo.byJava.model.User;
import com.learn.demo.byXml.dao.UserDao;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainDemo {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("useJdbctemplateByXml.xml");
        UserDao userDao = ctx.getBean(UserDao.class);

        int num = userDao.addUser();
        System.out.println("num = " + num);

        User userById = userDao.getUserById(1);
        System.out.println("userById = " + userById);

        Integer counts = userDao.getUserCounts();
        System.out.println("counts = " + counts);

        String time = userDao.getTime();
        System.out.println("time = " + time);
    }
}
