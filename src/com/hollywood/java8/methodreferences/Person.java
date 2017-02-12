package com.hollywood.java8.methodreferences;

/**
 * Created by andylongstaffe on 09/02/2017.
 */
public
class Person {
    private int height;

    public Person(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public static int compareByAge(Person a, Person b) {
        return new Integer(a.height).compareTo(b.height);
    }

    public String toString() {
        return "Person height=" + height;
    }
}