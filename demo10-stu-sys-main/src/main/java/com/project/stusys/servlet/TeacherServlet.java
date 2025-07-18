package com.project.stusys.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.stusys.model.RespBean;
import com.project.stusys.model.Teachee;
import com.project.stusys.service.TeacheService;
import com.project.stusys.service.impl.TeacheeServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/teacher")
public class TeacherServlet extends HttpServlet {
    private final TeacheService teacheService = new TeacheeServiceImpl();
    private final ObjectMapper om = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if("page".equals(action)) {
            req.getRequestDispatcher("/WEB-INF/jsp/teacher/teacherList.jsp").forward(req, resp);
            return;
        }

        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json;charset=UTF-8");

        if("data".equals(action)) {
            List<Teachee> list = teacheService.getAllTechs();
            if(list == null) {
                out.write(om.writeValueAsString(new ArrayList<>()));
                return;
            }

            out.write(om.writeValueAsString(list));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        PrintWriter out = resp.getWriter();
        resp.setContentType("application/json;charset=UTF-8");
        RespBean respBean = null;

        if("delete".equals(action)) {
            String[] ids = req.getParameterValues("ids[]");
            System.out.println("ids = " + Arrays.toString(ids));
            int num = teacheService.delTeacherByIds(ids);
            if(num == ids.length) {
                respBean = RespBean.success("删除成功");
            }else {
                respBean = RespBean.error("删除失败");
            }
            out.write(om.writeValueAsString(respBean));
            return;
        }

        String number = req.getParameter("number");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String qq = req.getParameter("qq");
        String[] courses = req.getParameterValues("course[]");
        Teachee te = new Teachee();
        te.setNumber(number);
        te.setName(name);
        te.setGender(gender);
        te.setPhone(phone);
        te.setQq(qq);

        if(courses == null) courses = new String[]{};

        if("edit".equals(action)) {
            String tid = req.getParameter("tid");
            te.setTid(Integer.parseInt(tid));

            int num = teacheService.chgTeacherAndCourse(te, courses);
            if(num != 1) {
                respBean = RespBean.error("修改失败");
            }else {
                respBean = RespBean.success("修改成功");
            }
            out.write(om.writeValueAsString(respBean));
            return;
        }

        if("add".equals(action)) {
            int num = teacheService.addTeacherAndCourse(te, courses);
            if(num != 1) {
                respBean = RespBean.error("添加失败");
            }else {
                respBean = RespBean.success("添加成功");
            }
            out.write(om.writeValueAsString(respBean));
        }
    }
}

class Params {
    private int[] tids;

    public int[] getTids() {
        return tids;
    }

    public void setTids(int[] tids) {
        this.tids = tids;
    }

    @Override
    public String toString() {
        return "Params{" +
                "tids=" + Arrays.toString(tids) +
                '}';
    }
}
