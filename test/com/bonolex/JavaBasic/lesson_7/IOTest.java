package com.bonolex.JavaBasic.lesson_7;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class IOTest {
    @Test
    public void shouldCountFiles() throws FileNotFoundException {
        Assert.assertEquals(20, FileManager.countFiles("H:/IdeaProjects/src/com/bonolex/JavaBasic"));
    }

    @Test
    public void shouldCountDirs() throws FileNotFoundException {
        Assert.assertEquals(4, FileManager.countDirs("H:/IdeaProjects/src/com/bonolex/JavaBasic"));
    }

    @Test
    public void shouldCopyFiles() throws IOException {
        String from = "H:/IdeaProjects/from";
        String to = "H:/IdeaProjects/to";
        FileManager.copy(from, to);
        File newFile = new File(to);
        Assert.assertTrue(newFile.exists());
    }
    @Test
    public void shouldMoveFiles() throws IOException {
        String from = "H:/IdeaProjects/from";
        String to = "H:/IdeaProjects/to";
        FileManager.move(from, to);
        File src = new File(from);
        Assert.assertFalse(src.exists());
    }

    @Test
    public void shouldAnalyzeFile() throws IOException {
        String from = "H:/IdeaProjects/from/test.txt";
        String word ="will";
        String args[] ={from,word};
        FileAnalyzer.main(args);

    }


}
