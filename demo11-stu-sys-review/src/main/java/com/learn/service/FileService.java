package com.learn.service;

import com.learn.dao.FileDao;
import com.learn.model.RespBean;
import com.learn.model.UploadFile;

import java.sql.SQLException;

public class FileService {
    private FileDao fileDao = new FileDao();
    public RespBean uploadFileInfo(UploadFile fileObj) {
        try {
            int num = fileDao.uploadFileInfo(fileObj);
            RespBean respBean = null;
            if(num == 1) {
                respBean = RespBean.success("上传成功");
            }else {
                respBean = RespBean.error("上传失败");
            }
            return respBean;
        } catch (SQLException e) {
            return RespBean.error(e.getMessage());
        }
    }
}
