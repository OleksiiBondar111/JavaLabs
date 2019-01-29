package com.bonolex.JavaBasic.lesson_9;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class ReflectionTraining {

    private static void invokeObjectMethods(Object object) {
        System.out.println("Class name is: " + object.getClass().getName());
        Method[] methods = object.getClass().getMethods();
        for (Method method : methods) {
            if (method.getParameterCount() == 0) {
                System.out.println("Object method is: " + method.getName());
                try {
                    method.invoke(object, null);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();

                }
            }
        }
    }
    private static void printMethodsWithFinal(Object object){
        System.out.println("Class name is: " + object.getClass().getName());
        Method[] methods = object.getClass().getDeclaredMethods();
        for (Method method : methods) {
            if (method.toString().contains("final")) {
                System.out.println("Object method is: " + method.toString());
            }
        }
    }

    private static void printListOfImplInterfaces(Object object){
        System.out.println("Class name is: " + object.getClass().getName());
        Type[] genericInterfaces = object.getClass().getGenericInterfaces();
        Class<?>[] classes = object.getClass().getDeclaredClasses();
        for (Type genericInterface : genericInterfaces) {
            System.out.println("Implemented interface is: " + genericInterface);
        }
        for (Class<?> aClass : classes) {
            System.out.println("Object class is: " + aClass);
        }
    }

    private static void setAllFieldsOfObjectToNull(Object object) throws IllegalAccessException {
        System.out.println("Class name is: " + object.getClass().getName());
        Field[] fields = object.getClass().getDeclaredFields();
        for (Field field : fields) {
            if (!field.toString().contains("final")) {
                field.setAccessible(true);
                System.out.println("Field name is: " + field.getName());
                System.out.println("Field value is: " + field.get(object));
                field.set(object, null);
                System.out.println("Field value after modification is: " + field.get(object));
                field.setAccessible(false);
            }
        }

    }


    public static void main (String[]args) throws IllegalAccessException, InvocationTargetException {
        class Person implements Comparable<Person> {
            private String name;
            private String surname;
            private Integer age;
            private final boolean conviction = false;

            public Person(String name, String surname, Integer age) {
                this.name = name;
                this.surname = surname;
                this.age = age;
            }

            public String getName() {
                System.out.println("inside getName() method");
                return name;
            }

            public void setName(String name) {
                System.out.println("inside setName() method");
                this.name = name;
            }

            public String getSurname() {
                System.out.println("inside getSurname() method");
                return surname;
            }

            public void setSurname(String surname) {
                System.out.println("inside setSurname() method");
                this.surname = surname;
            }

            public Integer getAge() {
                System.out.println("inside getAge() method");
                return age;
            }

            public void setAge(Integer age) {
                System.out.println("inside setAge() method");
                this.age = age;
            }

            public boolean isConviction() {
                System.out.println("inside isConviction() method");
                return conviction;
            }

            @Override
            public int compareTo(Person p) {
                return name.compareTo(p.name);
            }

            @Override
            public String toString() {
                return "Person{" +
                        "name='" + name + '\'' +
                        ", surname='" + surname + '\'' +
                        '}';
            }
        }

        Person person = new Person("Alex", "Plank", 23);
        setAllFieldsOfObjectToNull(person);
        printListOfImplInterfaces(person);
        printMethodsWithFinal(person);
        invokeObjectMethods(person);

    }


}
