package com.project.stusys.dao;

import com.project.stusys.model.Teachee;

import java.sql.SQLException;
import java.util.List;

public interface TeacherDao {
    List<Teachee> getAllTechs() throws SQLException;
    int addTeacher(Teachee te) throws SQLException;
    int addTeachCourses(Integer tid, String[] courses) throws SQLException;
    int updateTeacher(Teachee te) throws SQLException;
    int delCourseByTid(Integer tid) throws SQLException;

    int delTeacherByIds(String[] ids) throws SQLException;

    int delTeaCouByIds(String[] ids) throws SQLException;
}
