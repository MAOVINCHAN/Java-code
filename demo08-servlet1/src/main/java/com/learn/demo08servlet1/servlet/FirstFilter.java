package com.learn.demo08servlet1.servlet;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;

import java.io.IOException;

@WebFilter(value = "/*")
public class FirstFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("do filter now");

        // 放行
        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("after do filter");
    }
}
