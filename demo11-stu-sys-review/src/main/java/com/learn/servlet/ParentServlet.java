package com.learn.servlet;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServlet;

import java.io.IOException;
import java.io.PrintWriter;

public class ParentServlet extends HttpServlet {
    protected String action;
    protected ObjectMapper om = new ObjectMapper();
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        action = req.getParameter("action");
        super.service(req, res);
    }
}
