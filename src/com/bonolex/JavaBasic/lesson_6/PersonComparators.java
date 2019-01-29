package com.bonolex.JavaBasic.lesson_6;

import java.util.Comparator;

public class PersonComparators {
    public static final Comparator PERSON_NAME_COMPARATOR = new PersonNameComparator();

    public static final Comparator PERSON_AGE_COMPARATOR = new Comparator() {
        public int compare(Object o1, Object o2) {
            Person first = (Person) o1;
            Person second = (Person) o2;
            return Integer.compare(first.age, second.age);
        }
    };

}