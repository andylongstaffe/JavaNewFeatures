package com.hollywood.java9;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamAPI {

    /**
     * While predicate is true takes, returns elements of stream
     *
     * Note: for unordered collections, results are non-deterministic
     */
    @Test
    public void takeWhile() {
        List<String> alphabets = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i");

        List<String> subset1 = alphabets
                .stream()
                .takeWhile(s -> !s.equals("d"))
                .collect(Collectors.toList());

        Assert.assertEquals(3, subset1.size());
    }

    /**
     * Inverse of takeWhile
     */
    @Test
    public void dropWhile() {
        List<String> alphabets = List.of("a", "b", "c", "d", "e", "f", "g", "h", "i");

        List<String> subset1 = alphabets
                .stream()
                .dropWhile(s -> !s.equals("d"))
                .collect(Collectors.toList());

        Assert.assertEquals(List.of("d", "e", "f", "g", "h", "i"), subset1);
    }

    /**
     * Iterate (first introduced in Java 8)
     */

    @Test
    public void iterateJava8() {
        List<Integer> numbers = Stream.iterate(1, i -> i+1)
                .limit(10)
                .collect(Collectors.toList());
        Assert.assertEquals(10, numbers.size());
    }

    // New limit (hasNext) param, looks a bit too much like a for statement for my liking and think the old way reads better!
    @Test
    public void iterateJava9() {
        List<Integer> numbers = Stream.iterate(1, i -> i <= 10, i -> i+1)
                .collect(Collectors.toList());
        Assert.assertEquals(10, numbers.size());
    }

    /**
     * ofNullable
     */

    // Prev this would have caused a problem but now it will produce an empty stream
    @Test
    public void nullableStream() {
        Assert.assertEquals(1, Stream.ofNullable("1").count());

        Assert.assertEquals(0, Stream.ofNullable(null).count());
    }
}
