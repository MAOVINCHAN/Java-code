package com.learn.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.model.RespBean;
import com.learn.model.UploadFile;
import com.learn.service.FileService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.io.*;
import java.util.UUID;

@WebServlet(urlPatterns = "/file")
@MultipartConfig(
    maxFileSize = 10 * 1024 * 1024,
    maxRequestSize = 50 * 1024 * 1024
)
public class FileServlet extends HttpServlet {
    private String UPLOAD_BASE_DIR;
    private String BASE_URL = "http://localhost:8080/file?name=";
    private FileService fileService = new FileService();
    @Override
    public void init() throws ServletException {
        // 从系统环境变量获取上传目录（优先）
        UPLOAD_BASE_DIR = System.getenv("UPLOAD_DIR");

        if (UPLOAD_BASE_DIR == null) {
            // 默认开发目录（独立于项目）
            UPLOAD_BASE_DIR = System.getProperty("user.home") + "\\app_uploads";
            System.out.println("UPLOAD_BASE_DIR = " + UPLOAD_BASE_DIR);
        }
        new File(UPLOAD_BASE_DIR).mkdirs(); // 确保目录存在
    }

    private String getFileName(Part part) {
        String contentDisp = part.getHeader("content-disposition");
        for (String token : contentDisp.split(";")) {
            if (token.trim().startsWith("filename")) {
                return token.substring(token.indexOf('=') + 1)
                        .trim().replace("\"", "");
            }
        }
        return "unknown";
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String contentType = req.getContentType();
        System.out.println("contentType = " + contentType);

        Part filePart = req.getPart("file");
        if(filePart == null || filePart.getSize() == 0) {
            System.out.println("没有接收到有效文件");
            return;
        }
        String originalName = getFileName(filePart);
        String fileExt = originalName.contains(".") ? originalName.substring(
                originalName.lastIndexOf(".")
        ): "";
        String storedName = UUID.randomUUID() + fileExt;

        // 保存文件
        File storeFile = new File(UPLOAD_BASE_DIR, storedName);
        try (InputStream in = filePart.getInputStream();
             OutputStream outStream = new FileOutputStream(storeFile)) {
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = in.read(buffer)) != -1) {
                outStream.write(buffer, 0, bytesRead);
            }
        }

        long size = filePart.getSize();
        UploadFile fileObj = new UploadFile(
        originalName,
        storedName,
        filePart.getContentType(),
        Long.valueOf(size).intValue(),
        storeFile.getAbsolutePath(),
        BASE_URL + storedName
        );

        RespBean respBean = fileService.uploadFileInfo(fileObj);
        ObjectMapper om = new ObjectMapper();
        PrintWriter out = resp.getWriter();
        out.write(om.writeValueAsString(respBean));
    }

    // @Override
    // protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //     JakartaServletDiskFileUpload upload = new JakartaServletDiskFileUpload();
    //     upload.setFileSizeMax(10 * 1024 * 1024); // 限制10M
    //
    //     List<DiskFileItem> items = upload.parseRequest(request);
    //     int length = items.size();
    //     System.out.println("length = " + length);
    //     for (DiskFileItem item:
    //             items ) {
    //         if(!item.isFormField() && item.getSize() > 0) {
    //             String originalName = new File(item.getName()).getName();
    //             String fileExt = originalName.substring(originalName.lastIndexOf("."));
    //             String storedName = UUID.randomUUID() + fileExt;
    //
    //             // 保存文件到专门目录
    //             File storeFile = new File(UPLOAD_BASE_DIR, storedName);
    //             // item.write(storeFile.toPath());
    //             try (InputStream fileContent = item.getInputStream();
    //                  OutputStream out = new FileOutputStream(storeFile)) {
    //                 byte[] buffer = new byte[4096];
    //                 int bytesRead;
    //                 while ((bytesRead = fileContent.read(buffer)) != -1) {
    //                     out.write(buffer, 0, bytesRead);
    //                 }
    //             }
    //
    //             // 保存元数据到数据库
    //             long size = item.getSize();
    //             UploadFile fileObj = new UploadFile(
    //                     originalName,
    //                     storedName,
    //                     item.getContentType(),
    //                     Long.valueOf(size).intValue(),
    //                     storeFile.getAbsolutePath(),
    //                     BASE_URL + storedName
    //             );
    //             System.out.println("fileObj = " + fileObj);
    //
    //             RespBean respBean = fileService.uploadFileInfo(fileObj);
    //             ObjectMapper om = new ObjectMapper();
    //             PrintWriter out = response.getWriter();
    //             out.write(om.writeValueAsString(respBean));
    //         }else {
    //             System.out.println("没有接收到有效文件");
    //         }
    //     }
    // }
}
