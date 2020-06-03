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
}
