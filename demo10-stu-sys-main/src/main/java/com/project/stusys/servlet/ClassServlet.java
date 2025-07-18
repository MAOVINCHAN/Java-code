package com.project.stusys.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.stusys.model.Clazz;
import com.project.stusys.model.RespBean;
import com.project.stusys.service.ClazzService;
import com.project.stusys.service.impl.ClazzServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(urlPatterns = "/class")
public class ClassServlet extends HttpServlet {
    private ClazzService clazzService = new ClazzServiceImpl();
    private ObjectMapper om = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if("page".equals(action)) {
            req.getRequestDispatcher("/WEB-INF/jsp/class/classList.jsp").forward(req, resp);
            return;
        }

        PrintWriter out = resp.getWriter();
        if("data".equals(action)) {
            String gradeid = req.getParameter("gradeid");
            List<Clazz> list = null;
            if(gradeid != null && !gradeid.isEmpty()) {
                list = clazzService.getClazzListByGid(gradeid);
            }else {
                list = clazzService.getClazzList();
            }

            if(list == null) {
                out.write(om.writeValueAsString(new ArrayList<>()));
            }else {
                out.write(om.writeValueAsString(list));
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String className = req.getParameter("name");
        String gradeid = req.getParameter("gradeid");
        int num = clazzService.addClass(className, gradeid);
        RespBean respBean = null;
        if(num <= 0) {
            respBean = RespBean.error("添加失败");
        }else {
            respBean = RespBean.success("添加成功");
        }
        PrintWriter out = resp.getWriter();
        out.write(om.writeValueAsString(respBean));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String cid = req.getParameter("cid");
        int num = clazzService.delClazzById(cid);
        PrintWriter out = resp.getWriter();
        RespBean respBean = null;
        if(num == -1) {
            respBean = RespBean.error("删除失败");
        }else {
            respBean = RespBean.success("删除成功");
        }
        out.write(om.writeValueAsString(respBean));
    }
}
