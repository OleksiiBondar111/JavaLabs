package com.bonolex.JavaBasic.lesson_10;

import java.io.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class ReadersWritersTest {
    private static DateTimeFormatter formatter = DateTimeFormatter.ofPattern("[dd/MMM/yyyy:HH:mm:ss");

    public static void main(String[] args) throws IOException {
        // can parse logs only from: http://www.monitorware.com/en/logsamples/apache.php
        String path = "access_log";
        LocalDateTime timeFrom, timeTo;
        timeFrom = LocalDateTime.parse("08/Mar/2004:16:05:49", formatter);
        timeTo = LocalDateTime.parse("09/Mar/2004:15:53:56", formatter);
        readLines(path, timeFrom, timeTo);

    }

    public static List<LogToken> readLines(String path, LocalDateTime timeFrom, LocalDateTime timeTo) throws IOException {
        FileInputStream file = new FileInputStream(path);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(file));
        List<LogToken> result = new ArrayList<>();
        String line;
        while ((line = bufferedReader.readLine()) != null) {
            String split[] = line.split(" ");
            LogToken logToken = new LogToken();
            String time = split[3].replaceAll("\\[", "");
            String http = split[5].replaceAll("\"", "");
            HttpMethod httpMethod;
            try {
                httpMethod = HttpMethod.getByName(http);
            } catch (IllegalArgumentException e) {
                continue;
            }
            String messageText = split[6];
            LocalDateTime localDateTime = LocalDateTime.parse(time, formatter);
            if (localDateTime.compareTo(timeFrom) > 0 && localDateTime.compareTo(timeTo) < 0) {
                logToken.setTime(localDateTime);
                logToken.setMethod(httpMethod);
                logToken.setMessage(messageText);
                result.add(logToken);
            }
        }
        return result;
    }
}
// Writer                    // Reader
// write(int)                // int read() -1, 0-32635
// write(char[])             // int read(char[])