package com.bonolex.JavaBasic.lesson_6;

import com.bonolex.JavaBasic.lesson_4.LinkedList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class HashMapImpl implements Map {
    private ArrayList[] bucketList = new ArrayList[20];
    private int size;

    private void rebalance() {
        if (bucketList.length > size * 0.75) {
            ArrayList[] newBucketlist = new ArrayList[bucketList.length*2];
            System.arraycopy(bucketList, 0, newBucketlist, 0, bucketList.length);
            bucketList = newBucketlist;
        }
    }

    public HashMapImpl() {
        for (int i = 0; i < bucketList.length; i++) {
            bucketList[i] = new ArrayList();
        }
    }

    @Override
    public Object put(Object key, Object value) {
        Object oldValue = null;
        Entry entry = getEntry(key);
        if (entry != null) {
            oldValue = entry.value;
            entry.value = value;
        } else {
            bucketList[getHashKey(key)].add(new Entry(key, value));
            size++;
        }
        rebalance();
        return oldValue;
    }

    @Override
    public void putAll(HashMap map) {
        for (Object entryKey : map.keySet()) {
            put(entryKey, map.get(entryKey));
        }
     }

    /**
     * The putIfAbsent() method returns the previous value associated with the specified key,
     * or null if there was no mapping for the key. (A null return can also indicate that the map
     * previously associated null with the key, if the implementation supports null values.)
     */

    @Override
    public Object putIfAbsent(Object key, Object value) {
        Entry entry = getEntry(key);
        if (entry == null) {
            return put(key, value);
        }
        return entry.value;
    }

    @Override
    public void putAllIfAbsent(HashMap map) {
        for (Object entryKey : map.keySet()) {
            putIfAbsent(entryKey, map.get(entryKey));
        }
    }

    @Override
    public Object get(Object key) {
        Entry entry = getEntry(key);
        if (entry != null) {
            return entry.value;
        }
        return null;
    }

    @Override
    public Object remove(Object key) {
        if (containsKey(key)) {
            ArrayList bucket = bucketList[getHashKey(key)];
            for (int i = 0; i < bucket.size(); i++) {
                Entry entry = (Entry) bucket.get(i);
                if (entry.key.equals(key)) {
                    Object value = entry.value;
                    bucket.remove(entry);
                    size--;
                    return value;
                }
            }
        }
        return null;
    }

    private Entry getEntry(Object key) {
        int index = getHashKey(key);
        ArrayList bucket = bucketList[index];
        for (Object object : bucket) {
            Entry entry = (Entry) object;
            if (entry.key.equals(key)) {
                return entry;
            }
        }
        return null;
    }

    private int getHashKey(Object key) {
        return Math.abs(key.hashCode()) % bucketList.length;
    }


    @Override
    public boolean containsKey(Object key) {
        Entry entry = getEntry(key);
        if (entry != null) {
            return true;
        }
        return false;
    }

    public int size() {
        return size;
    }

    @Override
    public Iterator iterator() {
        return new HashMapImplIterator();
    }

    private class HashMapImplIterator implements Iterator {
        int count;
        int rootIndex;

        @Override
        public boolean hasNext() {
            return count < size();
        }

        @Override
        public Object next() {
            ArrayList value = null;
            if (hasNext()) {
                count++;
                value = bucketList[0];

            }
            return value;
        }
    }



        public static class Entry {
        Object key;
        Object value;

        private Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        List<String> listOfBooks = new ArrayList<>();
        HashMap m = new HashMap();

        System.out.println(m.putIfAbsent("A", "f"));
        System.out.println(m.putIfAbsent("A", "d"));
        System.out.println(m.get("A"));
//            listOfBooks.add("Programming Pearls");
//            listOfBooks.add("Clean Code");
//            listOfBooks.add("Effective Java");
//            listOfBooks.add("Code Complete");
//            Iterator<String> iterator = listOfBooks.iterator();
//            while(iterator.hasNext()){
//                String book = iterator.next();
//                listOfBooks.remove(book);
//            }
    }
}
