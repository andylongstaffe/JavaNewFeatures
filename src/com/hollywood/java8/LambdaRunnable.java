package com.hollywood.java8;

/**
 * Created by andrewlongstaffe on 09/02/2017.
 */
public class LambdaRunnable {

    /**
     * Runnable is now a functional interface
     */
    public static void main(String[] args) {

        // old way
        Runnable oldWay = new Runnable() {
            @Override
            public void run() {
                System.out.println("oldWay");
            }
        };
        oldWay.run();

        // New way as expression
        Runnable nonCapturingLambda = () -> System.out.println("NonCapturingLambda");
        nonCapturingLambda.run();

        // with brackets (code block)
        Runnable nonCapturingLambdaWithBrackets = () -> {
            System.out.println("NonCapturingLambdaWithBrackets");
        };
        nonCapturingLambdaWithBrackets.run();

    }

}
