package com.hollywood.java8.methodreferences;

import java.util.Arrays;
import java.util.Comparator;

/**
 * TODO: https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
 *
 * Method reference examples while using a Comparator
 *
 * Arrays.toString - to reliably print out array
 */
public class ComparatorExample {

    static class PersonHeightComparator implements Comparator<Person> {
        public int compare(Person a, Person b) {
            return new Integer(a.getHeight()).compareTo(b.getHeight());
        }
    }

    public static void main(String[] args) {
        Person[] persons = {new Person(20), new Person(10), new Person(15)};
        System.out.println("Before:" + Arrays.toString(persons));


        Arrays.sort(persons, new PersonHeightComparator());
        System.out.println("Using Comparator class" + Arrays.toString(persons));

        Arrays.sort(persons, (a,b) -> new Integer(a.getHeight()).compareTo(b.getHeight()));
        System.out.println("Using a lambda" + Arrays.toString(persons));

        Arrays.sort(persons, (a,b) -> Person.compareByAge(a,b));
        System.out.println("Using a method" + Arrays.toString(persons));

        Arrays.sort(persons, Person::compareByAge);
        System.out.println("Using a method reference" + Arrays.toString(persons));

        // (a,b) -> Person.compareByAge(a,b) is equivalent to Person::compareByAge

    }


}
