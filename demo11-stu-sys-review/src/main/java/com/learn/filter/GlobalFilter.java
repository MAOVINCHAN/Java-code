package com.learn.filter;

import com.learn.Utils.Constants;
import com.learn.Utils.TokenUtils;
import com.learn.model.User;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

// @WebFilter(urlPatterns = "/*")
// public class GlobalFilter implements Filter {
//     @Override
//     public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
//         HttpServletRequest req = (HttpServletRequest) servletRequest;
//         HttpServletResponse resp = (HttpServletResponse) servletResponse;
//
//         resp.setContentType("application/json;charset=utf-8");

        // String uri = req.getRequestURI();
        // if(uri.contains("/static/") || uri.equals("/login")) {
        //     filterChain.doFilter(servletRequest, servletResponse);
        //     return;
        // }
        //
        // HttpSession session = req.getSession();
        // User user = (User) session.getAttribute(Constants.LOGIN_USER);
        // if(user == null) {
        //     resp.sendRedirect("/login");
        //     return;
        // }
        //
        // String username = user.getUsername();
        // String token = "";
        // Cookie[] cookies = req.getCookies();
        // for (Cookie cookie :
        //         cookies) {
        //     String name = cookie.getName();
        //     if(name.equals(Constants.LOGIN_COOKIE_NAME)) {
        //         token = cookie.getValue();
        //     }
        // }
        //
        // if(token == null || token.equals("")) {
        //     resp.sendRedirect("/login");
        //     return;
        // }
        //
        // Boolean validate = null;
        // try {
        //     validate = TokenUtils.validateToken(token, username);
        // } catch (Exception e) {
        //     validate = false;
        // }
        // if(!validate) {
        //     resp.sendRedirect("/login");
        //     return;
        // }

//         filterChain.doFilter(servletRequest, servletResponse);
//     }
// }
