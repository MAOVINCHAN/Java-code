package com.learn.demo.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.demo.model.User;
import com.learn.demo.service.UserService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet(urlPatterns = "/users")
public class UserServlet extends HttpServlet {
    private UserService userService = new UserService();
    private ObjectMapper om = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<User> users = userService.getUsers();
        String json = om.writeValueAsString(users);
        resp.getWriter().write(json);
    }
}
