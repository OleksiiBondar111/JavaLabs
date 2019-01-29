package com.bonolex.JavaBasic.lesson_9;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QueryGeneratorTest {
    @Test
    public void testGetAll() {
        QueryGenerator queryGenerator = new QueryGenerator();
        String getAllSql = queryGenerator.getAll(Person.class);

        String expectedSql = "SELECT id, person_name, salary FROM persons;";
        assertEquals(expectedSql, getAllSql);
    }
}