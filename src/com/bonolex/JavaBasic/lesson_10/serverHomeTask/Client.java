package com.bonolex.JavaBasic.lesson_10.serverHomeTask;

import com.bonolex.JavaBasic.lesson_10.HttpMethod;

import java.io.*;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {

        System.out.println("Start");

        Socket socket = new Socket("localhost", 3000);
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
        BufferedReader inputLine = new BufferedReader(new InputStreamReader(System.in));

        String fromUser;
        String fromServer;

        while ((fromUser = inputLine.readLine()) != null) {
            out.println(fromUser);
            fromServer = in.readLine();
            System.out.println(fromServer);
            if (fromUser.equalsIgnoreCase("exit")) {
                break;
            }
        }
        out.close();
        in.close();
        inputLine.close();
        socket.close();
    }
}