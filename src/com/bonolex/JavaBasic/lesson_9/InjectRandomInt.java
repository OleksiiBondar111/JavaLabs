package com.bonolex.JavaBasic.lesson_9;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD) // optional
@Retention(RetentionPolicy.RUNTIME)
public @interface InjectRandomInt {
    int max();

    int min() default 0;
}