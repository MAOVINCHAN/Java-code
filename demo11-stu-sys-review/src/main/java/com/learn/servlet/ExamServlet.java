package com.learn.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(urlPatterns = "/exam")
public class ExamServlet extends ParentServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if("page".equals(action)) {
            req.getRequestDispatcher("/WEB-INF/jsp/exam/examList.jsp").forward(req, resp);
            return;
        }
    }
}
