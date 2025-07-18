package com.project.stusys.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.stusys.model.Course;
import com.project.stusys.model.RespBean;
import com.project.stusys.service.CourseService;
import com.project.stusys.service.impl.CourseServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

@WebServlet(urlPatterns = "/course")
public class CourseServlet extends HttpServlet {
    private CourseService courseService = new CourseServiceImpl();
    private ObjectMapper om = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if("page".equals(action)) {
            req.getRequestDispatcher("/WEB-INF/jsp/course/courseList.jsp").forward(req, resp);
            return;
        }

        List<Course> data = courseService.getAllCourse();
        String s = om.writeValueAsString(data);
        PrintWriter out = resp.getWriter();
        out.write(s);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        PrintWriter out = resp.getWriter();

        if("add".equals(action)) {
            String name = req.getParameter("name");
            int num = courseService.addCourse(name);
            if(num == 0) {
                out.write(om.writeValueAsString(RespBean.error("添加失败")));
                return;
            }
            out.write(om.writeValueAsString(RespBean.success("添加成功")));
            return;
        }

        if("delete".equals(action)) {
            req.setCharacterEncoding("UTF-8");
            StringBuilder jsonBuffer = new StringBuilder();
            try (BufferedReader reader = req.getReader()) {
                String line;
                while ((line = reader.readLine()) != null) {
                    jsonBuffer.append(line);
                }
            }
            DeleteIds deleteIds = om.readValue(jsonBuffer.toString(), DeleteIds.class);
            int num = courseService.deleteByIds(deleteIds.getIds());
            if(num > 0) {
                out.write(om.writeValueAsString(RespBean.success("删除成功，共删除" + num + "条数据")));
            }else {
                out.write(om.writeValueAsString(RespBean.success("删除失败")));
            }
        }
    }
}

class DeleteIds{
    private int[] ids;

    public int[] getIds() {
        return ids;
    }

    public void setIds(int[] ids) {
        this.ids = ids;
    }

    @Override
    public String toString() {
        return "DeleteIds{" +
                "ids=" + Arrays.toString(ids) +
                '}';
    }
}