package com.project.stusys.service;

import com.project.stusys.model.Clazz;

import java.util.List;

public interface ClazzService {
    List<Clazz> getClazzList();

    List<Clazz> getClazzListByGid(String gradeid);

    int delClazzById(String cid);

    int addClass(String className, String gradeid);
}
