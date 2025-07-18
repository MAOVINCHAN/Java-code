package com.learn.demo08servlet1.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.demo08servlet1.model.RespBean;
import com.learn.demo08servlet1.model.User;
import com.learn.demo08servlet1.service.UserService;
import com.learn.demo08servlet1.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/user1/*")
public class User1Servlet extends HttpServlet {
    private UserService us = new UserServiceImpl();
    private ObjectMapper om = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean success = us.login(username, password);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        if(success) {
            out.write(om.writeValueAsString(RespBean.success("登录成功")));
        }else {
            out.write(om.writeValueAsString(RespBean.error("登录失败")));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        ServletInputStream is = req.getInputStream();
        User user = om.readValue(is, User.class);
        int num = us.addUser(user);
        resp.setContentType("application/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        if(num == -1) {
            out.write(om.writeValueAsString(RespBean.error("添加失败，用户名已存在")));
        }else if(num == 0) {
            out.write(om.writeValueAsString(RespBean.error("添加失败")));
        }else {
            out.write(om.writeValueAsString(RespBean.success("添加成功")));
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // req.getContextPath(); 获取上下文路径
        // http://localhost:8081/user1/10
        // req.getPathInfo() // 用来请求params参数，得到"/10"
        // 需要在urlPatterns后面加上/*
        String pathInfo = req.getPathInfo();
        System.out.println("pathInfo: " + pathInfo);
        String queryString = req.getQueryString();
        System.out.println("queryString: " + queryString);
        String contentType = req.getContentType();
        System.out.println("contentType: " + contentType);
        int id = Integer.parseInt(pathInfo.replace("/", ""));
        int num = us.deleteUserById(id);
        PrintWriter out = resp.getWriter();
        if(num == -1) {
            out.write(om.writeValueAsString(RespBean.error("删除失败，用户不存在")));
        }else if(num == 0) {
            out.write(om.writeValueAsString(RespBean.error("删除失败")));
        }else {
            out.write(om.writeValueAsString(RespBean.success("删除成功")));
        }
    }

    @Override
    protected void doHead(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println(111);
        // 要传递给jsp的数据
        req.setAttribute("key", "value");
        // 跳转到jsp页面
        req.getRequestDispatcher("/jsp/firstJsp.jsp").forward(req, resp);
    }
}
