package com.bonolex.JavaBasic.lesson_9;
import com.bonolex.JavaBasic.lesson_4.ArrayList;
import com.bonolex.JavaBasic.lesson_8.BufferedOutputStream;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ReflectionTest2   {
    public static void main(String[] args) throws ClassNotFoundException {
getMethodsWithoutParameters(Object.class);
        String[] names = new String[10];
        for (int i = 0; i < names.length; i++) {
            names[i] = "John";
        }
//        clazz = String.class;
//        clazz = Class.forName("java.lang.String");
        String name = "John";
        test(name);

        System.out.println(name);
        for (String s : names) {
            System.out.println(s);
        }

    }

    static void test(Object name) {
        Class<?> clazz = name.getClass(); // String
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.getName().equals("value")) {
                System.out.println(field);
                String newValue = "John sucks";
                try {
                    field.setAccessible(true);
                    field.set(name, newValue.toCharArray());
                    field.setAccessible(false);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static void getMethodsWithoutParameters(Object inputClass){
        Class<?> clazz = inputClass.getClass();
        Method methods[]= clazz.getDeclaredMethods();
        for (Method method:methods) {
            if(method.getParameterCount()==0){

                System.out.println(method);
            }
        }
    }

}

//    Метод принимает object и вызывает у него все методы без параметров//
//        Метод принимает object и выводит на экран все сигнатуры методов в ко//торых есть final
//        Метод принимает Class и возвращает список всех предков класса и все интерфейсы которое класс имплементирует
//        Метод принимает объект и меняет всего его поля на их нулевые значение (null, 0, false etc)+