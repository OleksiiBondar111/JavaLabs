package com.bonolex.JavaBasic.lesson_5;


import com.bonolex.JavaBasic.lesson_4.LinkedList;
import org.junit.Assert;
import org.junit.Test;


public abstract class AbstractListTest {
    LinkedList linkedList;

    public abstract LinkedList getList();

    @Test
    public void shouldAddValues() {
        linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        Assert.assertEquals(3, linkedList.size());
    }

    @Test
    public void shouldAddValueByIndex() {
        linkedList = new LinkedList();
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
        linkedList = new LinkedList();
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
        linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.remove(3);
        linkedList.get(3);
    }

    @Test
    public void shouldSetValue() {
        linkedList = new LinkedList();
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
        linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.clear();
        Assert.assertEquals(0, linkedList.size());
        linkedList.get(1);
    }

    @Test
    public void shouldReturnSize() {
        linkedList = new LinkedList();
        for (int i = 0; i < 1_000_000; i++) {
            linkedList.add("C");
        }
        Assert.assertEquals(1_000_000, linkedList.size());
    }

    @Test
    public void shouldBeEmpty() {
        linkedList = new LinkedList();
        for (int i = 0; i < 1_000_000; i++) {
            linkedList.add("C");
        }
        linkedList.clear();
        Assert.assertTrue(linkedList.isEmpty());
    }

    @Test
    public void shouldContainsValue() {
        linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        Assert.assertTrue(linkedList.contains("A"));
        Assert.assertTrue(linkedList.contains("B"));
        Assert.assertTrue(linkedList.contains("C"));
    }

    @Test
    public void shouldReturnIndex() {
        linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        Assert.assertEquals(1, linkedList.indexOf("A"));
        Assert.assertEquals(2, linkedList.indexOf("B"));
        Assert.assertEquals(3, linkedList.indexOf("C"));
    }
    @Test
    public void shouldReturnLastIndex() {
        linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("A");
        linkedList.add("A");
        Assert.assertEquals(3, linkedList.lastIndexOf("A"));
       // Integer i; i.intValue()
        int i=0;
    }

    @Test
    public void shouldIterate() {
        linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        int i=1;
        for (Object obj: linkedList) {
            Assert.assertEquals(i,linkedList.indexOf(obj));
            i++;
        }
        Assert.assertEquals(1, linkedList.indexOf("A"));
        Assert.assertEquals(2, linkedList.indexOf("B"));
        Assert.assertEquals(3, linkedList.indexOf("C"));
    }
}
