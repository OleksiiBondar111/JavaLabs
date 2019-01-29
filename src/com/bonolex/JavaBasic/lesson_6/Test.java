package com.bonolex.JavaBasic.lesson_6;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(new Person("John", 10));
        list.add(new Person("Ann", 7));
        list.add(new Person("Julia", 17));

        Collections.sort(list);

        for (Object o : list) {
            System.out.println(o);
        }

        Collections.sort(list, PersonComparators.PERSON_AGE_COMPARATOR);

        for (Object o : list) {
            System.out.println(o);
        }
    }
}