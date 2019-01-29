package com.bonolex.JavaBasic.lesson_6;

import java.util.Comparator;

class PersonNameComparator implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Person first = (Person) o1;
        Person second = (Person) o2;
        return -first.name.compareTo(second.name);
    }
}