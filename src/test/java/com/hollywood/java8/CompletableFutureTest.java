package com.hollywood.java8;

import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.CancellationException;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import static org.junit.Assert.assertEquals;

// Extension of Future interface introduced in Java 5
// Part of ConcurrencyApi improvements
// Async postfix will run exec in a different thread (default if no executor is passed is fork/join pool
public class CompletableFutureTest {

    class CompletableFutureInstance {
        public Future<String> calculateAsync() throws InterruptedException {
            CompletableFuture<String> completableFuture = new CompletableFuture<>();

            Executors.newCachedThreadPool().submit(() -> {
                Thread.sleep(500);
                completableFuture.complete("Hello");
                return null;
            });

            return completableFuture;
        }

        // Interrupts dont work with completableFuture's incidentally
        public Future<String> calculateAsyncWithCancellation() throws InterruptedException {
            CompletableFuture<String> completableFuture = new CompletableFuture<>();

            Executors.newCachedThreadPool().submit(() -> {
                Thread.sleep(500);
                completableFuture.cancel(false);
                return null;
            });

            return completableFuture;
        }
    }

    @Test
    public void simpleFuture() throws Exception {
        Future<String> completableFuture = new CompletableFutureInstance().calculateAsync();

        // this immediately blocks and waits for the result
        String result = completableFuture.get();
        assertEquals("Hello", result);
    }

    @Test
    public void instantResult() throws Exception {
        // this will not block, it is a known result
        Future<String> completableFuture = CompletableFuture.completedFuture("Hello");
        
        assertEquals("Hello", completableFuture.get());
    }

    @Test(expected = CancellationException.class)
    public void simpleFutureWithCancel() throws ExecutionException, InterruptedException {
        Future<String> completableFuture = new CompletableFutureInstance().calculateAsyncWithCancellation();
        completableFuture.get();
    }

    @Test
    public void encapsulatedLogic() throws Exception {
        CompletableFuture cf = CompletableFuture.supplyAsync(() -> { return 5;});
        Assert.assertEquals(5, cf.get());
    }

    @Test
    public void chaining() throws Exception {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<String> future = completableFuture
                .thenApply(s -> s + " World");

        assertEquals("Hello World", future.get());
    }

    @Test
    public void runnable() throws Exception {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello");

        CompletableFuture<Void> future = completableFuture
                .thenRun(() -> System.out.println("Computation finished."));

        future.get();
    }

    @Test
    public void moreChaining() throws Exception {
        CompletableFuture<String> completableFuture
                = CompletableFuture.supplyAsync(() -> "Hello")
                .thenCompose(s -> CompletableFuture.supplyAsync(() -> s + " World"));

        assertEquals("Hello World", completableFuture.get());
    }

    // error handling


    @Test
    public void handleExceptionsAsync() throws Exception {
        String name = null;

        // ...

        CompletableFuture<String> completableFuture =  CompletableFuture
                .supplyAsync(() -> {
                    if (name == null) {
                        throw new RuntimeException("Computation error!");
                    }
                    return "Hello, " + name;
                })
                .handle((s, t) -> {
                    if (t != null) {
                        System.out.println("An error occurred dude");
                        t.printStackTrace();
                        return "Hello, Stranger!";
                    }
                    return s;
                });

        assertEquals("Hello, Stranger!", completableFuture.get());
    }

    @Test
    public void traditonalExceptionHandling() {
        String name = null;
        CompletableFuture<String> completableFuture =  CompletableFuture
                .supplyAsync(() -> {
                    if (name == null) {
                        throw new RuntimeException("Computation error!");
                    }
                    return "Hello, " + name;
                });

        // this gives us a more traditional synchronous method of error handling
        completableFuture.completeExceptionally(new RuntimeException("Some error occurred!"));

        try {
            completableFuture.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
