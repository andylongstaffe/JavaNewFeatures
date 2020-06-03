package com.hollywood.java9;

import jdk.incubator.http.HttpClient;
import jdk.incubator.http.HttpRequest;
import jdk.incubator.http.HttpResponse;
import org.junit.Test;
import org.w3c.dom.ls.LSOutput;

import java.net.URI;
import java.nio.file.Paths;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

public class NewHttpClient {

    // Requires JVM flag for extra libs
    // --add-modules=jdk.incubator.httpclient
    // while compiling and running
    // Idea: java compiler in prefs

    // Defaults to HTTP/2 but will fall back to 1.1
    // No timeout by default
    // Also supports async calls via sendAsync which returns a CompletableFuture<HttpResponse>

    @Test
    public void basic() throws Exception {
        HttpClient httpClient = HttpClient.newHttpClient();
        HttpRequest httpRequest = HttpRequest.newBuilder().uri(new URI("http://howtodoinjava.com/")).GET().build();
        HttpResponse<String> httpResponse = httpClient.send(httpRequest, HttpResponse.BodyHandler.asString());
        System.out.println( "output:" + httpResponse.body() );
    }

    @Test
    public void executorForAsyncCalls() throws Exception {
        HttpRequest request = HttpRequest.newBuilder()
                .uri(new URI("https://postman-echo.com/post"))
                .headers("Content-Type", "text/plain;charset=UTF-8")
                .POST(HttpRequest.BodyPublisher.fromString("hiya post body"))
                .build();

        // Ensure on 2 threads are used
        ExecutorService executorService = Executors.newFixedThreadPool(2);

        CompletableFuture<HttpResponse<String>> response1 = HttpClient.newBuilder()
                .executor(executorService)
                .build()
                .sendAsync(request, HttpResponse.BodyHandler.asString());

        response1.get().headers().map().entrySet().forEach(me -> System.out.println(me.getKey() + "-->" + me.getValue()));
        System.out.println("===");
        System.out.println(response1.get().body());
    }
}
