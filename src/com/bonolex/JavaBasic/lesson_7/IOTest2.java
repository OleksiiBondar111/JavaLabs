package com.bonolex.JavaBasic.lesson_7;

import java.io.*;
import java.util.Arrays;

public class IOTest2 {
    public static void main(String[] args) throws IOException {
        String path = "test.log";
//        InputStream inputStream = new FileInputStream(path);
//        OutputStream outputStream = null;
//        int value;
//        while ((value = inputStream.read()) != -1) {
//            outputStream.write(value);
//        }
        // 104 101 108 108 111 33
//        byte[] buffer = new byte[4];
//        int count = inputStream.read(buffer);//
//        System.out.println(count); // 4
//        // 104 101 108 108
//        System.out.println(Arrays.toString(buffer));
//
//        count = inputStream.read(buffer);//
//        // 2
//        System.out.println(count);
//        // 111 33 108 108
//        System.out.println(Arrays.toString(buffer));
//
//        count = inputStream.read(buffer);//
//        // -1
//        System.out.println(count);
//        // 111 33 108 108
//        System.out.println(Arrays.toString(buffer));
        String str = readFromFile("test.log");
        System.out.println(str);

        writeToFile("test_copy.log", str);
    }

    private static String readFromFile(String path) throws IOException {
        InputStream inputStream = new FileInputStream(path);
        //hello!
        byte[] buffer = new byte[4];
        StringBuilder stringBuilder = new StringBuilder();
        int count;
        while ((count = inputStream.read(buffer)) != -1) {
            System.out.println(Arrays.toString(buffer));
            String value = new String(buffer, 0, count);
            stringBuilder.append(value);
        }

        return stringBuilder.toString();
    }

    private static void writeToFile(String path, String content) throws IOException {
        OutputStream outputStream = new FileOutputStream(path);

        byte[] array = content.getBytes();
        for (byte value : array) {
            outputStream.write(value);
        }
    }
}

// InputStream -> FileInputStream(path)

// int read(); // 0..255, (byte)125 -> 125, (byte)128 -> -128,
// (byte)130 -> -126
// -1 -> end of file

// int read(byte[] array)

// OutputStream

// void write (int value)
// void write (byte[] array)