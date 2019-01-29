package com.bonolex.JavaBasic.lesson_11.MultiThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by OBondar on 25.01.2019.
 */
public class Server implements Runnable {
    Socket clientSocket;

    Server(Socket clientSocket) {
        this.clientSocket = clientSocket;
    }

    public static void main(String[] args) throws IOException {

       ServerSocket serverSocket = new ServerSocket(3000);
        System.out.println("Server is started");

        while (true) {
            Socket socket = serverSocket.accept();
            System.out.println("Connected");
            new Thread(new Server(socket)).start();
        }

    }

    @Override
    public void run() {

        BufferedReader in = null;
        try {
            in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
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
            clientSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}