package com.bonolex.JavaBasic.lesson_9;

import java.lang.reflect.Field;
import java.util.StringJoiner;

public class QueryGenerator {
    public String getAll(Class<?> clazz) {
        StringBuilder stringBuilder = new StringBuilder("SELECT ");

        Table annotation = clazz.getAnnotation(Table.class);

        if (annotation == null) {
            throw new IllegalArgumentException("@Table is missing");
        }

        String tableName = annotation.name().isEmpty() ? clazz.getName() : annotation.name();

        StringJoiner stringJoiner = new StringJoiner(", ");

        for (Field declaredField : clazz.getDeclaredFields()) {
            Column columnAnnotation = declaredField.getAnnotation(Column.class);
            if (columnAnnotation != null) {
                String columnName = columnAnnotation.name().isEmpty() ?
                        declaredField.getName() : columnAnnotation.name();
                stringJoiner.add(columnName);
            }
        }

        stringBuilder.append(stringJoiner);
        stringBuilder.append(" FROM ");
        stringBuilder.append(tableName);
        stringBuilder.append(";");

        return stringBuilder.toString();
    }

    public String insert(Object value) {
        return null;
    }

    public String update(Object value) {
        return null;
    }

    public String getById(Class clazz, Object id) {
        return null;
    }

    public String delete(Class clazz, Object id) {
        return null;
    }
}