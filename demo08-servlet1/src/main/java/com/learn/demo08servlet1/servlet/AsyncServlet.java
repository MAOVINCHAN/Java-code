package com.learn.demo08servlet1.servlet;

import jakarta.servlet.AsyncContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * 异步servlet
 * 1. asyncSupported = true
 * 2. req.startAsync(req, resp)得到async上下文
 * 3. async上下文.start(runnable) 开启异步执行
 * 4. resp相应内容
 * 5. asyncContext.complete();
 */
@WebServlet(urlPatterns = "/async", asyncSupported = true)
public class AsyncServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // AsyncContext asyncContext = req.startAsync(req, resp);
        // asyncContext.setTimeout(3000); // 设置3s后超时
        // asyncContext.start(() -> {
        //     try {
        //         // 异步代码
        //         Thread.sleep(2000);
        //         resp.getWriter().write("async content");
        //         asyncContext.complete();
        //     } catch (Exception e) {
        //         e.printStackTrace();
        //     }
        // });

        AsyncContext asyncContext = req.startAsync();
        asyncContext.setTimeout(3000);
        asyncContext.start(() -> {
            // 将来都从asyncContext获取req和res
            ServletRequest request = asyncContext.getRequest();
            ServletResponse response = asyncContext.getResponse();

            String params_time = request.getParameter("time");
            int time = params_time != null ? Integer.parseInt(params_time) : 2000;

            // 异步代码
            try {
                Thread.sleep(time);
                response.setContentType("text/string;charset=utf-8");
                response.getWriter().write("异步返回的结果");
                asyncContext.complete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
