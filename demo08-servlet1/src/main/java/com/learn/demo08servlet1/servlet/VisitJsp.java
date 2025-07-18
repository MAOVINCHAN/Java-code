package com.learn.demo08servlet1.servlet;

import com.learn.demo08servlet1.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/visit-jsp")
public class VisitJsp extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 要传递的数据，放到req身上
        User user = new User();
        user.setUsername("Tom");
        user.setAge(18);
        req.setAttribute("user", user);

        // 服务端跳转到jsp页面
        req.getRequestDispatcher("/jsp/firstJsp.jsp").forward(req, resp);
    }
}
