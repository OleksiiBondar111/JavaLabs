package com.bonolex.JavaBasic.lesson_8;

import java.io.IOException;
import java.io.OutputStream;


// decorator
public class BufferedOutputStream extends OutputStream {
    private OutputStream outputStream;
    private byte[] buffer = new byte[1024];
    private int index;
    private int count;

    public BufferedOutputStream(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    @Override
    public void write(int b) throws IOException {
        if (index == buffer.length) {
            flush();
        }
        buffer[index] = (byte) b;
        index++;
    }

    // 8192
    // write byte[] 128
    @Override
    public void write(byte[] b) throws IOException {
        // TODO
        write(b, 0, b.length);
    }

    @Override
    public void write(byte[] b, int off, int len) throws IOException {
        // TODO
        if (buffer.length - count > len) {
            System.arraycopy(b, off, buffer, count, len);
        } else {
            flush();
            outputStream.write(b, off, len);
        }
    }

    @Override
    public void flush() throws IOException {
        outputStream.write(buffer, 0, index);
        index = 0;
    }

    @Override
    public void close() throws IOException {
        flush();
        outputStream.close();
    }
}