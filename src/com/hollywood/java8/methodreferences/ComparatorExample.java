package com.hollywood.java8.methodreferences;

/**
 * TODO: https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html
 */
public class ComparatorExample {

    class Person {
        private int height;

        public Person(int height) {
            this.height = height;
        }

        public int getHeight() {
            return height;
        }

        public int compareByAge(Person a, Person b) {
            return new Integer(a.height).compareTo(b.height);
        }
    }

    public static void main(String[] args) {
        Person[] persons = {new Person(), new Person()};


    }


}
