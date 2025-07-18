package com.project.stusys.dao.impl;

import com.project.stusys.dao.CourseDao;
import com.project.stusys.model.Course;
import com.project.stusys.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

public class CourseDaoImpl implements CourseDao {
    private final QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
    @Override
    public List<Course> getAllCourse() throws SQLException {
        return queryRunner.query("select * from course", new BeanListHandler<>(Course.class));
    }

    @Override
    public int addCourse(String name) throws SQLException {
        return queryRunner.update("insert into course(courseName) values (?);", name);
    }

    @Override
    public int deleteByIds(int[] ids) throws SQLException {
        StringBuilder sb = new StringBuilder();
        StringBuilder params = new StringBuilder();
        for (int i = 0; i < ids.length; i++) {
            if(i == 0) {
                sb.append("(");
            }
            sb.append("?");
            params.append(ids[i]);

            if(i != ids.length - 1) {
                sb.append(",");
                params.append(",");
            }else  {
                sb.append(")");
            }
        }
        String sql = "delete from course where cid in" + sb.toString();
        return queryRunner.update(sql,params.toString());
    }
}
