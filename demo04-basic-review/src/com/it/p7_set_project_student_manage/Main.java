package com.it.p7_set_project_student_manage;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        loop: while (true) {
            Utils.printMenu();
            System.out.print("请选择：");
            Scanner sc = new Scanner(System.in);
            String choice = sc.next();
            switch (choice) {
                case "1" -> Utils.displayAll();
                case "2" -> Utils.addUser();
                case "3" -> Utils.delUser();
                case "4" -> Utils.queryUser();
                case "5" -> Utils.modifyUser();
                case "0" -> {
                    // break loop;
                    System.exit(0);
                }
                default -> System.out.println("没有这个选项!");
            }
        }
    }
}
