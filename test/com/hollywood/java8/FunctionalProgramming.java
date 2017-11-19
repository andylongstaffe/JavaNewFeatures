package com.hollywood.java8;

import com.hollywood.fixtures.Item;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by andylongstaffe on 19/11/2017.
 */
public class FunctionalProgramming {

    @Test
    public void intro() throws Exception {
        // Apply a function
        Function<Integer, Integer> add5 = i -> i + 5;
        Assert.assertEquals(new Integer(25), add5.apply(20));

        // Apply another function after the first
        Function<Integer, Integer> add10 = i -> i + 10;
        Assert.assertEquals(new Integer(35), add5.andThen(add10).apply(20));

        // creating a named function first
        Function<Integer, Integer> add15 = add5.andThen(add10);
        Assert.assertEquals(new Integer(35), add15.apply(20));

        // Perform inner function first
        Function<Integer, Integer> add15InDifferentOrder = add5.compose(add10);
        Assert.assertEquals(new Integer(35), add15InDifferentOrder.apply(20));
    }

    @Test
    public void filterItemsInList() throws Exception {
        List<Item> items = Arrays.asList(
                new Item("car", 10000),
                new Item("chocolate", 1),
                new Item("phone", 400),
                new Item("jacket", 100),
                new Item("alex", 50),
                new Item("house", 100000)
        );

        Stream<Item> streamItems = items.stream().filter(i -> i.getPrice() < 1000);
        List filteredItems = streamItems.collect(Collectors.toList());
        System.out.println(filteredItems);

        Assert.assertEquals(4, filteredItems.size());
    }
}
