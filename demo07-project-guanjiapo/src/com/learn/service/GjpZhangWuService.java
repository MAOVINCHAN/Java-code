package com.learn.service;

import com.learn.entiry.GjpZhangWu;

import java.util.List;

public interface GjpZhangWuService {
    boolean delete(int id);
    GjpZhangWu findById(int id);
    boolean addOne(GjpZhangWu zw);
    List<GjpZhangWu> selectAll();

    List<GjpZhangWu> selectByDataRange(String startTime, String endTime);
    boolean edit(GjpZhangWu zw);
}
