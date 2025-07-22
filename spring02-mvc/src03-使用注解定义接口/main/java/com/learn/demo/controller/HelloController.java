package com.learn.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Controller 标记当前类为一个控制器
 */
@Controller
public class HelloController {
    /**
     * @RequestMapping 标记当前方法是一个接口，url地址为 /hello
     */
    @RequestMapping("/hello")
    public ModelAndView hello() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello-page");
        mv.addObject("message", "hello page access successfully!");
        return mv;
    }
}
