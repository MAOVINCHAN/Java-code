package com.learn.demo08servlet1.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.demo08servlet1.model.User;
import com.learn.demo08servlet1.service.UserService;
import com.learn.demo08servlet1.service.impl.UserServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

/**
 * 全局所有请求共用同一个servlet实例
 * 注意定义变量不要大量定义全局变量
 * 声明周期： init -- service -- destroy
 */
@WebServlet(urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        PrintWriter out = response.getWriter();
        String id = request.getParameter("id");
        if(id == null) {
            // 查询所有
            List<User> users = userService.getUsers();
            String str = "";
            if(users == null) {
                str = "数据为空";
            }else {
                ObjectMapper om = new ObjectMapper();
                str = om.writeValueAsString(users);
            }
            response.setContentType("application/json;charset=utf-8");
            response.setHeader("a", "1");
            out.write(str);
            return;
        }
        response.setContentType("text/html");
        response.setContentType("application/json");
        response.setCharacterEncoding("utf-8");

        User user = userService.getUserById(Integer.valueOf(id));

        if(user == null) {
            out.write("数据为空");
            return;
        }
        ObjectMapper om = new ObjectMapper();
        String result = om.writeValueAsString(user);
        out.write(result);
        out.println("<html><body>");
        out.println("<table>");
        out.println("<thead>");
        out.println("<tr>");
        out.println("<td>");
        out.println("用户名");
        out.println("</td>");
        out.println("<td>");
        out.println("年龄");
        out.println("</td>");
        out.println("<td>");
        out.println("电话");
        out.println("</td>");
        out.println("<td>");
        out.println("地址");
        out.println("</td>");
        out.println("<td>");
        out.println("成绩");
        out.println("</td>");
        out.println("</tr>");
        out.println("</thead>");
        out.println("<tbody>");
        out.println("<tr>");
        out.println("<td>");
        out.println(user.getUsername());
        out.println("</td>");
        out.println("<td>");
        out.println(user.getAge());
        out.println("</td>");
        out.println("<td>");
        out.println(user.getPhone_number());
        out.println("</td>");
        out.println("<td>");
        out.println(user.getAddress());
        out.println("</td>");
        out.println("<td>");
        out.println(user.getScore());
        out.println("</td>");
        out.println("</tr>");
        out.println("</tbody>");
        out.println("</table>");
        out.println("</body></html>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        if(login != null) {
            // 测试页面跳转
            String username = req.getParameter("username");
            String password = req.getParameter("password");
            boolean success = userService.login(username, password);
            if(success) {
                resp.sendRedirect("/demo08_servlet1_war_exploded/pages/home.html");
            } else {
                resp.sendRedirect("/demo08_servlet1_war_exploded/pages/error.html");
            }
            return;
        }
        // BufferedReader reader = req.getReader();
        // String str = reader.readLine();
        // System.out.println("str: " + str); // 得到的是与"name=11&age=22"类似的字符串，处理起来比较麻烦
        // reader.close();

        // 序列化和反序列化请求体json数据
        // 反序列化json数据
        ObjectMapper om = new ObjectMapper();
        User user = om.readValue(req.getInputStream(), User.class);
        System.out.println("user: " + user);

        // 序列化
        String json = om.writerWithDefaultPrettyPrinter().writeValueAsString(user);
        System.out.println("json:" + json);
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    public void init() throws ServletException {

    }
}
