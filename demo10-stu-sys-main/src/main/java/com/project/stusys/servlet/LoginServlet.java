package com.project.stusys.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.stusys.model.LoginInfo;
import com.project.stusys.model.RespBean;
import com.project.stusys.model.User;
import com.project.stusys.service.UserService;
import com.project.stusys.service.impl.UserServiceImpl;
import com.project.stusys.utils.Constants;
import com.project.stusys.utils.VerificationCode;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/login")
public class LoginServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();
    private ObjectMapper om = new ObjectMapper();

    // 这里返回登录的页面
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if("code".equals(action)) {
            VerificationCode vcc = new VerificationCode();
            BufferedImage image = vcc.getImage();
            String text = vcc.getText();
            HttpSession session = req.getSession();
            session.setAttribute(Constants.LOGIN_CODE, text);
            VerificationCode.output(image, resp.getOutputStream());
            return;
        }


        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }

    // 这里执行登录的操作
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("application/json;charset=utf-8");
        // body - x-www-form-urlencoded
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String vcode = req.getParameter("vcode");

        // body - json
        // ServletInputStream is = req.getInputStream();
        // Payload payload = om.readValue(is, Payload.class);

        // 先校验验证码是否正确
        HttpSession session = req.getSession();
        String code = (String) session.getAttribute(Constants.LOGIN_CODE);

        PrintWriter out = resp.getWriter();
        RespBean respBean = null;
        if(code == null || !code.equalsIgnoreCase(vcode)) {
            respBean = RespBean.error("验证码错误，登录失败");
            out.write(om.writeValueAsString(respBean));
            return;
        }

        LoginInfo info = userService.login(username, password);
        int flag = info.getCode();
        if(flag == -1) {
            respBean = RespBean.error(info.getInfo());
        }else if(flag == 0) {
            respBean = RespBean.error(info.getInfo());
        }else {
            User user = (User) info.getData();
            respBean = RespBean.success(info.getInfo(), user);
            req.getSession().setAttribute(Constants.LOGIN_USER, user);
        }
        out.write(om.writeValueAsString(respBean));
    }
}

class Payload {
    private String username;
    private String password;
    private String vcode;
    private Integer type;

    public Payload() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Payload{" +
                "username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", vcode='" + vcode + '\'' +
                ", type=" + type +
                '}';
    }
}