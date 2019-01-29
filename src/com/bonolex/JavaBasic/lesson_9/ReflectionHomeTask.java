package com.bonolex.JavaBasic.lesson_9;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectionHomeTask {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
        getMethodsWithoutParameters(Person.class);
    }


    static void getMethodsWithoutParameters(Object inputClass) throws InvocationTargetException, IllegalAccessException {
       // Class<?> clazz = inputClass.getClass();
        Field methods[]= inputClass.getClass().getFields();
        for (Field method:methods) {
            if(!method.toString().contains("final")){
                method.setAccessible(true);
               // System.out.println("Modifiers are: "+method.getModifiers());
              //  System.out.println("Return type is: "+method.getReturnType());
               // method.invoke(inputClass,new Object[]{});
                //System.out.println("Method is: "+method);
                System.out.println("Method getName is: "+method.getName());
               // System.out.println("Method toString()  "+method.toString());

                method.setAccessible(false);
            }
        }
    }



}

//    Метод принимает object и вызывает у него все методы без параметров//
//        Метод принимает object и выводит на экран все сигнатуры методов в ко//торых есть final
//        Метод принимает Class и возвращает список всех предков класса и все интерфейсы которое класс имплементирует
//        Метод принимает объект и меняет всего его поля на их нулевые значение (null, 0, false etc)+

