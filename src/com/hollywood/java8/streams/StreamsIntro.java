package com.hollywood.java8.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

/**
 * Streams allow processing of collections etc to be more DECLARATIVE (the what rather than the how)
 * Eliminate need to write loops and checks etc
 *
 * A stream is a sequence of objects, from a source, that allows aggregate operations
 *
 * Operations like filter, map, find, reduce, etc.
 *
 * Form a pipeline which normally has a collector at the end to terminate it
 *
 * 1. forEach - takes a Consumer<T>, Consumer is essential a functional interface with one method accept() which performs given function on arg
 *
 * https://www.tutorialspoint.com/java8/java8_streams.htm
 * https://zeroturnaround.com/rebellabs/java-8-streams-cheat-sheet/
 * https://www.mkyong.com/java8/java-8-streams-filter-examples/
 * http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 */
public class StreamsIntro {

    public static void main(String[] args) {

        StreamsIntro s = new StreamsIntro();

        // filter items from a list
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);

        // forEach
        List<String> strings2 = Arrays.asList("abc", "jkl");
        strings2.forEach(string -> System.out.println(string));

        // map
        List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
        System.out.println(numbers.stream().map(i -> i*i).collect(Collectors.toList()));
        // pipe through distinct too
        System.out.println(numbers.stream().map(i -> i*i).distinct().collect(Collectors.toList()));

        // filter - filter out certain elements
        // demo'ed under MethodReferences

        // limit
        System.out.println("limit");
        new Random().ints().limit(10).forEach(i -> System.out.print(Integer.toString(i) + ' '));
        System.out.println();

        // sorted
        System.out.println("sorted");
        new Random().ints().limit(10).sorted().forEach(i -> System.out.print(Integer.toString(i) + ' '));
        System.out.println();

    }
}