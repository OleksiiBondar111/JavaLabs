package com.bonolex.JavaBasic.lesson_10.server;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1", 3000);
        InputStream inputStream = socket.getInputStream();

        byte[] buffer = new byte[120];
        while (true) {
            int count = inputStream.read(buffer);
            System.out.println(new String(buffer, 0, count));
        }
    }
}