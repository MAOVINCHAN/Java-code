package com.project.stusys.service.impl;

import com.project.stusys.dao.CourseDao;
import com.project.stusys.dao.impl.CourseDaoImpl;
import com.project.stusys.model.Course;
import com.project.stusys.service.CourseService;

import java.sql.SQLException;
import java.util.List;

public class CourseServiceImpl implements CourseService {
    private CourseDao courseDao = new CourseDaoImpl();
    @Override
    public List<Course> getAllCourse() {
        try {
            return courseDao.getAllCourse();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int addCourse(String name) {
        try {
            return courseDao.addCourse(name);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int deleteByIds(int[] ids) {
        try {
            return courseDao.deleteByIds(ids);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
