package com.bonolex.JavaBasic.lesson_7;

import java.io.*;

public class FileAnalyzer {

    public static void main(String[] args) throws IOException {
        String filePath = args[0];
        String inputWord = args[1];
        //BufferedOutputStream stream =new BufferedOutputStream(new FileInputStream(new File(filePath)));
        InputStream inputStream = new FileInputStream(new File(filePath));
        byte[] buffer = new byte[512];
        int count = 0;
        int wordsCount = 0;
        StringBuilder stringBuilder = new StringBuilder();
        while ((count = inputStream.read(buffer)) != -1) {
            String value = new String(buffer, 0, count);
            stringBuilder.append(value);
        }
        String text = stringBuilder.toString();
        String sentences[] = text.split("\\!|\\?|\\.");
        for (String sentence : sentences) {
            if (sentence.contains(inputWord)) {
                System.out.println(sentence);
                String words[] = sentence.split(" ");
                for (int i = 0; i < words.length; i++) {
                    if (words[i].equals(inputWord)) {
                        wordsCount++;
                    }
                }
            }
        }
        System.out.println("Total count of word '" + inputWord + "' is: " + wordsCount);
        inputStream.close();
    }
}

