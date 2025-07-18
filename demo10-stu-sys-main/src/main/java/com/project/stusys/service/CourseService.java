package com.project.stusys.service;

import com.project.stusys.model.Course;

import java.util.List;

public interface CourseService {
    List<Course> getAllCourse();

    int addCourse(String name);

    int deleteByIds(int[] ids);
}
