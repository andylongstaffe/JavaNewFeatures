package com.hollywood.java8;

import com.hollywood.fixtures.Item;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by andylongstaffe on 19/11/2017.
 */
public class FunctionalProgramming {

    private List<Item> items;
    private final double DELTA = 0.0;

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

    @Before
    public void before() throws Exception {
        items = Arrays.asList(
                new Item("car", 10000),
                new Item("chocolate", 1),
                new Item("phone", 400),
                new Item("jacket", 100),
                new Item("alexa", 50),
                new Item("house", 100000)
        );
    }

    @Test
    public void filterItemsInList() throws Exception {
        Stream<Item> streamItems = items.stream().filter(i -> i.getPrice() < 1000);
        List filteredItems = streamItems.collect(Collectors.toList());
        System.out.println(filteredItems);

        Assert.assertEquals(4, filteredItems.size());
    }

    @Test
    public void combiningFilters() throws Exception {
        Predicate<Item> greaterThan50 = i -> i.getPrice() > 50;
        Predicate<Item> lowerThan1000 = i -> i.getPrice() < 1000;
        List filteredItems = items.stream().filter(greaterThan50.and(lowerThan1000)).collect(Collectors.toList());
        Assert.assertEquals(2, filteredItems.size());
    }

    private Item getItem(List<Item> items, String name) {
        return items.stream().filter(i -> i.getName().equals(name)).findFirst().get();
    }

    @Test
    public void addTaxUsingMap() throws Exception {
        final double RATE_OF_TAX = 1.20;
        Function<Item, Item> addTax = i -> {
            i.setPrice(i.getPrice() * RATE_OF_TAX);
            return i;
        };

        // arguably better to use immutable objects and return a list of new objects
        items.stream().map(addTax).collect(Collectors.toList());
        Assert.assertEquals(12000.0, getItem(items, "car").getPrice(), DELTA);
    }
}
