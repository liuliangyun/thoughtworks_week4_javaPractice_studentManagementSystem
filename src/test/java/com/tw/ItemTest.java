package com.tw;

import org.junit.Test;

import static org.junit.Assert.*;

public class ItemTest {
    @Test
    public void test_item_have_subjectAndGrade() {
        Item item = new Item("数学", 75);
        assertEquals(item.getSubject(), "数学");
        assertEquals(item.getGrade(), 75);
    }
}