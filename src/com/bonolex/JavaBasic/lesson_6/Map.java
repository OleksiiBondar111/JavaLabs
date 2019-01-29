package com.bonolex.JavaBasic.lesson_6;

import java.util.HashMap;

// if size > buckets.length * 0.75 (load factor) ->
// new buckets.length = buckets.length * 2
// Iterable <Entry>, next on iterator should return Entry
public interface Map extends Iterable {
    Object put(Object key, Object value);

    Object putIfAbsent(Object key, Object value);

    void putAll(HashMap map);

    void putAllIfAbsent(HashMap map);

    Object get(Object key);

    Object remove(Object key);

    boolean containsKey(Object key);

    int size();

}
