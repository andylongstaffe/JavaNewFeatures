package com.hollywood.java9;

import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class ImmutableCollectionsFactoryMethods {

    @Test(expected = UnsupportedOperationException.class)
    public void immutable() {
        List<String> names = List.of("Henry", "Max", "Maud");
        names.add("Bowie");
    }

    @Test
    public void examples() {
        Set.of("Lokesh","Amit", "John");

        Map<String, String> namesMap = Map.ofEntries(
                Map.entry("1", "Lokesh"),
                Map.entry("2", "Amit"),
                Map.entry("3", "Brian"));
    }


}
