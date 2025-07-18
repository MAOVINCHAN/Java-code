package com.project.stusys.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.stusys.model.RespBean;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/logout")
public class LogoutServlet extends HttpServlet {
    ObjectMapper om = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getSession().invalidate();
        PrintWriter out = resp.getWriter();
        out.write(om.writeValueAsString(RespBean.success("注销成功")));
    }
}
