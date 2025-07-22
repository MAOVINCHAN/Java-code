package com.learn.demo;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

public class HelloController implements Controller {
    @Override
    public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("hello"); // 这里配置/WEB-INF/jsp下的文件名，不加后缀方便后期更换视图
        mv.addObject("message", "hello spring mvc!"); // 这里相当于servlet的request.setAttribute()
        return mv;
    }
}
