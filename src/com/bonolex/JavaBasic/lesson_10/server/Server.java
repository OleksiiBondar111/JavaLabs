package com.bonolex.JavaBasic.lesson_10.server;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);

        System.out.println("Start");
        Socket socket = serverSocket.accept();
        OutputStream outputStream = socket.getOutputStream();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            String message = scanner.nextLine();
            outputStream.write(message.getBytes());
        }

    }
}