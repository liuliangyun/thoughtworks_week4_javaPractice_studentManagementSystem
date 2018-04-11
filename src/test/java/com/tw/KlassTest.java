package com.tw;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.*;

public class KlassTest {
    private Klass klass;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        klass = new Klass();
        Item item1 = new Item("数学", 75);
        Item item2 = new Item("语文", 95);
        Item item3 = new Item("英语", 80);
        Item item4 = new Item("编程", 80);
        ArrayList<Item> itemlist = new ArrayList<>();
        itemlist.add(item1);
        itemlist.add(item2);
        itemlist.add(item3);
        itemlist.add(item4);
        Student student = new Student("张三", "001", itemlist);
        klass.addStudent(student);

        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void test_getStudentMap() {
        Item item1 = new Item("数学", 85);
        Item item2 = new Item("语文", 80);
        Item item3 = new Item("英语", 70);
        Item item4 = new Item("编程", 90);
        ArrayList<Item> itemlist = new ArrayList<>();
        itemlist.add(item1);
        itemlist.add(item2);
        itemlist.add(item3);
        itemlist.add(item4);
        Student student = new Student("李四", "002", itemlist);
        HashMap<String, Student> studentMap = klass.getStudentMap();
        studentMap.put(student.getId(), student);
        assertEquals(klass.getStudentMap(), studentMap);
    }

    @Test
    public void test_addStudent() {
        int size = klass.getStudentMap().size();
        Item item1 = new Item("数学", 85);
        Item item2 = new Item("语文", 80);
        Item item3 = new Item("英语", 70);
        Item item4 = new Item("编程", 90);
        ArrayList<Item> itemlist = new ArrayList<>();
        itemlist.add(item1);
        itemlist.add(item2);
        itemlist.add(item3);
        itemlist.add(item4);
        Student student = new Student("李四", "002", itemlist);
        klass.addStudent(student);
        assertEquals(klass.getStudentMap().size(), size + 1);
    }

    @Test
    public void test_printGradeListOfAStudent() {
        String id = "001";
        klass.printGradeListOfAStudent("001");
        assertEquals(systemOut(), "张三|75|95|80|80|82.5|330\n");
    }

    @Test
    public void test_getAverageGrade() {
        assertEquals(Double.toString(klass.getAverageGrade()), "330.0");
    }

    @Test
    public void test_getMedianGrade() {
        assertEquals(Double.toString(klass.getMedianGrade()), "330.0");
    }
}