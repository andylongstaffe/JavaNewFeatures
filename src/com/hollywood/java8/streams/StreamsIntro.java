package com.hollywood.java8.streams;

import java.util.Arrays;
import java.util.List;
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
 * https://www.tutorialspoint.com/java8/java8_streams.htm
 * https://zeroturnaround.com/rebellabs/java-8-streams-cheat-sheet/
 * https://www.mkyong.com/java8/java-8-streams-filter-examples/
 * http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 */
public class StreamsIntro {

    public static void main(String[] args) {
        // filter items from a list
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());
        System.out.println(filtered);



    }
}
