package com.hollywood.java8;

import org.junit.Test;

import java.util.Arrays;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class StringToArrayExamples {

    // String.join - takes an array or list (Java 8 feature)
    @Test
    public void stringJoin() {
        String[] sampleArray = { "hello", "there", "andy" };
        System.out.println("joined: " + String.join(" ", sampleArray));
    }

    @Test
    public void stringJoiner() {
        StringJoiner joiner = new StringJoiner(", ", "[", "]");
        joiner.add("hello");
        joiner.add("there");
        joiner.add("andy");

        System.out.println("joined: " + joiner.toString());
    }

    @Test
    public void stringJoinerUsingCollector() {
        String[] sampleArray = { "hello", "there", "andy" };
        String joined = Arrays.stream(sampleArray)
                                .collect(Collectors.joining(", ", "[", "]"));
        System.out.println("joined: " + joined);
    }
}
