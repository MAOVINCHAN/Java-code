package com.project.stusys.filter;

import com.project.stusys.utils.Constants;
import jakarta.servlet.*;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/*")
public class PermissionFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) servletRequest;
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        resp.setContentType("application/json;charset=UTF-8");
        String uri = req.getRequestURI();
        if(uri.equals("/login") || uri.contains("/static/") || uri.equals("/logout")) {
            filterChain.doFilter(servletRequest,servletResponse);
            return;
        }

        Object user = req.getSession().getAttribute(Constants.LOGIN_USER);
        if(user == null) {
            resp.sendRedirect("/login");
            return;
        }
        System.out.println("uri = " + uri);

        filterChain.doFilter(servletRequest,servletResponse);
    }
}
