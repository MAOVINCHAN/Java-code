package com.learn.demo08servlet1.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

@WebServlet(urlPatterns = "/session")
public class SessionServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取session对象
        // @params b: 如果为true，表示如果还没有创建session就创建一个空session，如果为false则直接返回null
        HttpSession session = req.getSession();
        String session_id = session.getId(); // 会通过cookie返回给前端
        System.out.println("session_id = " + session_id);

        // 向session写数据
        session.setAttribute("name", "zhangSan");

        // 设置session有效期，默认为30分钟
        // 每次请求后会重新续期30分钟，只有当超时30分钟没有发生请求续约，则session过期
        session.setMaxInactiveInterval(1000 * 60);

        // 向session读数据
        Object name = session.getAttribute("name");
        System.out.println("name = " + name);

        // 销毁session，此时所有session中的数据都会清空
        session.invalidate();
    }
}
