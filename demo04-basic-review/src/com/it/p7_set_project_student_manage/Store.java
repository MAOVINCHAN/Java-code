package com.it.p7_set_project_student_manage;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class Store {
    private String path;
    private final boolean append = true;
    FileReader fr;
    BufferedReader br;
    FileWriter fw;
    BufferedWriter bw;

    Store(String pathStr) {
        try {
            path = pathStr;
            fr = new FileReader(path);
            br = new BufferedReader(fr);
            fw = new FileWriter(path, append);
            bw = new BufferedWriter(fw);
        }catch(Exception err) {
            err.printStackTrace();
        }
    }

    public void closeAll() {
        try {
            if(fr != null) fr.close();
            if(br != null) br.close();
            if(fw != null) fw.close();
            if(bw != null) bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Student castToStudent(String str) {
        Pattern idReg = Pattern.compile("(?<=id=)[^,]*");
        Pattern nameReg = Pattern.compile("(?<=name=)[^,]*");
        Pattern ageReg = Pattern.compile("(?<=age=)[^,]*");
        Pattern scoreReg = Pattern.compile("(?<=score=)[^}]*");

        Matcher idMatcher = idReg.matcher(str);
        Matcher nameMatcher = nameReg.matcher(str);
        Matcher ageMatcher = ageReg.matcher(str);
        Matcher scoreMatcher = scoreReg.matcher(str);

        if(idMatcher.find() && nameMatcher.find() && ageMatcher.find() && scoreMatcher.find()) {
            Integer id = Integer.valueOf(idMatcher.group());
            String name = nameMatcher.group();
            Integer age = Integer.valueOf(ageMatcher.group());
            Float score = Float.valueOf(scoreMatcher.group());
            return new Student(id, name, age, score);
        }
        return null;
    }

    public ArrayList<Student> read() {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String line;
            while ((line = br.readLine()) != null) {
                Student student = castToStudent(line);
                students.add(student);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return students;
    }

    public Student readById(int id) {
        ArrayList<Student> students = read();

        for (Student stu :
            students) {
            if (stu.getId() == id) {
                return stu;
            }
        }
        return null;
    }

    public boolean write(Student stu) {
        try {
            bw.write(stu.toString());
            bw.newLine();
            bw.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean rewrite(ArrayList<Student> newStudents) {
        try {
            FileWriter fw = new FileWriter(path);
            BufferedWriter bw = new BufferedWriter(fw);
            for (Student stu :
                    newStudents) {
                bw.write(stu.toString());
                bw.newLine();
            }
            bw.close();
            fw.close();
            return true;
        }catch (Exception err) {
            err.printStackTrace();
        }
        return false;
    }
}
