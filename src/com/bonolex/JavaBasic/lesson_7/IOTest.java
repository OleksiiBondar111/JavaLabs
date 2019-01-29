package com.bonolex.JavaBasic.lesson_7;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOTest {
    public static void main(String[] args) {
        System.out.println("start");
        try {
            String name = "C:/Windows/System32";
            fileTest(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("finish");
    }


    static void fileTest(String name) throws IOException {
        if (name == null) {
            throw new FileNotFoundException("name cannot be null");
        }
        File file = new File(name);
//        System.out.println(file.exists());
//        System.out.println(file.getAbsolutePath());
//
//        file.createNewFile();

        if (file.isDirectory()) {
            for (File innerFile : file.listFiles()) {
                String fileType = innerFile.isDirectory() ? "DIR  " : "FILE ";
                System.out.println(fileType + innerFile);
            }
        }

    }
}


//    List list = new ArrayList();
//        list.add("A");
//                list.add("B");
//                list.add("C");
//                list.add("D");
//
//                // fail-fast
//                for (Object o : list) {
//                if(o.equals("B")){
//                list.remove("B");
//                //break;
//                }
//                }
//
//                System.out.println(list);
