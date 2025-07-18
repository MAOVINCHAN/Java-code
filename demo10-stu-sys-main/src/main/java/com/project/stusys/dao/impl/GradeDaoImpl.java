package com.project.stusys.dao.impl;

import com.project.stusys.dao.GradeDao;
import com.project.stusys.model.Course;
import com.project.stusys.model.Grade;
// import com.project.stusys.model.GradeCourse;
// import com.project.stusys.model.Pagination;
import com.project.stusys.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GradeDaoImpl implements GradeDao {
    private final QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());

    @Override
    public List<Grade> getAllGrade() throws SQLException {
        return queryRunner.query("select * from grade", new BeanListHandler<>(Grade.class));
    }

    @Override
    public Grade findGradeByName(String gradeName) throws SQLException {
        return queryRunner.query("select * from grade where gradeName = ?", new BeanHandler<>(Grade.class), gradeName);
    }

    @Override
    public int addGrade(Grade grade) throws SQLException {
        Connection connection = DbUtils.getConnection();
        PreparedStatement ps = connection.prepareStatement(
        "insert into grade(gradeName) values (?)",
        Statement.RETURN_GENERATED_KEYS);

        ps.setString(1, grade.getGradeName());
        int i = ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()) {
            int gid = rs.getInt(1);
            grade.setGid(gid);
        }
        return i;
    }

    @Override
    public int addGradeAndCourse(Integer gid, String[] cids) throws SQLException {
        Object[] params = new Object[cids.length * 2];
        StringBuffer sql = new StringBuffer("insert into grade_course(gid, cid) values");
        System.out.println("sql = " + sql);
        for (int i = 0; i < cids.length; i++) {
            sql.append("(?,?)");
            if(i != cids.length - 1) {
                sql.append(",");
            }

            int p = i * 2;
            params[p] = gid;
            params[p + 1] = cids[i];
        }
        return queryRunner.update(DbUtils.getConnection(),sql.toString(), params);
    }


    // @Override
    // public List<GradeCourse> getGradeAndCourse(Pagination pagination) throws SQLException {
    //     String sort = pagination.getSort();
    //     String order = pagination.getOrder();
    //     Integer page = pagination.getPage();
    //     Integer limit = pagination.getLimit();
    //     //language=SQL
    //     String sql = "SELECT\n" +
    //             "    m.gcid AS id" +
    //             ",\n" +
    //             "    grade.gradeName AS gradeName,\n" +
    //             "    course.courseName AS courseName\n" +
    //             "FROM\n" +
    //             "    grade_course m\n" +
    //             "JOIN\n" +
    //             "    grade ON m.gid = grade.gid\n" +
    //             "JOIN\n" +
    //             "    course ON m.cid = course.cid";
    //
    //     if(sort != null) {
    //         String o = order == null ? "ASC" : order;
    //         sql += " order by m." + sort + " " + o;
    //     }
    //
    //     if(page != null && limit != null) {
    //         sql += " limit " + (page - 1) * limit + "," + limit;
    //     }
    //
    //     return queryRunner.query(sql.toString(), new BeanListHandler<>(GradeCourse.class));
    // }


    @Override
    public List<Grade> getAllGrades() throws SQLException {
        String sql = "SELECT g.gid,g.gradeName,c.cid,c.courseName FROM grade g LEFT JOIN grade_course gc ON gc.gid=g.gid LEFT JOIN \n" +
        "course c ON c.cid = gc.cid ORDER BY g.gid;";

        return queryRunner.query(sql, new ResultSetHandler<List<Grade>>() {
            @Override
            public List<Grade> handle(ResultSet resultSet) throws SQLException {
                List<Grade> list = new ArrayList<>();

                int last_gid = -1;
                Grade grade = null;
                while (resultSet.next()) {
                    int gid = resultSet.getInt("gid");
                    String gradeName = resultSet.getString("gradeName");
                    int cid = resultSet.getInt("cid");
                    String courseName = resultSet.getString("courseName");

                    Course course = new Course();
                    course.setCid(cid);
                    course.setCourseName(courseName);

                    if(gid == last_gid) {
                        grade.getGradeCourse().add(course);
                    }else {
                        grade = new Grade(gid);
                        grade.setGid(gid);
                        grade.setGradeName(gradeName);

                        List<Course> courseList = new ArrayList<>();
                        courseList.add(course);
                        grade.setGradeCourse(courseList);

                        list.add(grade);
                    }
                    last_gid = gid;
                }

                return list;
            }
        });
    }

    private ParamsFlagObject getParamsAndFlag(String[] ids) {
        StringBuilder sb = new StringBuilder("");
        String[] params = new String[ids.length];
        for (int i = 0; i < ids.length; i++) {
            if(i == 0) {
                sb.append("(");
            }

            params[i] = ids[i];

            sb.append("?");

            if(i == ids.length - 1) {
                sb.append(")");
            }else {
                sb.append(",");
            }
        }
        ParamsFlagObject pfo = new ParamsFlagObject();
        pfo.setSql(sb.toString());
        pfo.setParams(params);
        return pfo;
    }

    @Override
    public int delGradesByIds(String[] ids) throws SQLException {
        StringBuilder sb = new StringBuilder("delete from grade where gid in");
        ParamsFlagObject pfo = getParamsAndFlag(ids);
        String flag = pfo.getSql();
        sb.append(flag);
        String sql = sb.toString();
        Object[] params = pfo.getParams();

        System.out.println("sql = " + sql);
        System.out.println("params = " + Arrays.toString(params));
        return queryRunner.update(DbUtils.getConnection(), sql, params);
    }

    @Override
    public int delGradeCoursesByIds(String[] ids) throws SQLException {
        StringBuilder sb = new StringBuilder("delete from grade_course where gid in");
        ParamsFlagObject pfo = getParamsAndFlag(ids);
        sb.append(pfo.getSql().toString());
        String sql = sb.toString();
        Object[] params = pfo.getParams();
        return queryRunner.update(DbUtils.getConnection(), sql,params);
    }
}

class ParamsFlagObject {
    private String sql;
    private Object[] params;

    public String getSql() {
        return sql;
    }

    public void setSql(String sql) {
        this.sql = sql;
    }

    public Object[] getParams() {
        return params;
    }

    public void setParams(Object[] params) {
        this.params = params;
    }
}






















