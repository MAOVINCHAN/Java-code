package com.learn.service;

import com.learn.Utils.DbUtils;
import com.learn.dao.GradeDao;
import com.learn.model.Grade;
import com.learn.model.RespBean;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class GradeService {
    private GradeDao gradeDao = new GradeDao();
    public RespBean getGradeList() {
        try {
            long total = gradeDao.getGradeListCount();
            List<Grade> gradeList = gradeDao.getGradeList();
            HashMap<String, Object> data = new HashMap<>();
            data.put("total", total);
            data.put("rows", gradeList);
            return RespBean.success("success", data);
        } catch (SQLException e) {
            return RespBean.error(e.getMessage());
        }
    }

    public RespBean delGradeClazzStudentByGid(String gid) {
        Connection connection = DbUtils.getConnection();
        if(connection == null) {
            return RespBean.error("获取连接池失败");
        }

        try {
            connection.setAutoCommit(false);
            gradeDao.delGradeCourseByGid(gid);
            gradeDao.delClazzByGid(gid);
            gradeDao.delStudentByGid(gid);
            gradeDao.delGradeByGid(gid);
            connection.commit();
            return RespBean.success("删除成功");
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            return RespBean.error(e.getMessage());
        }
    }
}
