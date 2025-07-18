package com.learn.servlet;

import com.learn.Utils.Constants;
import com.learn.Utils.LoginCode;
import com.learn.Utils.TokenUtils;
import com.learn.model.RespBean;
import com.learn.model.User;
import com.learn.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends ParentServlet {
    private UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if("code".equals(action)) {
            BufferedImage image = LoginCode.getImage();
            String text = LoginCode.getText();
            HttpSession session = req.getSession();
            session.setAttribute(Constants.LOGIN_CODE, text);
            LoginCode.output(image, resp.getOutputStream());
            return;
        }

        req.getRequestDispatcher("/WEB-INF/jsp/login/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String code = req.getParameter("code");
        HttpSession session = req.getSession();
        String login_code = (String) session.getAttribute(Constants.LOGIN_CODE);
        PrintWriter out = resp.getWriter();
        if(login_code == null) {
            out.write(om.writeValueAsString(RespBean.error("验证码不能为空")));
            return;
        }

        if(!login_code.equalsIgnoreCase(code)) {
            out.write(om.writeValueAsString(RespBean.error("验证码错误")));
            return;
        }

        String username = req.getParameter("username");
        String password = req.getParameter("password");
        if(username == null || password == null) {
            out.write(om.writeValueAsString(RespBean.error("用户名或密码不能为空")));
            return;
        }

        RespBean respBean = userService.login(username, password);
        System.out.println("respBean = " + respBean);
        User user = (User) respBean.getData();

        if(user != null) {
            session.setAttribute(Constants.LOGIN_USER, user);

            String u_name = user.getUsername();
            String u_token = TokenUtils.generateToken(u_name);
            Cookie cookie = new Cookie(Constants.LOGIN_COOKIE_NAME, u_token);
            cookie.setHttpOnly(true);
            resp.addCookie(cookie);
        }

        out.write(om.writeValueAsString(respBean));
    }
}
