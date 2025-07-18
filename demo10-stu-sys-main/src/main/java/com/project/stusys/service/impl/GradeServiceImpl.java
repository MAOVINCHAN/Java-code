package com.project.stusys.service.impl;

import com.project.stusys.dao.GradeDao;
import com.project.stusys.dao.impl.GradeDaoImpl;
import com.project.stusys.model.Grade;
import com.project.stusys.service.GradeService;
import com.project.stusys.utils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GradeServiceImpl implements GradeService {
    private GradeDao gradeDao = new GradeDaoImpl();

    @Override
    public int delRowsByIds(String[] ids) {
        Connection connection = DbUtils.getConnection();
        try {
            connection.setAutoCommit(false);
            int num1 = gradeDao.delGradesByIds(ids);
            gradeDao.delGradeCoursesByIds(ids);
            if(num1 == ids.length) {
                connection.commit();
            }
            return num1;
        } catch (SQLException e) {
            e.printStackTrace();
            try {
                connection.rollback();
            } catch (SQLException ex) {
                e.printStackTrace();
            }
        }
        return -1;
    }

    @Override
    public List<Grade> getAllGrade() {
        try {
            return gradeDao.getAllGrade();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addGradeCourse(String gradeName, String[] cids) {
        // grade name不可重复
        Connection con = DbUtils.getConnection();
        try {
            Grade exit_grade = gradeDao.findGradeByName(gradeName);
            if(exit_grade != null) {
                return -1; // 名称重复
            }

            con.setAutoCommit(false); // 开启事务
            // 先添加grade
            Grade grade = new Grade();
            grade.setGradeName(gradeName);
            int num1 = gradeDao.addGrade(grade);
            // List<Integer> collect = Arrays.stream(cids).map(t -> Integer.parseInt(t)).collect(Collectors.toList());
            int num2 = gradeDao.addGradeAndCourse(grade.getGid(), cids);
            if(num1 == 1 && num2 == cids.length) {
                con.commit();
                return 1;
            }
        } catch (SQLException e) {
            try {
                con.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return 0;
    }


    // @Override
    // public List<GradeCourse> getGradeAndCourse(Pagination pagination) {
    //     try {
    //         return gradeDao.getGradeAndCourse(pagination);
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     return null;
    // }

    @Override
    public List<Grade> getAllGrades() {
        try {
            return gradeDao.getAllGrades();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
