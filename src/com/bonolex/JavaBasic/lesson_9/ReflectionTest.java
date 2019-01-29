package com.bonolex.JavaBasic.lesson_9;

import java.lang.reflect.Field;
import java.util.Random;

public class ReflectionTest {
    public static void main(String[] args) throws Exception {
        // construct
        MessagePrinter messagePrinter = new MessagePrinter("Hello reflection");

        // post-processing
        injectRandomInt(messagePrinter);

        // run
        messagePrinter.print();
    }

    private static void injectRandomInt(Object value) throws Exception {
        Random random = new Random();
        Class<?> clazz = value.getClass();
        for (Field declaredField : clazz.getDeclaredFields()) {
            InjectRandomInt annotation = declaredField.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                int randomValue = random.nextInt(max - min) + min;
                declaredField.setAccessible(true);
                declaredField.set(value, randomValue);
                declaredField.setAccessible(false);
            }
        }
    }
}