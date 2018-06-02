package com.hollywood.java8;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Predicate;

/**
 * Created by andylongstaffe on 19/11/2017.
 */
public class MethodReferences {

    @Test
    public void example() {
        // Normal lambda expression
        Consumer<String> c1 = m -> System.out.println("Say " + m);
        c1.accept("Hiya");

        // Using a method reference for short hand
        Consumer<String> c2 = System.out::println;
        c2.accept("Hiya");

        // Point to a method rather than a variable
    }
}
