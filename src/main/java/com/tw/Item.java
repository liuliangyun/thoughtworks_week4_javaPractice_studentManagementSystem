package com.tw;

public class Item {
    private String subject;
    private int grade;

    public Item(String subject, int grade) {
        this.subject = subject;
        this.grade = grade;
    }

    public String getSubject() {
        return subject;
    }

    public int getGrade() {
        return grade;
    }
}
