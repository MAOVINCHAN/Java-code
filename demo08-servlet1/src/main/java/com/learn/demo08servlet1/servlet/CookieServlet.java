package com.learn.demo08servlet1.servlet;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.time.LocalDateTime;

@WebServlet(urlPatterns = "/cookie")
public class CookieServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        // 服务端写cookie
        Cookie cookie = new Cookie("username", "Tom");
        // cookie.setPath("/");
        cookie.setMaxAge(LocalDateTime.now().getSecond() * 60 * 7); // 单位为秒
        cookie.setHttpOnly(true); // 设置为true则禁止js操作cookie
        cookie.setSecure(false); // 设置为true则仅允许https传输
        resp.addCookie(cookie);// 给响应添加cookie


        // 写中文cookie
        String cn_name = URLEncoder.encode("用户名", "utf-8");
        String cn_value = URLEncoder.encode("汤姆", "utf-8");
        Cookie cn_cookie = new Cookie(cn_name, cn_value);
        resp.addCookie(cn_cookie);

        resp.setContentType("text/html;charset=utf-8");
        PrintWriter out = resp.getWriter();
        out.write("<!DOCTYPE html>\n" +
                "<html lang='en'>\n" +
                "    <he" +
                "ad>\n" +
                "        <title>Cookie</title>\n" +
                "    <he" +
                "ad>\n" +
                "<body>\n" +
                "\n" +
                "        <div>cookie page</div>\n" +
                "    </bo" +
                "</h");


        // 服务端读cookie
        Cookie[] cookies = req.getCookies();
        for (Cookie co :
                cookies) {
            if(co.getName().startsWith("%")) {
                // 读中文cookie
                String name = URLDecoder.decode(co.getName(), "utf-8");
                String value = URLDecoder.decode(co.getValue(), "utf-8");
                System.out.println(name + "=" + value);
            }else {
                System.out.println(co.getName() + "=" + co.getValue());
            }
        }
    }
}
