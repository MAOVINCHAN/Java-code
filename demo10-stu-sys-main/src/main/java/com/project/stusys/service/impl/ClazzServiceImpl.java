package com.project.stusys.service.impl;

import com.project.stusys.dao.ClazzDao;
import com.project.stusys.dao.impl.ClazzDaoImpl;
import com.project.stusys.model.Clazz;
import com.project.stusys.service.ClazzService;

import java.sql.SQLException;
import java.util.List;

public class ClazzServiceImpl implements ClazzService {
    private ClazzDao clazzDao = new ClazzDaoImpl();

    @Override
    public int addClass(String className, String gradeid) {
        try {
            return clazzDao.addClass(className, gradeid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public int delClazzById(String cid) {
        try {
            return clazzDao.delClazzById(cid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }

    @Override
    public List<Clazz> getClazzList() {
        try {
            return clazzDao.getClazzList();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Clazz> getClazzListByGid(String gradeid) {
        try {
            return clazzDao.getClazzListByGid(gradeid);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
