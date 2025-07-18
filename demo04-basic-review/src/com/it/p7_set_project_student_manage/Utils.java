package com.it.p7_set_project_student_manage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Utils {
    private static String stuPath = "C:/Users/admin/Desktop/project-J/demo04-basic-review/src/com/it/p7_set_project_student_manage/students.txt";
    private static String userPath = "C:/Users/admin/Desktop/project-J/demo04-basic-review/src/com/it/p7_set_project_student_manage/users.txt";
    public static void printMenu() {
        System.out.println("------------student management system-----------");
        System.out.println("| 1. display all students;                     |");
        System.out.println("| 2. add one student;                          |");
        System.out.println("| 3. delete one student;                       |");
        System.out.println("| 4. show one student info;                    |");
        System.out.println("| 5. modify student info;                      |");
        System.out.println("| 0. exit the system;                          |");
        System.out.println("------------------------------------------------");
    }

    public static void displayAll() {
        try {
            Store store = new Store(stuPath);
            ArrayList<Student> sts = store.read();
            if(sts.size() == 0) {
                System.out.println("数据为空！请重新选择...");
                return;
            }
            for (Student stu :
                    sts) {
                System.out.println(stu.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void addUser() {
        Scanner scanner = new Scanner(System.in);
        Integer id;
        while (true) {
            System.out.print("请输入学生id：");
            String input = scanner.next();
            if(input.equals("exit")) {
                return;
            }
            id = Integer.valueOf(input);
            Store store = new Store(stuPath);
            if(store.readById(id) == null) {
                break;
            }
            System.out.println("id重复，请重新输入！（输入exit返回上一步）");
        }
        System.out.println("-------------------");
        System.out.print("请输入学生姓名：");
        String name = scanner.next();
        System.out.println("-------------------");
        System.out.print("请输入学生年龄：");
        Integer age = Integer.valueOf(scanner.next());
        System.out.println("-------------------");
        System.out.print("请输入学生成绩：");
        Float score = Float.valueOf(scanner.next());

        Student student = new Student(id, name, age, score);
        Store store = new Store(stuPath);

        if(student.equals(store.readById(id))) {
            System.out.println("学生已存在！请勿重复添加");
            return;
        }

        boolean success = store.write(student);
        System.out.println(success ? "新增成功" : "新增失败");
    }

    public static void delUser() {
        Store store = new Store(stuPath);
        ArrayList<Student> students = store.read();
        if(students.size() == 0) {
            System.out.println("数据为空，无需删除。");
            return;
        }

        Scanner scanner = new Scanner(System.in);
        Integer id;
        while (true) {
            System.out.print("请输入需要删除的学生id：");
            String input = scanner.next();
            if(input.equals("exit")) {
                return;
            }
            id = Integer.valueOf(input);

            boolean exist = false;
            for (int i = 0;i < students.size();i++) {
                Student item = students.get(i);
                if(item.getId() == id) {
                    exist = true;
                    break;
                }
            }
            if(!exist) {
                System.out.println("未找到对应学生，请重新输入！（输入exit返回上一步）");
            }else  {
                break;
            }
        }

        ArrayList<Student> stuToDel = new ArrayList<>();
        for (Student stu :
            students) {
            if (stu.getId() == id) {
                stuToDel.add(stu);
            }
        }

        students.removeAll(stuToDel);

        boolean success = store.rewrite(students);

        System.out.println(success ? "删除成功" : "删除失败");
    }

    public static void queryUser() {
        Scanner scanner = new Scanner(System.in);
        Store store = new Store(stuPath);
        ArrayList<Student> students = store.read();
        if(students.size() == 0) {
            System.out.println("数据为空！");
            return;
        }

        Student target = null;
        loop: while (true) {
            System.out.print("输入要查询的id：");
            String input = scanner.next();
            if(input.equals("exit")) {
                return;
            }
            Integer id = Integer.valueOf(input);

            for (Student stu :
                    students) {
                if (stu.getId() == id) {
                    target = stu;
                    break loop;
                }
            }

            if(target == null) {
                System.out.println("未找到对应学生！请重新输入！（输入exit返回上一步）");
            }
        }

        System.out.print("查找结果：");
        System.out.println(target.toString());
    }

    public static void modifyUser() {
        Scanner scanner = new Scanner(System.in);
        Store store = new Store(stuPath);
        ArrayList<Student> students = store.read();
        if(students.size() == 0) {
            System.out.println("数据为空！");
            return;
        }

        Student target = null;
        loop: while (true) {
            System.out.print("输入要查询的id：");
            String input = scanner.next();
            if(input.equals("exit")) {
                return;
            }
            Integer id = Integer.valueOf(input);

            for (Student stu :
                    students) {
                if (stu.getId() == id) {
                    target = stu;
                    break loop;
                }
            }

            if(target == null) {
                System.out.println("未找到对应学生！请重新输入！（输入exit返回上一步）");
            }
        }

        System.out.print("输入新学生姓名：");
        String name = scanner.next();
        System.out.print("输入新学生年龄：");
        String input = scanner.next();
        Integer age = input.equals("") ? 0 : Integer.valueOf(input);
        System.out.print("输入新学生成绩：");
        String input2 = scanner.next();
        Float score = input2.equals("") ? 0 : Float.valueOf(input2);

        int id = target.getId();
        String tarName = name.equals("") ? target.getName() : name;
        Integer tarAge = age == 0 ? target.getAge() : age;
        Float tarScore = score == 0 ? target.getScore() : score;

        Student newStudent = new Student(id, tarName, tarAge, tarScore);

        if(tarAge.equals(newStudent)) {
            System.out.println("数据未发生变化！");
            return;
        }

        for (int i = 0; i < students.size();i++) {
            Student item = students.get(i);
            if(item.getId() == id) {
                students.remove(i);
                students.add(i, newStudent);
            }
        }

        boolean success = store.rewrite(students);

        System.out.println(success ? "修改成功" : "修改失败");
    }
}
























