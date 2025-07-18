package com.project.stusys.dao.impl;

import com.project.stusys.dao.TeacherDao;
import com.project.stusys.model.Clazz;
import com.project.stusys.model.Course;
import com.project.stusys.model.Grade;
import com.project.stusys.model.Teachee;
import com.project.stusys.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;

import java.sql.*;
import java.util.*;

public class TeacheeDaoImpl implements TeacherDao {
    private final QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());

    @Override
    public int delTeaCouByIds(String[] ids) throws SQLException {
        StringBuilder sql = new StringBuilder("delete from teacher_course where tid in ");
        for (int i = 0; i < ids.length; i++) {
            if(i == 0) sql.append("(");
            if(i != ids.length - 1) {
                sql.append("?,");
            }else {
                sql.append("?)");
            }
        }
        System.out.println("params1 = " + Arrays.toString(ids));
        return queryRunner.update(DbUtils.getConnection(), sql.toString(), ids);
    }

    @Override
    public int delTeacherByIds(String[] ids) throws SQLException {
        StringBuilder sql = new StringBuilder("delete from teacher where tid in ");
        System.out.println("params2 = " + Arrays.toString(ids));
        for (int i = 0; i < ids.length; i++) {
            if(i == 0) sql.append("(");
            if(i != ids.length - 1) {
                sql.append("?,");
            }else {
                sql.append("?)");
            }
        }
        return queryRunner.update(DbUtils.getConnection(), sql.toString(), ids);
    }

    @Override
    public int delCourseByTid(Integer tid) throws SQLException {
        return queryRunner.update(DbUtils.getConnection(),"delete from teacher_course where tid = ?", tid);
    }

    @Override
    public int updateTeacher(Teachee te) throws SQLException {
        Object[] params = {
            te.getNumber(),
            te.getName(),
            te.getGender(),
            te.getPhone(),
            te.getQq(),
            te.getTid()
        };
        return queryRunner.update(DbUtils.getConnection(),"update teacher set number=?,name=?,gender=?,phone=?,qq=? where tid=?",params);
    }

    @Override
    public int addTeachCourses(Integer tid, String[] courses) throws SQLException {
        StringBuilder sb = new StringBuilder("insert into teacher_course(tid, gid, clazzId, courseId) values ");
        // (?,?,?,?)
        Integer[] params = new Integer[courses.length * 4];
        for (int i = 0; i < courses.length; i++) {
            sb.append("(?,?,?,?)");
            if(i != courses.length - 1) sb.append(",");
            // gradeid_clazzid_courseid
            String str = courses[i];
            String[] str2arr = str.split("_");
            String gradeId = str2arr[0];
            String clazzId = str2arr[1];
            String courseId = str2arr[2];

            int start = i * 4;
            params[start] = tid;
            params[start + 1] = Integer.parseInt(gradeId);
            params[start + 2] = Integer.parseInt(clazzId);
            params[start + 3] = Integer.parseInt(courseId);
        }
        return queryRunner.update(DbUtils.getConnection(), sb.toString(), params);
    }

    @Override
    public int addTeacher(Teachee te) throws SQLException {
        Connection connection = DbUtils.getConnection();
        PreparedStatement pre = connection.prepareStatement(
            "insert into teacher(number, name,gender, phone,qq) values (?,?,?,?,?)",
            Statement.RETURN_GENERATED_KEYS
        );
        pre.setString(1, te.getNumber());
        pre.setString(2, te.getName());
        pre.setString(3, te.getGender());
        pre.setString(4, te.getPhone());
        pre.setString(5, te.getQq());

        int i = pre.executeUpdate();
        ResultSet resultSet = pre.getGeneratedKeys();
        if(resultSet.next()) {
            int tid = resultSet.getInt(1);
            te.setTid(tid);
        }
        return i;
    }

    @Override
    public List<Teachee> getAllTechs() throws SQLException {
        String sql = "SELECT t.*,c.*,g.*, z.cid AS zid,z.clazzName FROM teacher t " +
                "LEFT JOIN teacher_course tc ON tc.tid = t.tid " +
                "LEFT JOIN course c ON c.cid = tc.courseId " +
                "LEFT JOIN grade g ON tc.gid = g.gid " +
                "LEFT JOIN clazz z ON z.cid = tc.clazzId;";

        return queryRunner.query(sql, (ResultSetHandler<List<Teachee>>) resultSet -> {
            int last_tid = -1;
            ArrayList<Teachee> teacheeArrayList = new ArrayList<>();
            Teachee teachee = null;
            while (resultSet.next()) {
                int tid = resultSet.getInt("tid");

                int cid = resultSet.getInt("cid");
                String courseName = resultSet.getString("courseName");
                Course course = new Course();
                course.setCid(cid);
                course.setCourseName(courseName);

                int gid = resultSet.getInt("gid");
                String gradeName = resultSet.getString("gradeName");
                Grade grade = new Grade(gid);
                grade.setGid(gid);
                grade.setGradeName(gradeName);

                int zid = resultSet.getInt("zid");
                String clazzName = resultSet.getString("clazzName");
                Clazz clazz = new Clazz();
                clazz.setCid(zid);
                clazz.setClazzName(clazzName);

                Map<String, Object> map = new TreeMap<>();
                map.put("course", course);
                map.put("grade", grade);
                map.put("class", clazz);

                if(last_tid == tid) {
                    teachee.getCourseList().add(map);
                }else {
                    String number = resultSet.getString("number");
                    String name = resultSet.getString("name");
                    String gender = resultSet.getString("gender");
                    String phone = resultSet.getString("phone");
                    String qq = resultSet.getString("qq");

                    teachee = new Teachee();
                    teachee.setTid(tid);
                    teachee.setNumber(number);
                    teachee.setName(name);
                    teachee.setGender(gender);
                    teachee.setPhone(phone);
                    teachee.setQq(qq);

                    ArrayList<Map<String, Object>> arrayList = new ArrayList<>();
                    arrayList.add(map);
                    teachee.setCourseList(arrayList);

                    teacheeArrayList.add(teachee);

                    last_tid = tid;
                }
            }

            return teacheeArrayList;
        });
    }
}
