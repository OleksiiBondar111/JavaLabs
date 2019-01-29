package com.bonolex.JavaBasic.lesson_4;

import org.junit.Assert;
import org.junit.Test;


public class LinkedListTest {
    @Test
    public void shouldAddValues() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        Assert.assertEquals(3, linkedList.size());
    }

    @Test
    public void shouldAddValueByIndex() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("A", 1);
        linkedList.add("B", 2);
        linkedList.add("C", 3);
        Assert.assertEquals(6, linkedList.size());

    }

    @Test
    public void shouldGetAddValueByIndex() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("Z", 2);
        Assert.assertEquals("A", linkedList.get(0));
        Assert.assertEquals("Z", linkedList.get(2));
        Assert.assertEquals(4, linkedList.size());
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldRemoveValueByIndex() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.remove(3);
        linkedList.get(3);
    }

    @Test
    public void shouldSetValue() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.set("D", 1);
        linkedList.set("Z", 3);
        Assert.assertEquals("Z", linkedList.get(3));
        Assert.assertEquals("D", linkedList.get(1));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldClearValues() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.clear();
        Assert.assertEquals(0, linkedList.size());
        linkedList.get(1);
    }

    @Test
    public void shouldReturnSize() {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 1_000_000; i++) {
            linkedList.add("C");
        }
        Assert.assertEquals(1_000_000, linkedList.size());
    }

    @Test
    public void shouldBeEmpty() {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < 1_000_000; i++) {
            linkedList.add("C");
        }
        linkedList.clear();
        Assert.assertTrue(linkedList.isEmpty());
    }

    @Test
    public void shouldContainsValue() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        Assert.assertTrue(linkedList.contains("A"));
        Assert.assertTrue(linkedList.contains("B"));
        Assert.assertTrue(linkedList.contains("C"));
    }

    @Test
    public void shouldReturnIndex() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        Assert.assertEquals(1, linkedList.indexOf("A"));
        Assert.assertEquals(2, linkedList.indexOf("B"));
        Assert.assertEquals(3, linkedList.indexOf("C"));
    }
    @Test
    public void shouldReturnLastIndex() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("A");
        linkedList.add("A");
        Assert.assertEquals(3, linkedList.lastIndexOf("A"));
    }
}
