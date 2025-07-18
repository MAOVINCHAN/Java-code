package com.instance.stusys.filter;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

// @WebFilter(urlPatterns = "/*")
// public class SessionFilter implements Filter {
//     @Override
//     public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//         HttpServletRequest req =  (HttpServletRequest) servletRequest;
//         HttpServletResponse resp = (HttpServletResponse) servletResponse;
//         HttpSession session = req.getSession();
//         Object user = session.getAttribute("user");
//         String reqUrl = req.getRequestURL().toString();
//         if(reqUrl.contains("/login") || reqUrl.contains("/register")) {
//             filterChain.doFilter(servletRequest, servletResponse);
//             return;
//         }
//         if(user == null) {
//             resp.sendRedirect("/stu-sys/pages/login.jsp");
//             return;
//         }
//         filterChain.doFilter(servletRequest, servletResponse);
//     }
// }
