package com.project.stusys.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
// import com.project.stusys.model.GradeCourse;
import com.project.stusys.model.Grade;
// import com.project.stusys.model.Pagination;
import com.project.stusys.model.RespBean;
import com.project.stusys.service.GradeService;
import com.project.stusys.service.impl.GradeServiceImpl;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletInputStream;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
// import org.apache.commons.fileupload.FileItem;
// import org.apache.commons.fileupload.FileUploadException;
// import org.apache.commons.fileupload.RequestContext;
// import org.apache.commons.fileupload.disk.DiskFileItemFactory;
// import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

@WebServlet(urlPatterns = "/grade")
public class GradeServlet extends HttpServlet {
    private GradeService gradeService = new GradeServiceImpl();
    private ObjectMapper om = new ObjectMapper();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        PrintWriter out = resp.getWriter();

        if ("page".equals(action)) {
            req.getRequestDispatcher("/WEB-INF/jsp/grade/gradeList.jsp").forward(req, resp);
            return;
        }

        if ("data".equals(action)) {
            String page = req.getParameter("page");
            String limit = req.getParameter("rows");
            String sort = req.getParameter("sort");
            String order = req.getParameter("order");
            // Pagination pagination = new Pagination(Integer.parseInt(page), Integer.parseInt(limit), sort, order);

            // 将course一一返回
            // List<GradeCourse> allGradeAndCourses = gradeService.getGradeAndCourse(pagination);
            // out.write(om.writeValueAsString(allGradeAndCourses == null ? "" : allGradeAndCourses));

            // 将course放到数组返回
            List<Grade> list = gradeService.getAllGrades();
            out.write(om.writeValueAsString(list));
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String action = req.getParameter("action");
        PrintWriter out = resp.getWriter();

        if("delete".equals(action)) {
            String[] ids = req.getParameterValues("ids[]");
            int num = gradeService.delRowsByIds(ids);

            RespBean respBean = null;
            if(num == -1) {
                respBean = RespBean.error("删除失败");
            }else {
                respBean = RespBean.success("删除成功", num);
            }
            String res = om.writeValueAsString(respBean);
            out.write(res);
            return;
        }
        String gradeName = req.getParameter("gradeName");
        String[] cids = req.getParameterValues("cids");
        System.out.println("gradeName = " + gradeName);
        System.out.println("cids = " + Arrays.toString(cids));

        int num = gradeService.addGradeCourse(gradeName, cids);
        RespBean respBean = null;
        if (num == -1) {
            respBean = RespBean.error("添加grade失败，grade已存在");
        } else if (num == 0) {
            respBean = RespBean.error("添加grade失败");
        } else {
            respBean = RespBean.success("添加成功");
        }
        out.write(om.writeValueAsString(respBean));
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // req.setCharacterEncoding("UTF-8");
        System.out.println("req.getContentType() = " + req.getContentType());

        // 接收multipart/form-data参数
        // RequestContext requestContext = new RequestContext() {
        //     @Override
        //     public String getCharacterEncoding() {
        //         return req.getCharacterEncoding();
        //     }
        //     @Override
        //     public String getContentType() {
        //         return req.getContentType();
        //     }
        //     @Override
        //     public int getContentLength() {
        //         return req.getContentLength();
        //     }
        //     @Override
        //     public InputStream getInputStream() throws IOException {
        //         return req.getInputStream();
        //     }
        // };
        // try {
        //     ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
        //     System.out.println("servletFileUpload.toString() = " + servletFileUpload.toString());
        //     List<FileItem> fileItems = servletFileUpload.parseRequest(requestContext);
        //     System.out.println("fileItems.toString() = " + fileItems.toString());
        //
        //     for (FileItem item :
        //             fileItems) {
        //         // 处理字段
        //         if(item.isFormField()) {
        //             String name = item.getFieldName();
        //             String value = item.getString();
        //             System.out.println("name = " + name);
        //             System.out.println("value = " + value);
        //         }
        //     }
        // } catch (FileUploadException e) {
        //     e.printStackTrace();
        // }
    }
}


