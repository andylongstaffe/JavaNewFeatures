package com.hollywood.java8;

import org.junit.Assert;
import org.junit.Test;

import java.util.function.Function;

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
}
