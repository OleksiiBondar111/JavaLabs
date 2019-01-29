package com.bonolex.JavaBasic.lesson_8;

import java.io.IOException;
import java.io.InputStream;

public class BufferedInputStream extends InputStream {
    private static int DEFAULT_BUFFER_SIZE = 1024;

    private byte[] buffer = new byte[DEFAULT_BUFFER_SIZE];
    private InputStream inputStream;
    private int index;
    private int count;

    public BufferedInputStream(InputStream inputStream) {
        this.inputStream = inputStream;
    }

    @Override
    public int read() throws IOException {
        if (index == count) {
            count = inputStream.read(buffer);
            index = 0;
        }
        if (count == -1) {
            return -1;
        }
        return buffer[index++];
    }

    @Override
    public int read(byte[] b) throws IOException {
        return read(b, 0, b.length);
    }

    private int getBufferSize() throws IOException {
        if (index == count) {
            count = inputStream.read(buffer);
            index = 0;
        }
        return count;
    }

    @Override
    public int read(byte[] array, int offset, int length) throws IOException {
        if (getBufferSize() == -1) {
            return -1;
        }
        int countOfBufferElements = count - index;
        if (length < countOfBufferElements) {
            System.arraycopy(buffer, index, array, offset, length);
            index += length;
            return length;
        } else {
            System.arraycopy(buffer, index, array, offset, countOfBufferElements);
            index += countOfBufferElements;
            return countOfBufferElements;
        }
    }

    @Override
    public void close() throws IOException {
        buffer = null;
        inputStream.close();
    }
}