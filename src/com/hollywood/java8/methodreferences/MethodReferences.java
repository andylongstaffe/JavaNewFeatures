package com.hollywood.java8.methodreferences;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

/**
 * Help to point to methods by their names using the :: operator
 *
 * For cases when a lambda just calls an existing function, ie printing something out. In this case just reference that method name.
 *
 * Can point to a static or instance method
 * Arbitrary method within an object (eg a.compareIgnoreCase(b))
 * You can also use ClassName::new as a method ref
 */
public class MethodReferences {

    public static void main(String args[]){
        List names = new ArrayList<String>();

        names.add("Mahesh");
        names.add("Suresh");
        names.add("Ramesh");
        names.add("Naresh");
        names.add("Kalpesh");

        // method ref
        System.out.println("\nUsing a method ref:");
        names.forEach(System.out::println);

        // using a lambda
        System.out.println("\nUsing a lambda:");
        names.forEach((s) -> System.out.println(s));

        System.out.println("\nUsing an Inner class:");
        names.forEach(new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        });


    }

}
