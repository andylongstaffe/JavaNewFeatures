package com.hollywood.java8;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {

    @Test
    public void flatMap() {
        List<List<String>> nl = Arrays.asList(
                Arrays.asList("a"),
                Arrays.asList("b"));

        Assert.assertEquals(Arrays.asList("A", "B"), nl.stream()
                .flatMap(Collection::stream)
                .map(String::toUpperCase)
                .collect(Collectors.toList()));
    }
}
