package com.tw;

public class Manage {
    Klass klass = new Klass();

    // 增加一个学生的成绩
    public void addStudent(Student student) {
        klass.addStudent(student);
    }

    // 生成成绩单
    public void printGradeList(String[] info) {
        System.out.print("成绩单\n");
        System.out.print("姓名|数学|语文|英语|编程|平均分|总分\n");
        System.out.print("========================\n");
        for (int i = 0; i < info.length; i++) {
            klass.printGradeListOfAStudent(info[i]);
        }
        System.out.print("========================\n");
        System.out.print("全班总分平均数：" + klass.getAverageGrade() + "\n");
        System.out.print("全班总分中位数：" + klass.getMedianGrade() + "\n");
    }
}
