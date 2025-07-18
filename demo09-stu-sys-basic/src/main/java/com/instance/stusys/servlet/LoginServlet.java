package com.instance.stusys.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.instance.stusys.model.RespBean;
import com.instance.stusys.model.User;
import com.instance.stusys.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    UserService userService = new UserService();
    ObjectMapper om = new ObjectMapper();
    // login
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        User user = userService.login(username, password);
        RespBean respBean = user == null ? RespBean.error("登录失败，用户名或密码错误。"): RespBean.success("登录成功", user);

        if(user != null) {
            // 登录成功,设置cookie
            String token = user.getUsername();
            Cookie cookie = new Cookie("u_token", token);
            cookie.setHttpOnly(false);
            cookie.setSecure(false);
            cookie.setMaxAge(1000 * 60 * 60);
            resp.addCookie(cookie);

            // 登录成功，设置session
            HttpSession session = req.getSession();
            session.setAttribute("user", user);
        }

        String rbs = om.writeValueAsString(respBean);
        PrintWriter out = resp.getWriter();
        out.write(rbs);
    }
}
