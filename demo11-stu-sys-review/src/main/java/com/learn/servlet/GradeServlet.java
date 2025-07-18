package com.learn.servlet;

import com.learn.model.RespBean;
import com.learn.service.GradeService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/grade")
public class GradeServlet extends ParentServlet {
    private GradeService gradeService = new GradeService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if("page".equals(action)) {
            req.getRequestDispatcher("/WEB-INF/jsp/grade/gradeList.jsp").forward(req, resp);
            return;
        }

        PrintWriter out = resp.getWriter();
        if("data".equals(action)) {
            RespBean respBean =  gradeService.getGradeList();
            out.write(om.writeValueAsString(respBean));
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String gid = req.getParameter("gid");
        PrintWriter out = resp.getWriter();
        if(gid == null) {
            out.write(om.writeValueAsString(RespBean.error("gid不能为空")));
            return;
        }

        RespBean respBean = gradeService.delGradeClazzStudentByGid(gid);
        out.write(om.writeValueAsString(respBean));
    }
}
