package com.project.stusys.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.RequestContext;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import java.io.*;
import java.util.Arrays;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


@WebServlet(urlPatterns = "/params")
public class ParamsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收query参数 -- 测试成功
        String username = req.getParameter("username");
        System.out.println("username = " + username);
        String password = req.getParameter("password");
        System.out.println("password = " + password);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 接收application/form-data参数 -- 测试成功
        // ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
        // RequestContext context = new RequestContext() {
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
        //     List<FileItem> fileItems = servletFileUpload.parseRequest(context);
        //     for (FileItem item :
        //             fileItems) {
        //         if(item.isFormField()) { //表单字段
        //             String name = item.getFieldName();
        //             String value = item.getString();
        //             System.out.println("result: " + name + ": " + value);
        //         }else { // 二进制文件
        //             InputStream is = item.getInputStream();
        //             byte[] buf = new byte[1024 * 10];
        //             int len = is.read(buf);
        //             System.out.println("len = " + len);
        //             String name = item.getName(); // 获取文件名
        //             System.out.println("name = " + name);
        //             Files.write(Path.of("C:\\Users\\admin\\Desktop\\" + item.getName()), buf);
        //         }
        //     }
        // } catch (FileUploadException e) {
        //     e.printStackTrace();
        // }


        // 读取application/x-www-form-urlencoded参数 -- 测试成功
        String username = req.getParameter("username");
        System.out.println("username = " + username);
        String password = req.getParameter("password");
        System.out.println("password = " + password);

        // 读取application/x-www-form-urlencoded参数数组 -- 测试成功
        /**
         * 参数可以传为
         * ids:1
         * ids:2
         * ids:3
         * 或
         * ids: 1,2,3
         */
        String[] ids = req.getParameterValues("ids");
        System.out.println("ids = " + Arrays.toString(ids));
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 读取query参数 -- 获取成功
        // String username = req.getParameter("username");
        // System.out.println("username = " + username);
        // String password = req.getParameter("password");
        // System.out.println("password = " + password);

        // 读取application/x-www-form-urlencoded参数 -- 获取失败
        // String username = req.getParameter("username");
        // System.out.println("username = " + username);
        // String password = req.getParameter("password");
        // System.out.println("password = " + password);

        // 接收application/form-data参数 -- 获取成功
        // ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
        // try {
        //     List<FileItem> fileItems = servletFileUpload.parseRequest(new RequestContext() {
        //         @Override
        //         public String getCharacterEncoding() {
        //             return req.getCharacterEncoding();
        //         }
        //         @Override
        //         public String getContentType() {
        //             return req.getContentType();
        //         }
        //         @Override
        //         public int getContentLength() {
        //             return req.getContentLength();
        //         }
        //         @Override
        //         public InputStream getInputStream() throws IOException {
        //             return req.getInputStream();
        //         }
        //     });
        //     for (FileItem item :
        //             fileItems) {
        //         if (item.isFormField()) {
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

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 读取application/x-www-form-urlencoded参数 -- 获取失败
        // 读取application/form-data参数 -- 获取失败
        // String username = req.getParameter("username");
        // System.out.println("username = " + username);
        // String password = req.getParameter("password");
        // System.out.println("password = " + password);

        // 接收application/form-data参数 -- 获取成功
        // ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
        // try {
        //     List<FileItem> fileItems = servletFileUpload.parseRequest(new RequestContext() {
        //         @Override
        //         public String getCharacterEncoding() {
        //             return req.getCharacterEncoding();
        //         }
        //         @Override
        //         public String getContentType() {
        //             return req.getContentType();
        //         }
        //         @Override
        //         public int getContentLength() {
        //             return req.getContentLength();
        //         }
        //         @Override
        //         public InputStream getInputStream() throws IOException {
        //             return req.getInputStream();
        //         }
        //     });
        //     for (FileItem item :
        //             fileItems) {
        //         if (item.isFormField()) {
        //             String name = item.getFieldName();
        //             System.out.println("name = " + name);
        //             String value = item.getString();
        //             System.out.println("value = " + value);
        //         }
        //     }
        // } catch (FileUploadException e) {
        //     e.printStackTrace();
        // }

        // 读取query参数 -- 获取成功
        // String username = req.getParameter("username");
        // System.out.println("username = " + username);
        // String password = req.getParameter("password");
        // System.out.println("password = " + password);
        // String[] ids = req.getParameterValues("ids");
        // System.out.println("ids = " + Arrays.toString(ids));
    }
}
