package com.learn.demo.controller;

import com.learn.demo.model.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;

/**
 * 接口的参数（指@RequestMapping标记的方法的参数）
 * 默认参数（可有可无，需要则加）：HttpServletRequest, HttpServletResponse, HttpSession, Model, ModelMap
 * 自定义参数：
 * 其实就是servlet中的req.getParameter()，req.getParameterValues()，req.getPathInfo()分别获取
 */
@Controller
public class UserController {
    @RequestMapping("/form")
    public ModelAndView showForm() {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("form-info");
        return mv;
    }

    /**
     * 这里的默认参数加上后，方法体内可以直接使用，框架会提供这些参数给使用者
     * @param req 可以指定也可以不指定，指定则框架会提供给使用者
     * @param resp 可以指定也可以不指定，指定则框架会提供给使用者
     * @param session 可以指定也可以不指定，指定则框架会提供给使用者
     * @return
     */
    @RequestMapping("/def-params")
    public ModelAndView user(HttpServletRequest req, HttpServletResponse resp, HttpSession session) {
        String username = req.getParameter("username");
        String password = req.getParameter("password");

        ModelAndView mv = new ModelAndView();
        mv.setViewName("show-info");
        mv.addObject("username", username);
        mv.addObject("password", password);
        return mv;
    }

    /**
     * 自定义参数，单个指定
     * @RequestParam("username")中的username需要和接口中的key一致
     * 作用： 1.可以用来指定别名。2. 指定的参数必传，否则不会进入方法，返回400错误，表示参数错误
     * 可以设置required=false，取消必填
     * 可以设置defaultValue=""设置默认值
     * String username 中的username可以是任意的形参
     * @param username
     * @param password
     * @param favorites 此处接收必须用数组，不能用集合
     * @return
     */
    @RequestMapping("/user")
    public ModelAndView user(
        @RequestParam("username") String username,
        @RequestParam("password") String password,
        @RequestParam("favorites") String[] favorites)
    {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("show-info");
        mv.addObject("username", username);
        mv.addObject("password", password);
        mv.addObject("favorites", Arrays.toString(favorites));
        return mv;
    }

    /**
     * 自定义参数，映射为对象
     * 参数需要和对象的属性一致，底层非json，而是通过user的setter设置值后，框架把参数user提供给参数使用者
     * @param user
     * @return
     */
    @RequestMapping("/user-obj")
    public ModelAndView user(User user) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("show-info");
        mv.addObject("username", user.getUsername());
        mv.addObject("password", user.getPassword());
        return mv;
    }

    /**
     * 自定义参数之地址栏参数：前端叫params参数，java叫path参数
     * 必须使用@PathVariable注解
     * name：指定RequestMapping路径中的参数名
     * required：指定是否必填，默认必填
     * defaultValue：指定默认参数
     * @param name
     * @param pwd
     * @return
     */
    @RequestMapping("/path/{username}/{password}")
    public ModelAndView user(@PathVariable(name = "username") String name,@PathVariable(name = "password") String pwd) {
        ModelAndView mv = new ModelAndView();
        mv.setViewName("show-info");
        mv.addObject("username", name);
        mv.addObject("password", pwd);
        return mv;
    }
}
