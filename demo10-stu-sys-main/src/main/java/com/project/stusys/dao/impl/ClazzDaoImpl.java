package com.project.stusys.dao.impl;

import com.project.stusys.dao.ClazzDao;
import com.project.stusys.model.Clazz;
import com.project.stusys.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class ClazzDaoImpl implements ClazzDao {
    private QueryRunner qr = new QueryRunner(DbUtils.getDataSource());
    @Override
    public List<Clazz> getClazzList() throws SQLException {
        String sql = "SELECT c.cid,c.clazzName,g.gradeName FROM clazz c LEFT JOIN grade g ON g.gid = c.gid";
        return qr.query(sql, new BeanListHandler<>(Clazz.class));
    }

    @Override
    public int delClazzById(String cid) throws SQLException {
        String sql = "delete from clazz where cid=?";
        return qr.update(sql, cid);
    }

    @Override
    public int addClass(String className, String gradeid) throws SQLException {
        String[] params = {className, gradeid};
        return qr.update("insert into clazz(clazzName, gid) values (?,?);", params);
    }

    @Override
    public List<Clazz> getClazzListByGid(String gradeid) throws SQLException {
        String sql = "SELECT c.cid,c.clazzName,g.gradeName FROM clazz c LEFT JOIN grade g ON g.gid = c.gid where c.gid = ?";
        return qr.query(sql, new BeanListHandler<>(Clazz.class), gradeid);
    }
}
