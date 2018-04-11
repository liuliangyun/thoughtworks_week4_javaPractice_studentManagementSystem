package com.tw;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class ManageTest {
    private Manage manager;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        manager = new Manage();
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void test_addStudent() {
        int size = manager.klass.getStudentMap().size();
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
        manager.addStudent(student);
        assertEquals(manager.klass.getStudentMap().size(), size + 1);
    }

    @Test
    public void test_printGradeList() {
        String[] info = new String[]{""};
        manager.printGradeList(info);
        assertEquals(systemOut(), "成绩单\n" + "姓名|数学|语文|英语|编程|平均分|总分\n" + "========================\n" +
                "========================\n" + "全班总分平均数：0.0\n" + "全班总分中位数：0.0\n");
    }
}