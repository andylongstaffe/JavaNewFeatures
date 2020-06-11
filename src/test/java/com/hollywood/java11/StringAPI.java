package com.hollywood.java11;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.net.URI;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

public class StringAPI {

    @Test
    public void repeat() {
        Assert.assertEquals("hey ya! hey ya! hey ya! ", "hey ya! ".repeat(3));
    }

    @Test
    public void strip() {
        String untidy = "     hey ya   ";
        Assert.assertEquals("hey ya", untidy.strip());
        Assert.assertEquals("hey ya", untidy.trim());

        Assert.assertEquals("hey ya   ", untidy.stripLeading());
        Assert.assertEquals("     hey ya", untidy.stripTrailing());
    }

    @Test
    public void isBlank() {
        Assert.assertTrue("".isBlank());
        Assert.assertFalse("something".isBlank());

        // just spaces
        Assert.assertTrue("    ".isBlank());
        Assert.assertFalse("    ".isEmpty());
    }

    @Test
    public void lines() {
        String testString = "hello\nworld\nis\nexecuted";

        List<String> lines = new ArrayList<>();

        testString.lines().forEach(line -> lines.add(line));

        Assert.assertEquals(List.of("hello", "world", "is", "executed"), lines);
    }

    @Test
    public void toArray() {
        List<String> names = new ArrayList<>();
        names.add("alex");
        names.add("brian");
        names.add("charles");

        String[] namesArr1 = names.toArray(new String[names.size()]);       //Before Java 11

        String[] namesArr2 = names.toArray(String[]::new);
    }

}
