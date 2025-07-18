package com.project.stusys.service;

import com.project.stusys.model.Grade;
// import com.project.stusys.model.GradeCourse;
// import com.project.stusys.model.Pagination;

import java.util.List;

public interface GradeService {
    List<Grade> getAllGrade();
    int addGradeCourse(String gradeName, String[] cids);

    // List<GradeCourse> getGradeAndCourse(Pagination pagination);
    List<Grade> getAllGrades();

    int delRowsByIds(String[] ids);
}
