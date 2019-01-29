package com.bonolex.JavaBasic.lesson_7;

import java.io.*;

public class FileManager {
    // public static int countFiles(String path) - принимает путь к папке,
    // возвращает количество файлов в папке и всех подпапках по пути
    public static int countFiles(String path) throws FileNotFoundException {
        File file = new File(path);
        int fileCount = 0;
        if (file == null) {
            throw new FileNotFoundException("name cannot be null");
        }

        for (File innerFile : file.listFiles()) {
            if (innerFile.isFile()) {
                fileCount++;
            } else {
                fileCount += countFiles(innerFile.getPath());
            }
        }
        return fileCount;
    }

    // public static int countDirs(String path) - принимает путь к папке,
    // возвращает количество папок в папке и всех подпапках по пути
    public static int countDirs(String path) throws FileNotFoundException {
        File file = new File(path);
        int dirCount = 0;
        if (file == null) {
            throw new FileNotFoundException("name cannot be null");
        }

        for (File innerFile : file.listFiles()) {
            if (innerFile.isDirectory()) {
                dirCount++;
                dirCount += countDirs(innerFile.getPath());
            }
        }
        return dirCount;
    }

    //- метод по копированию папок и файлов.
    // Параметр from - путь к файлу или папке, параметр to - путь к папке куда будет производиться копирование.
    public static void copy(String from, String to) {
        final File srcFile = new File(from);
        final File dstFile = new File(to);
        if (srcFile.exists() && srcFile.isDirectory() && !dstFile.exists()) {
            dstFile.mkdir();
            File nextSrcFile;
            String nextSrcFilename, nextDstFilename;
            for (String filename : srcFile.list()) {
                nextSrcFilename = srcFile.getAbsolutePath()
                        + File.separator + filename;
                nextDstFilename = dstFile.getAbsolutePath()
                        + File.separator + filename;
                nextSrcFile = new File(nextSrcFilename);
                if (nextSrcFile.isDirectory()) {
                    copy(nextSrcFilename, nextDstFilename);
                } else {
                    copyFile(nextSrcFilename, nextDstFilename);
                }
            }

        }
    }

    public static void copyFile(String from, String to) {
        final File srcFile = new File(from);
        final File dstFile = new File(to);
        if (srcFile.exists() && srcFile.isFile() && !dstFile.exists()) {
            try (InputStream in = new FileInputStream(srcFile);
                 OutputStream out = new FileOutputStream(dstFile)) {
                byte[] buffer = new byte[10];
                int bytes;
                while ((bytes = in.read(buffer)) > 0) {
                    out.write(buffer, 0, bytes);
                }
            } catch (FileNotFoundException ex) {

            } catch (IOException ex) {

            }
        }
    }

    // - метод по перемещению папок и файлов.
    //    Параметр from - путь к файлу или папке, параметр to - путь к папке куда будет производиться копирование.
    public static void move(String from, String to) {
        final File srcFile = new File(from);
        boolean isCopied = false;
        if (!isCopied) {
            copy(from, to);
            isCopied = true;
        }
        if (srcFile.isDirectory()) {
            for (File innerFile : srcFile.listFiles()) {
                deleteFile(new File(innerFile.getAbsolutePath()));
            }
        }
        srcFile.delete();
    }

    private static void deleteFile(File file) {
        if (file.isDirectory()) {
            for (File innerFile : file.listFiles()) {
              deleteFile(innerFile);
            }
        }
        file.delete();
    }

}