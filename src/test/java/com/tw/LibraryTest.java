package com.tw;

import org.junit.Before;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class LibraryTest {
    private Library library;
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUp() throws Exception {
        library = new Library();
        System.setOut(new PrintStream(outContent));
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void test_displayMenu() {
        library.displayMenu();
        assertEquals(systemOut(), "1. 添加学生\n2. 生成成绩单\n3. 退出\n请输入你的选择（1～3）：\n");
    }

    @Test
    public void test_displayPageOfFunction1_addSuccessful() {
        String str = "张三, 001, 数学: 75, 语文: 95, 英语: 80, 编程: 80";
        String[] info = str.split(", ");
        library.displayPageOfFunction1(info);
        assertEquals(systemOut(), "学生张三的成绩被添加\n");
    }

    @Test
    public void test_displayPageOfFunction1_addFailed() {
        String str = "张三, 001, 数学: 75, 语文: 95";
        String[] info = str.split(", ");
        library.displayPageOfFunction1(info);
        assertEquals(systemOut(), "请按正确的格式输入（格式：姓名, 学号, 学科: 成绩, ...）：\n");
    }

    @Test
    public void test_isCorrectFormatOfStudent() {
        String[] info = new String[]{"张三", "001", "数学: 75", "语文: 95", "英语: 80", "编程: 80"};
        assertEquals(library.isCorrectFormatOfStudent(info), true);
        String[] info2 = new String[]{"张三", "001", "数学: 75", "语文: 95"};
        assertEquals(library.isCorrectFormatOfStudent(info2), false);
    }

    @Test
    public void test_displayPageOfFunction2_addFailed() {
        String str = "001、 002、";
        String[] info = str.split(", ");
        library.displayPageOfFunction2(info);
        assertEquals(systemOut(), "请按正确的格式输入要打印的学生的学号（格式： 学号, 学号,...），按回车提交：\n");
    }

    @Test
    public void test_isCorrectFormatOfIdList() {
        String[] info = new String[]{"001", "002"};
        assertEquals(library.isCorrectFormatOfIdList(info), true);
        String[] info2 = new String[]{"001002"};
        assertEquals(library.isCorrectFormatOfIdList(info2), false);
    }
}

