package com.project.stusys.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.stusys.model.Clazz;
import com.project.stusys.model.Grade;
import com.project.stusys.model.RespBean;
import com.project.stusys.model.Student;
import com.project.stusys.service.StudentService;
import com.project.stusys.service.impl.StudentServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(urlPatterns = "/student")
public class StudentServlet extends HttpServlet {
    private StudentService ss = new StudentServiceImpl();
    private ObjectMapper om = new ObjectMapper();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        if("page".equals(action)) {
            req.getRequestDispatcher("/WEB-INF/jsp/student/studentList.jsp").forward(req, resp);
            return;
        }

        if("data".equals(action)) {
            PrintWriter out = resp.getWriter();
            resp.setContentType("application/json;charset=UTF-8");
            List<Student> students = ss.getStudents();
            out.write(om.writeValueAsString(students));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        PrintWriter out = resp.getWriter();
        if("delete".equals(action)) {
            String[] numbers = req.getParameterValues("numbers[]");
            int num = ss.delStudentByNums(numbers);
            if(num == numbers.length) {
                out.write(om.writeValueAsString(RespBean.success("删除成功")));
            }else {
                out.write(om.writeValueAsString(RespBean.error("删除失败")));
            }
            return;
        }

        String number = req.getParameter("number");
        String name = req.getParameter("name");
        String gender = req.getParameter("gender");
        String phone = req.getParameter("phone");
        String qq = req.getParameter("qq");
        String cid = req.getParameter("cid");
        String gid = req.getParameter("gid");
        if(cid == null || gid == null) {
            out.write(om.writeValueAsString(RespBean.error("cid / gid不能为空")));
            return;
        }

        Student student = new Student();
        student.setNumber(number);
        student.setName(name);
        student.setGender(gender);
        student.setPhone(phone);
        student.setQq(qq);
        student.setGrade(new Grade(Integer.valueOf(gid)));
        student.setClazz(new Clazz(Integer.valueOf(cid)));

        if("add".equals(action)) {
            int num = ss.addStudent(student);
            if(num == 1) {
                out.write(om.writeValueAsString(RespBean.success("添加成功")));
            }else {
                out.write(om.writeValueAsString(RespBean.error("添加失败")));
            }
            return;
        }

        if("edit".equals(action)) {
            int num = ss.chgStudent(student);
            if(num == 1) {
                out.write(om.writeValueAsString(RespBean.success("修改成功")));
            }else {
                out.write(om.writeValueAsString(RespBean.error("修改失败")));
            }
        }
    }
}
