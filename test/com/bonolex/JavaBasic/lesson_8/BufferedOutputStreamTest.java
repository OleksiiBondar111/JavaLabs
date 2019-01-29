package com.bonolex.JavaBasic.lesson_8;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Random;

import static org.junit.Assert.assertEquals;

public class BufferedOutputStreamTest {

    byte[] testArray = new byte[1024];
    ByteArrayOutputStream outputStream;
    BufferedOutputStream bufferedOutputStream;

    @Before
    public void before() {
        new Random().nextBytes(testArray);
        outputStream = new ByteArrayOutputStream();
        bufferedOutputStream = new BufferedOutputStream(outputStream);
    }

    @Test
    public void shouldWrite() throws IOException {
        for (byte b : testArray) {
            bufferedOutputStream.write(b);
        }
        bufferedOutputStream.flush();

        byte[] data = outputStream.toByteArray();
        for (int i = 0; i < testArray.length; i++) {
            assertEquals(testArray[i], data[i]);
        }
    }


    @Test
    public void shouldWriteArray() throws IOException {
        bufferedOutputStream.write(testArray);
        bufferedOutputStream.flush();
        byte[] outputBuffer = outputStream.toByteArray();
        for (int i = 0; i < outputBuffer.length; i++) {
            assertEquals(testArray[i], outputBuffer[i]);
        }
    }

    @Test
    public void shouldReadOffSet() throws IOException {
        int off = 0;
        int len = 1024;
        bufferedOutputStream.write(testArray, off, len);
        bufferedOutputStream.flush();
        byte[] outputBuffer = outputStream.toByteArray();
        for (int i = 0; i < len; i++) {
            assertEquals(testArray[off + i], outputBuffer[i]);
        }
    }

    @After
    public void after() throws IOException {
        outputStream.close();
        bufferedOutputStream.close();
    }
}