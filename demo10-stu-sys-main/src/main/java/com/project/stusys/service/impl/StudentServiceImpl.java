package com.project.stusys.service.impl;

import com.project.stusys.dao.StudentDao;
import com.project.stusys.dao.impl.StudentDaoImpl;
import com.project.stusys.model.Student;
import com.project.stusys.service.StudentService;

import java.sql.SQLException;
import java.util.List;

public class StudentServiceImpl implements StudentService {
    private StudentDao studentDao = new StudentDaoImpl();

    @Override
    public int chgStudent(Student student) {
        try {
            return studentDao.chgStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int addStudent(Student student) {
        try {
            return studentDao.addStudent(student);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Student> getStudents() {
        try {
            return studentDao.getStudents();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int delStudentByNums(String[] numbers) {
        try {
            return studentDao.delStudentByNums(numbers);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return -1;
    }
}
