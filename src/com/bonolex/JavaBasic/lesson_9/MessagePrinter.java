package com.bonolex.JavaBasic.lesson_9;

public class MessagePrinter {

    private String message;

    @InjectRandomInt(min = 2, max = 7)
    private int count;

    @InjectRandomInt(max = 7000)
    private int suffix;


    public MessagePrinter(String message) {
        this.message = message;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.out.println(message + suffix);
        }
    }
}

//BufferedInputStream           file [1,2,3,4,5,6,7,8,9]
//read() -> 1
//[5,7,8,9, 5]
//
//read(array byte[6]) -> 2,3,4, 5, 6, 7
//
//for(int i = 0; i < count; i++ ){
//    array[i] = read();
//}