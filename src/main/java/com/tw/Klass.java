package com.tw;

import java.util.*;

public class Klass {
    // 键值为学生id的集合
    private HashMap<String, Student> studentMap;

    public Klass() {
        this.studentMap = new HashMap<>();
    }

    public HashMap<String, Student> getStudentMap() {
        return studentMap;
    }

    // 增加一个学生的成绩
    public void addStudent(Student student) {
        studentMap.put(student.getId(), student);
    }

    // 打印一个学生的成绩列表
    public void printGradeListOfAStudent(String id) {
        // 如果不存在输入的学号，则忽略
        if (studentMap.containsKey(id)) {
            Student student = studentMap.get(id);
            System.out.print(student.getName() + "|");
            ArrayList<Item> itemlist = student.getItemlist();
            for (int i = 0; i < itemlist.size(); i++) {
                System.out.print(itemlist.get(i).getGrade() + "|");
            }
            System.out.print(student.getAverage() + "|" + student.getSum() + "\n");
        }
    }

    // 计算全班总分平均数
    public double getAverageGrade() {
        double averageOfKlass = 0;
        if (studentMap.size() > 0) {
            int sumOfKlass = 0;
            for (String s : studentMap.keySet()) {
                Student student = studentMap.get(s);
                sumOfKlass += student.getSum();
            }
            averageOfKlass = (double) sumOfKlass / studentMap.size();
        }
        return averageOfKlass;
    }

    // 计算全班总分中位数
    public double getMedianGrade() {
        double medianOfKlass = 0;
        if (studentMap.size() > 0) {
            // 对全班总分从小到大排序
            ArrayList<HashMap.Entry<String, Student>> studentList = new ArrayList<>(studentMap.entrySet());
            Collections.sort(studentList, (o1, o2) -> {
                if (o1.getValue().getSum() < o2.getValue().getSum()) {
                    return -1;
                } else if (o1.getValue().getSum() == o2.getValue().getSum()) {
                    return 0;
                } else {
                    return 1;
                }
            });
            // 如果班级学生数为偶数，则取中间两位的平均值作为中位数
            if (studentList.size() % 2 == 0) {
                double x1 = (double) studentList.get(studentList.size() / 2 - 1).getValue().getSum();
                double x2 = (double) studentList.get(studentList.size() / 2).getValue().getSum();
                medianOfKlass = (x1 + x2) / 2;
            }
            // 否则，取最中间的数为中位数
            else {
                medianOfKlass = (double) studentList.get(studentList.size() / 2).getValue().getSum();
            }
        }
        return medianOfKlass;
    }
}
