package com.project.stusys.dao;

import com.project.stusys.model.Student;

import java.sql.SQLException;
import java.util.List;

public interface StudentDao {
    List<Student> getStudents() throws SQLException;
    int delStudentByNums(String[] numbers) throws SQLException;

    int addStudent(Student student) throws SQLException;

    int chgStudent(Student student) throws SQLException;
}
