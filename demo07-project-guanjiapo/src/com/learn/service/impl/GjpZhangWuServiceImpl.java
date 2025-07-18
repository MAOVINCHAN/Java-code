package com.learn.service.impl;

import com.learn.dao.GjpZhangWuDao;
import com.learn.dao.impl.GjpZhangWuDaoImpl;
import com.learn.entiry.GjpZhangWu;
import com.learn.service.GjpZhangWuService;

import java.util.List;

// service调用DAO层的方法
public class GjpZhangWuServiceImpl implements GjpZhangWuService {
    GjpZhangWuDao gjpZhangWuDao = new GjpZhangWuDaoImpl();

    @Override
    public boolean delete(int id) {
        return gjpZhangWuDao.delete(id);
    }

    @Override
    public GjpZhangWu findById(int id) {
        return gjpZhangWuDao.findById(id);
    }

    @Override
    public boolean addOne(GjpZhangWu zw) {
        return gjpZhangWuDao.addOne(zw);
    }

    @Override
    public List<GjpZhangWu> selectAll() {
        return gjpZhangWuDao.selectAll();
    }

    @Override
    public List<GjpZhangWu> selectByDataRange(String startTime, String endTime) {
        return gjpZhangWuDao.selectByDataRange(startTime, endTime);
    }

    @Override
    public boolean edit(GjpZhangWu zw) {
        return gjpZhangWuDao.edit(zw);
    }
}
