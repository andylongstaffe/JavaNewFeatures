package com.hollywood.java11;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;

public class FilesTest {

    String dir = "/Users/andrewlongstaffe/dev/projects/training/JavaNewFeatures";
    Path path;

    @Before
    public void setUp() throws Exception {
        path = Path.of(dir, "temp.txt");
    }

    @Test
    public void readFile() throws Exception {
        Path returnedFilePath = Files.writeString(path,"Hello World!", StandardOpenOption.CREATE);
        System.out.println("File written to " + returnedFilePath.getFileName().toString());

        String content = Files.readString(Path.of(returnedFilePath.getFileName().toString()), Charset.defaultCharset());

        Assert.assertEquals("Hello World!", content);
    }

    @After
    public void tearDown() throws Exception {
        new File(path.toUri()).delete();
    }
}
