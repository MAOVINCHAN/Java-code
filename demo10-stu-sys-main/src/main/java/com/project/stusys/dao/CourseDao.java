package com.project.stusys.dao;

import com.project.stusys.model.Course;

import java.sql.SQLException;
import java.util.List;

public interface CourseDao {
    List<Course> getAllCourse() throws SQLException;

    int addCourse(String name) throws SQLException;

    int deleteByIds(int[] ids) throws SQLException;
}
