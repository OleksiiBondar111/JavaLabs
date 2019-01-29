package com.bonolex.JavaBasic.lesson_10.serverHomeTask;

import java.io.*;
import java.net.*;

public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(3000);
        System.out.println("Start");
        Socket socket = serverSocket.accept();

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        String input;
        while ((input = in.readLine()) != null) {
            if (input.equalsIgnoreCase("exit")) {
                break;
            }
            out.println("echo: " + input);
            System.out.println(input);
        }
        out.close();
        in.close();
        socket.close();
        serverSocket.close();
    }
}