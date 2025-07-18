package com.project.stusys.dao;

import com.project.stusys.model.Grade;
// import com.project.stusys.model.GradeCourse;
// import com.project.stusys.model.Pagination;
import java.sql.SQLException;
import java.util.List;

public interface GradeDao {
    List<Grade> getAllGrade() throws SQLException;

    Grade findGradeByName(String gradeName) throws SQLException;

    int addGrade(Grade grade) throws SQLException;

    int addGradeAndCourse(Integer gid, String[] cids) throws SQLException;

    // List<GradeCourse> getGradeAndCourse(Pagination pagination) throws SQLException;
    List<Grade> getAllGrades() throws SQLException;

    int delGradesByIds(String[] ids) throws SQLException;

    int delGradeCoursesByIds(String[] ids) throws SQLException;
}
