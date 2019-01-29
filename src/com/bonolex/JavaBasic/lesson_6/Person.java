package com.bonolex.JavaBasic.lesson_6;

class Person implements Comparable {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    //    @return  a negative integer, zero, or a positive integer as this object
    //    is less than, equal to, or greater than the specified object.
    @Override
    public int compareTo(Object o) {
        Person that = (Person) o;
        return age - that.age;
    }
}