package com.learn.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserServlet {
    @Autowired // 不推荐是因为：UserServlet手动new出实例时，并不会提示userService未赋值，运行会包空指针异常，而构造函数则会提示userService未赋值
    private UserService userService;

    // public UserServlet() {
    // }

    /**
     * 当没有无参构造时：这里会自动扫描spring容器是否包含userDao
     * 当有多个构造时：给构造方法（所有参数都会扫描）/构造方法的参数（扫描指定参数）添加@Autowired会扫描spring容器，否则会报空指针异常
     */
    // @Autowired
    // public UserServlet(UserService userService) {
    //     this.userService = userService;
    // }

    public User getUserByUsername(String username) {
        return userService.getUserByUsername(username);
    }
}
