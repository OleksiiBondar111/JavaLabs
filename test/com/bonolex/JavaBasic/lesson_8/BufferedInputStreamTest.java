package com.bonolex.JavaBasic.lesson_8;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Random;

import static org.junit.Assert.assertEquals;


public class BufferedInputStreamTest {

    byte[] testArray = new byte[1024];
    BufferedInputStream bufferedInputStream;

    @Before
    public void before() {
        new Random().nextBytes(testArray);
        bufferedInputStream = new BufferedInputStream(new ByteArrayInputStream(testArray));
    }

    @Test
    public void shouldRead() throws IOException {
        for (byte b : testArray) {
            byte value = (byte) bufferedInputStream.read();
            assertEquals(b, value);
        }
    }

    @Test
    public void shouldReadToBuffer() throws IOException {
        byte[] buffer = new byte[1024];
        int count = bufferedInputStream.read(buffer);
        assertEquals(1024, count);
        for (int i = 0; i < buffer.length; i++) {
            assertEquals(testArray[i], buffer[i]);
        }
        count = bufferedInputStream.read(buffer);
        assertEquals(-1, count);
    }

    @Test
    public void shouldReadWithOffSet() throws IOException {
        byte[] bytes = new byte[512];
        int off = 0;
        int len = 100;
        bufferedInputStream.read(bytes, off, len);
        for (int i = 0; i < len; i++) {
            assertEquals(testArray[i], bytes[i + off]);
        }
    }

    @Test(expected = NullPointerException.class)
    public void shouldCloseInputStream() throws IOException {
        bufferedInputStream.close();
        Assert.assertEquals(0, bufferedInputStream.read());
    }

    @After
    public void after() throws IOException {
        bufferedInputStream.close();
    }
}