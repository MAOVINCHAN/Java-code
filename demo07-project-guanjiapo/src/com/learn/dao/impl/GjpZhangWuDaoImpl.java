package com.learn.dao.impl;

import com.learn.dao.GjpZhangWuDao;
import com.learn.entiry.GjpZhangWu;
import org.apache.commons.dbcp.BasicDataSourceFactory;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

public class GjpZhangWuDaoImpl implements GjpZhangWuDao {
    private DataSource ds = null;
    private QueryRunner qr = null;

    {
        Properties pro = new Properties();
        try {
            pro.load(new FileInputStream("dbcp-config.properties"));
            ds = BasicDataSourceFactory.createDataSource(pro);
            qr = new QueryRunner(ds);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean delete(int id) {
        int num = 0;
        try {
            String sql = "delete from gjp_zhangwu where zwid = ?";
            num = qr.update(sql, id);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return num != 0;
    }

    @Override
    public GjpZhangWu findById(int id) {
        GjpZhangWu zw = null;
        try {
            String sql = "select * from gjp_zhangwu where zwid = ?";
            zw = qr.query(sql, new BeanHandler<>(GjpZhangWu.class), id);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return zw;
    }

    @Override
    public boolean addOne(GjpZhangWu zw) {
        String sql = "insert into gjp_zhangwu(flname, money, zhangHu, createtime, description) values(?,?,?,?,?)";
        Object[] params = {zw.getFlname(), zw.getMoney(),zw.getZhangHu(), zw.getCreatetime(), zw.getDescription()};
        int nums = 0;
        try {
            nums = qr.update(sql, params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nums != 0;
    }

    @Override
    public List<GjpZhangWu> selectAll() {
        String sql = "select * from gjp_zhangwu";
        try {
            return qr.query(sql, new BeanListHandler<>(GjpZhangWu.class));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public List<GjpZhangWu> selectByDataRange(String startTime, String endTime) {
        List<GjpZhangWu> list = null;
        try {
            String sql = "select * from gjp_zhangwu where createtime > ? and createtime < ?";
            String[] params = {startTime, endTime};
            list = qr.query(sql, new BeanListHandler<>(GjpZhangWu.class), params);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return list;
    }

    @Override
    public boolean edit(GjpZhangWu zw) {
        String sql = "update gjp_zhangwu set flname = ?, money = ?, zhangHu = ?, createtime = ?, description = ? where zwid = ?";
        Object[] params = {zw.getFlname(), zw.getMoney(), zw.getZhangHu(), zw.getCreatetime(),zw.getDescription(), zw.getZwid()};
        int num = 0;
        try {
            num = qr.update(sql, params);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return num != 0;
    }
}
