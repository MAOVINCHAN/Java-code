package com.instance.stusys.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.instance.stusys.model.RespBean;
import com.instance.stusys.model.User;
import com.instance.stusys.service.UserService;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/register")
public class RegisterServlet extends HttpServlet {
    ObjectMapper om = new ObjectMapper();
    UserService userService = new UserService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // x-www-form-urlencoded 使用req.getParameter获取参数
        String realName = req.getParameter("real_name");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        User user = new User(username, realName, password, email, phone);

        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        int num = userService.addUser(user);
        if(num == -1) {
            RespBean res = RespBean.error("注册失败，用户已存在", null);
            out.write(om.writeValueAsString(res));
            return;
        }else if(num == 0) {
            RespBean res = RespBean.error("注册失败", null);
            out.write(om.writeValueAsString(res));
            return;
        }

        User userInDb = userService.findUserByUsername(user.getUsername());

        RespBean res = RespBean.success("注册成功", userInDb);
        out.write(om.writeValueAsString(res));
    }
}
