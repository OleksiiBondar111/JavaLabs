package com.bonolex.JavaBasic.lesson_6;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class HashMapImpl2 implements Map {

    private static final int INITIAL_CAPASITY = 3;
    private static final double LOAD_FACTOR = 0.75;
    private static final double GROWTH_FACTOR = 2;

    private List<List<Entry>> buckets = new ArrayList<>(INITIAL_CAPASITY);
    private int size;

    public HashMapImpl2() {
        for (int i = 0; i < INITIAL_CAPASITY; i++) {
            buckets.add(new ArrayList<>());
        }
    }

    private void rebalance() {
        int capacity = buckets.size();
        if (size > capacity * LOAD_FACTOR) {
            for (int i = capacity; i < capacity * GROWTH_FACTOR; i++) {
                buckets.add(new ArrayList<>());
            }
            int newCapacity = (int) (capacity * GROWTH_FACTOR);
            int currentIndex = 0;
            for (List<Entry> entries : buckets) {

                for (Iterator iterator = entries.iterator(); iterator.hasNext();) {
                    Entry entry = (Entry) iterator.next();
                    if (getBucketId(entry.key) != currentIndex) {
                        iterator.remove();
                        size--;
                        put(entry.key, entry.value);
                    }
                }
                currentIndex++;
            }

        }
    }



    // -2^31 ... 2^31-1
    // o.hashCode -> -2^31
    private int getBucketId(Object key) {
        return Math.abs(key.hashCode() % buckets.size());
    }


    public static void main(String[] args) {
        HashMapImpl2 hashMap = new HashMapImpl2();
        String key = "key11112222333444";
        hashMap.put(key, 123);
        System.out.println(hashMap.get(key));
    }


    private List<Entry> getEntryListByKey(Object key) {
        List<Entry> entryList = buckets.get(getBucketId(key));
        return entryList == null ? new ArrayList<>() : entryList;
    }


    @Override
    public Object put(Object key, Object value) {
        List<Entry> entryList = getEntryListByKey(key);

        for (Entry entry : entryList) {
            if (entry.key.equals(key)) {
                Object returnValue = entry.value;
                entry.value = value;
                return returnValue;
            }
        }
        entryList.add(new Entry(key, value));
        size++;
        rebalance();
        return null;
    }

    @Override
    public Object putIfAbsent(Object key, Object value) {
        List<Entry> entryList = getEntryListByKey(key);
        for (Entry entry : entryList) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        entryList.add(new Entry(key, value));
        size++;
        rebalance();
        return null;
    }

    @Override
    public void putAll(HashMap map) {
        for (Object entry : map.entrySet()) {
            put(((Entry) entry).key, ((Entry) entry).value);
        }
    }

    @Override
    public void putAllIfAbsent(HashMap map) {
        for (Object entry : map.entrySet()) {
            putIfAbsent(((Entry) entry).key, ((Entry) entry).value);
        }
    }

    @Override
    public Object get(Object key) {
        Entry entry = getEntry(key);
        return entry == null ? null : entry.value;
    }

    public Entry getEntry(Object key) {
        List<Entry> entryList = getEntryListByKey(key);
        for (Entry entry : entryList) {
            if (entry.key.equals(key)) {
                return entry;
            }
        }
        return null;
    }

    @Override
    public Object remove(Object key) {
        List<Entry> entryList = getEntryListByKey(key);
        for (Iterator iterator = entryList.iterator(); iterator.hasNext(); ) {
            Entry e = (Entry) iterator.next();
            if (e.key.equals(key)) {
                Object returnValue = e.value;
                iterator.remove();
                size--;
                return returnValue;
            }
        }
        return null;
    }

    @Override
    public boolean containsKey(Object key) {
        List<Entry> entryList = getEntryListByKey(key);
        for (Entry entry : entryList) {
            if (entry.key.equals(key)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int size() {
        return this.size;
    }


    //==================================================================================================================
    public static class Entry {
        private Object key;
        private Object value;

        private Entry(Object key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Object getKey() {
            return key;
        }

        public Object getValue() {
            return value;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "key=" + key +
                    ", value=" + value +
                    '}';
        }
    }

    //==================================================================================================================
    @Override
    public Iterator iterator() {
        return new MyHashMapIterator();
    }

    private class MyHashMapIterator implements Iterator {
        private int bucketIndex;
        private Iterator bucketIterator;
        private boolean isNext = false;

        @Override
        public boolean hasNext() {
//            return pos < size();
            return false;
        }

        @Override
        public Entry next() {
            if (!hasNext()) {
                return null;
            }
            Entry res = null;
//
//            List<Entry> entries = buckets.get(bucketPos);
//            if (entries.size() < bucketIndex + 1) {
//                bucketPos++;
//                bucketIndex = 0;
//                res = next();
//            } else {
//                bucketIndex++;
//                pos++;
//                res = entries.get(bucketIndex - 1);
//                isNext = true;
//            }
            return res;
        }

        @Override
        public void remove() {
//            if (size() == 0 || !isNext) {
//                throw new IllegalStateException();
//            }
//
//            List<Entry> entries = buckets.get(bucketPos);
//            entries.remove(bucketIndex - 1);
//            bucketIndex--;
//            size--;
//            pos--;
        }
    }


}