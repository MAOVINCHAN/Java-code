package com.project.stusys.service;

import com.project.stusys.model.Teachee;
import java.util.List;

public interface TeacheService {
    List<Teachee> getAllTechs() ;

    int addTeacherAndCourse(Teachee te, String[] courses);

    int chgTeacherAndCourse(Teachee te, String[] courses);

    int delTeacherByIds(String[] ids);
}
