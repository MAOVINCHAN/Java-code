package com.project.stusys.dao.impl;

import com.project.stusys.dao.StudentDao;
import com.project.stusys.model.Clazz;
import com.project.stusys.model.Grade;
import com.project.stusys.model.Student;
import com.project.stusys.utils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.ResultSetHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDaoImpl implements StudentDao {
    private QueryRunner queryRunner = new QueryRunner(DbUtils.getDataSource());

    @Override
    public int chgStudent(Student student) throws SQLException {
        Object[] params = {
            student.getName(),
            student.getGender(),
            student.getPhone(),
            student.getQq(),
            student.getClazz().getCid(),
            student.getGrade().getGid(),
            student.getNumber(),
        };
        return queryRunner.update("update student set name=?,gender=?,phone=?,qq=?,cid=?,gid=? where number=?", params);
    }

    @Override
    public int addStudent(Student student) throws SQLException {
        Object[] params = {
            student.getNumber(),
            student.getName(),
            student.getGender(),
            student.getPhone(),
            student.getQq(),
            student.getClazz().getCid(),
            student.getGrade().getGid(),
        };
        return queryRunner.update("insert into student(number, name,gender,phone,qq,cid,gid)values (?,?,?,?,?,?,?)", params);
    }

    @Override
    public List<Student> getStudents() throws SQLException {
        String sql = "SELECT s.*,c.*,g.* FROM student s LEFT JOIN clazz c ON c.cid=s.cid LEFT JOIN grade g ON g.gid = s.gid;";
        return queryRunner.query(sql, resultSet -> {
            List<Student> list = new ArrayList<>();
            while (resultSet.next()) {
                int sid = resultSet.getInt("sid");
                String number = resultSet.getString("number");
                String name = resultSet.getString("name");
                String gender = resultSet.getString("gender");
                String phone = resultSet.getString("phone");
                String qq = resultSet.getString("qq");
                Student student = new Student(sid, number, name, gender, phone, qq);

                int cid = resultSet.getInt("cid");
                String clazzName = resultSet.getString("clazzName");
                Clazz clazz = new Clazz(cid, clazzName);
                student.setClazz(clazz);

                int gid = resultSet.getInt("gid");
                String gradeName = resultSet.getString("gradeName");
                Grade grade = new Grade(gid, gradeName);
                student.setGrade(grade);

                list.add(student);
            }

            return list;
        });
    }

    @Override
    public int delStudentByNums(String[] numbers) throws SQLException {
        StringBuilder sql = new StringBuilder("delete from student where  number in ");
        for (int i = 0; i < numbers.length; i++) {
            if(i == 0) sql.append("(");
            if(i != numbers.length - 1) {
                sql.append("?,");
            }else {
                sql.append("?)");
            }
        }
        return queryRunner.update(sql.toString(), numbers);
    }
}
