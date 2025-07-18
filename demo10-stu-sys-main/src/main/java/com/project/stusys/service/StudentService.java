package com.project.stusys.service;

import com.project.stusys.model.Student;

import java.util.List;

public interface StudentService {
    List<Student> getStudents();
    int delStudentByNums(String[] numbers);

    int addStudent(Student student);

    int chgStudent(Student student);
}
