package com.project.stusys.dao;

import com.project.stusys.model.Clazz;

import java.sql.SQLException;
import java.util.List;

public interface ClazzDao {
    List<Clazz> getClazzList() throws SQLException;

    List<Clazz> getClazzListByGid(String gradeid) throws SQLException;

    int delClazzById(String cid) throws SQLException;

    int addClass(String className, String gradeid) throws SQLException;
}
