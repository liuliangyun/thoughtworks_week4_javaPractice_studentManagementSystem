package com.tw;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class StudentTest {
    private Student student;

    @Before
    public void setUp() throws Exception {
        Item item1 = new Item("数学", 75);
        Item item2 = new Item("语文", 95);
        Item item3 = new Item("英语", 80);
        Item item4 = new Item("编程", 80);
        ArrayList<Item> itemlist = new ArrayList<>();
        itemlist.add(item1);
        itemlist.add(item2);
        itemlist.add(item3);
        itemlist.add(item4);
        student = new Student("张三", "001", itemlist);
    }

    @Test
    public void test_student_have_nameAndIdAndItemList() {
        assertEquals(student.getName(), "张三");
        assertEquals(student.getId(), "001");
    }

    @Test
    public void test_student_have_ItemList() {
        assertEquals(student.getItemlist().size(), 4);
        assertEquals(student.getItemlist().get(0).getSubject(), "数学");
        assertEquals(student.getItemlist().get(0).getGrade(), 75);
        assertEquals(student.getItemlist().get(1).getSubject(), "语文");
        assertEquals(student.getItemlist().get(1).getGrade(), 95);
        assertEquals(student.getItemlist().get(2).getSubject(), "英语");
        assertEquals(student.getItemlist().get(2).getGrade(), 80);
        assertEquals(student.getItemlist().get(3).getSubject(), "编程");
        assertEquals(student.getItemlist().get(3).getGrade(), 80);
    }

    @Test
    public void test_getSum_and_getAverage() {
        assertEquals(student.getSum(), 330);
        assertEquals(Double.toString(student.getAverage()), "82.5");
    }
}