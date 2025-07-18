package com.project.stusys.service.impl;

import com.project.stusys.dao.TeacherDao;
import com.project.stusys.dao.impl.TeacheeDaoImpl;
import com.project.stusys.model.Teachee;
import com.project.stusys.service.TeacheService;
import com.project.stusys.utils.DbUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class TeacheeServiceImpl implements TeacheService {
    private final TeacherDao teacherDao = new TeacheeDaoImpl();

    @Override
    public int delTeacherByIds(String[] ids) {
        Connection connection = DbUtils.getConnection();
        try {
            connection.setAutoCommit(false);
            // 先删除teacher
            int num1 = teacherDao.delTeacherByIds(ids);
            // 再删除teacher_course
            int num2 = teacherDao.delTeaCouByIds(ids);
            if(num1 == ids.length && num2 > 0) {
                connection.commit();
                return num1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int chgTeacherAndCourse(Teachee te, String[] courses) {
        Connection connection = DbUtils.getConnection();
        try {
            connection.setAutoCommit(false);
            // 修改teacher
            int num1 = teacherDao.updateTeacher(te);
            // 修改course
            teacherDao.delCourseByTid(te.getTid());// 先删除tid对应的course
            System.out.println("courses.length = " + Arrays.toString(courses) + "------" + courses.length);
            int num3 = 0;
            if(courses.length != 0) {
                num3 = teacherDao.addTeachCourses(te.getTid(), courses); // 再新增course
            }
            System.out.println("courses.length = " + courses.length);
            if(num1 == 1 && num3 == courses.length) {
                connection.commit();
                return 1;
            }
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int addTeacherAndCourse(Teachee te, String[] courses) {
        // 添加te，然后主键回填拿到id
        // 拿到id后添加courses
        Connection connection = DbUtils.getConnection();
        try {
            connection.setAutoCommit(false);
            int num1 = teacherDao.addTeacher(te);
            System.out.println("num1 = " + num1);

            int num2 = teacherDao.addTeachCourses(te.getTid(), courses);
            System.out.println("num2 = " + num2);

            if(num1 == 1 && num2 == courses.length) {
                connection.commit();
                return 1;
            }
            connection.rollback();
        } catch (SQLException e) {
            try {
                connection.rollback();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
            e.printStackTrace();
        }

        return -1;
    }

    @Override
    public List<Teachee> getAllTechs() {
        try {
            return teacherDao.getAllTechs();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
