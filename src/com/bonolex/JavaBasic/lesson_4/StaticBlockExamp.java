package com.bonolex.JavaBasic.lesson_4;

public class StaticBlockExamp {

    static {
        System.out.println("Inside static block");
    }
     {
        System.out.println("Inside inner block");
    }

    public static void main(String[] args) {
        new StaticBlockExamp();
        new StaticBlockExamp();
    }
}
