package com.learn.dao;

import com.learn.entiry.GjpZhangWu;

import java.util.List;

// DAO层用于操作数据库
public interface GjpZhangWuDao {
    boolean delete(int id);
    GjpZhangWu findById(int id);
    boolean addOne(GjpZhangWu zw);
    List<GjpZhangWu> selectAll();
    List<GjpZhangWu> selectByDataRange(String startTime, String endTime);
    boolean edit(GjpZhangWu zw);
}
