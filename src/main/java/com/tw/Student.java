package com.tw;

import java.util.ArrayList;

public class Student {
    private String name;
    private String id;
    private ArrayList<Item> itemlist;

    public Student(String name, String id, ArrayList<Item> itemlist) {
        this.name = name;
        this.id = id;
        this.itemlist = itemlist;
    }

    public String getName() {
        return name;
    }

    public String getId() {
        return id;
    }

    public ArrayList<Item> getItemlist() {
        return itemlist;
    }

    // 计算该学生成绩总分
    public int getSum() {
        int sum = 0;
        for (int i = 0; i < itemlist.size(); i++) {
            sum += itemlist.get(i).getGrade();
        }
        return sum;
    }

    // 计算该学生成绩平均分
    public double getAverage() {
        double average = (double) getSum() / itemlist.size();
        return average;
    }
}
