package com.tw;

import java.util.ArrayList;
import java.util.Scanner;

public class Library {
    private Manage manager = new Manage();

    public void welcomeToTheLibrary() {
        while (true) {
            displayMenu();
            Scanner sc = new Scanner(System.in);//将系统输入复制给变量
            String num = sc.nextLine();
            // 如果选择功能1
            if (num.equals("1")) {
                System.out.print("请输入学生信息（格式：姓名, 学号, 学科: 成绩, ...），按回车提交：\n");
                String[] info = sc.nextLine().split(", ");
                displayPageOfFunction1(info);
            }
            // 如果选择功能2
            else if (num.equals("2")) {
                System.out.print("请输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n");
                String[] info = sc.nextLine().split(", ");
                displayPageOfFunction2(info);
            }
            // 如果选择功能3
            else if (num.equals("3")) {
                System.exit(0);
            }
        }
    }

    // 显示主菜单
    public void displayMenu() {
        System.out.print("1. 添加学生\n2. 生成成绩单\n3. 退出\n请输入你的选择（1～3）：\n");
    }

    // 显示功能1页面
    public void displayPageOfFunction1(String[] info) {
        // 判断输入格式是否是正确的Student格式
        if (isCorrectFormatOfStudent(info)) {
            ArrayList<Item> itemlist = new ArrayList<>();
            for (int i = 2; i < info.length; i++) {
                String[] item_info = info[i].split(": ");
                Item item = new Item(item_info[0], Integer.parseInt(item_info[1]));
                itemlist.add(item);
            }
            Student student = new Student(info[0], info[1], itemlist);
            manager.addStudent(student);
            System.out.print("学生" + student.getName() + "的成绩被添加\n");
        } else {
            System.out.print("请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n");
        }
    }

    // 判断输入格式是否是正确的Student格式
    public boolean isCorrectFormatOfStudent(String[] info) {
        boolean flag = true;
        if (info == null || info.length != 6) {
            flag = false;
        } else {
            for (int i = 2; i < info.length; i++) {
                String[] item_info = info[i].split(": ");
                if (item_info == null || item_info.length != 2) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    // 显示功能2页面
    public void displayPageOfFunction2(String[] info) {
        // 判断输入格式是否是正确的学号列表格式
        if (isCorrectFormatOfIdList(info)) {
            manager.printGradeList(info);
        } else {
            System.out.print("请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n");
        }
    }

    // 判断输入格式是否是正确的学号列表格式，假设学号长度必须为3
    public boolean isCorrectFormatOfIdList(String[] info) {
        boolean flag = true;
        if (info == null || info.length >= 1) {
            for (int i = 0; i < info.length; i++) {
                if (info[i].length() != 3) {
                    flag = false;
                }
            }
        }
        return flag;
    }

    public static void main(String[] args) {
        Library library = new Library();
        library.welcomeToTheLibrary();
    }
}
