package com.bonolex.JavaBasic.lesson_8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Container integerContainer = new Container();
        integerContainer.setValue(100);
        int intValue = (Integer) integerContainer.getValue();

//        Container<String> stringContainer = new Container<>();
//        stringContainer.setValue("100");
//        String stringValue = (String)stringContainer.getValue();

        List<Integer> src = Arrays.asList(12, 15, 18);
        List<String> dest = new ArrayList<>();
        for (String value : dest) {

        }
        //CollectionUtils.copy(src, dest);
    }
}


class CollectionUtils {
    public static <T> void copy(List<T> src, List<T> dest) {
        for (T value : src) {
            dest.add(value);
        }
    }
}

// source
class Container<T> {
    T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
//
//class Container {
//    Object value;
//
//    public Object getValue() {
//        return value;
//    }
//
//    public void setValue(Object value) {
//        this.value = value;
//    }
//}