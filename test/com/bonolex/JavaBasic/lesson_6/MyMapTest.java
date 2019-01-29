package com.bonolex.JavaBasic.lesson_6;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;

public class MyMapTest {


    @Test
    public void shouldPutEntry() {
        HashMapImpl map = new HashMapImpl();
        Assert.assertNull(map.put("A", "first letter"));
        Assert.assertEquals("first letter", map.put("A", "first letter"));
        Assert.assertEquals("first letter", map.put("A", "first letter2"));
    }

    @Test
    public void shouldPutAll() {
        HashMapImpl map = new HashMapImpl();
        HashMap input = new HashMap();
        input.put("A", "first letter");
        input.put("B", "second letter");
        map.putAll(input);
        Assert.assertEquals("first letter", map.get("A"));
        Assert.assertEquals("second letter", map.get("B"));
    }

    @Test
    public void shouldGetEntryValue() {
        HashMapImpl map = new HashMapImpl();
        Assert.assertNull(map.put("A", "first letter"));
        Assert.assertEquals("first letter", map.get("A"));
    }

    @Test
    public void shouldPutIfAbsent() {
        HashMapImpl map = new HashMapImpl();
        Assert.assertNull(map.putIfAbsent("A", "first letter"));
        Assert.assertEquals("first letter", map.putIfAbsent("A", "first letter2"));
    }

    @Test
    public void shouldPutAllIfAbsent() {
        HashMap input = new HashMap();
        input.put("A", "first letter");
        input.put("A", "first letter2");
        HashMapImpl map = new HashMapImpl();
        map.putAllIfAbsent(input);
        Assert.assertEquals("first letter2", map.get("A"));
    }
    @Test
    public void shouldContainsKey() {
        HashMap input = new HashMap();
        input.put("A", "first letter");
        input.put("A", "first letter2");
        HashMapImpl map = new HashMapImpl();
        map.putAllIfAbsent(input);
        Assert.assertTrue(map.containsKey("A"));
        Assert.assertFalse(map.containsKey("B"));
    }
    @Test
    public void shouldRemove() {
        HashMap input = new HashMap();
        input.put("A", "first letter");
        input.put("B", "second letter");
        HashMapImpl map = new HashMapImpl();
        map.putAllIfAbsent(input);
        map.remove("B");
        Assert.assertTrue(map.containsKey("A"));
        Assert.assertFalse(map.containsKey("B"));
    }
}
