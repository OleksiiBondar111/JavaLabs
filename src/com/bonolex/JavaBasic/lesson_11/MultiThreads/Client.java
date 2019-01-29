package com.bonolex.JavaBasic.lesson_11.MultiThreads;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * Created by OBondar on 24.01.2019.
 */
public class Client {
    public static void main(String[] args) throws IOException {

        System.out.println("Client is started");

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
