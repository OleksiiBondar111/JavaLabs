package com.bonolex.JavaBasic.lesson_4;

class A {
    A(int i) {
        System.out.println("A");
          System.out.println(i);
    }
}

class B extends A {

    B() {
         super(10);
        System.out.println("B2");
    }
}

class Test {
    public static void main(String[] args) {
        new B();
    }
}