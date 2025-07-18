package com.learn.dao;

import com.learn.Utils.DbUtils;
import com.learn.model.Course;
import com.learn.model.Grade;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class GradeDao {
    private QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());
    public List<Grade> getGradeList() throws SQLException {
        return queryRunner.query(
                "SELECT g.*,c.* FROM grade g LEFT JOIN grade_course gc ON gc.gid = g.gid LEFT JOIN course c ON c.cid = gc.cid;",
                (ResultSetHandler<List<Grade>>) resultSet -> {
                    ArrayList<Grade> list = new ArrayList<>();
                    int last_gid = -1;
                    Grade grade = null;
                    while (resultSet.next()) {
                        int cid = resultSet.getInt("cid");
                        String courseName = resultSet.getString("courseName");
                        Course course = new Course(cid, courseName);
                        int gid = resultSet.getInt("gid");

                        if(gid == last_gid) {
                            grade.getCourseList().add(course);
                        }else {
                            String gradeName = resultSet.getString("gradeName");
                            grade = new Grade(gid, gradeName);

                            ArrayList<Course> courses = new ArrayList<>();
                            courses.add(course);
                            grade.setCourseList(courses);

                            list.add(grade);
                        }
                        last_gid = gid;
                    }
                    return list;
                }
        );
    }

    public long getGradeListCount() throws SQLException {
        return queryRunner.query("select count(*) from grade", new ScalarHandler<>());
    }

    public int delGradeCourseByGid(String gid) throws SQLException {
        return queryRunner.update("delete from grade_course where gid=?", gid);
    }

    public int delClazzByGid(String gid) throws SQLException {
        return queryRunner.update("delete from clazz where gid=?", gid);
    }

    public int delStudentByGid(String gid) throws SQLException {
        return queryRunner.update("delete from student where gid=?", gid);
    }

    public int delGradeByGid(String gid) throws SQLException {
        return queryRunner.update("delete from grade where gid=?", gid);
    }
}
