package com.instance.stusys.servlet;

import com.instance.stusys.model.Pagination;
import com.instance.stusys.model.User;
import com.instance.stusys.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/users")
public class UsersServlet extends HttpServlet {
    UserService us = new UserService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 直接获取全部数据的形式
        // List<User> users = us.getUsers();
        // req.setAttribute("users", users);

        // 实现删除功能
        String action = req.getParameter("action");
        String id = req.getParameter("user_id");

        if("edit".equals(action)) {
            User user = us.getUserById(id);
            req.setAttribute("old_user", user);
            req.getRequestDispatcher("/WEB-INF/jsp/user-edit.jsp").forward(req, resp);
            return;
        }

        if("delete".equals(action)) {
            us.deleteUserById(id);
        }

        // 实现分页功能获取数据
        String page = req.getParameter("page");
        String limit = req.getParameter("limit");
        if(page == null) page = "1";
        if(limit == null) limit = "10";
        Pagination pagination = us.getPagination(Integer.valueOf(page), Integer.valueOf(limit));
        req.setAttribute("pagination", pagination);
        // jsp放到/WEB-INF/jsp下是为了防止用户通过浏览器地址栏直接访问
        req.getRequestDispatcher("/WEB-INF/jsp/user-list.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String page = req.getParameter("page");
        String size = req.getParameter("size");
        String userId = req.getParameter("user_id");
        String realName = req.getParameter("real_name");
        String password = req.getParameter("password");
        String email = req.getParameter("email");
        String phone = req.getParameter("phone");
        User user = new User();
        user.setUser_id(Integer.valueOf(userId));
        user.setReal_name(realName);
        user.setPassword(password);
        user.setEmail(email);
        user.setPhone(phone);
        us.updateUser(user);
        resp.sendRedirect("/stu-sys/users?page=" + page + "&size=" + size);
    }
}
