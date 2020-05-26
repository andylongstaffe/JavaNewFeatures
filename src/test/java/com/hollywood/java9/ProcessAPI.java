package com.hollywood.java9;

import org.junit.Test;

import java.util.stream.Collectors;

public class ProcessAPI {

    @Test
    public void retrieveCurrentProcessPID() {
        // no standard way of doing this prev
        long pid = ProcessHandle.current().pid();
        System.out.println(pid);
    }

    @Test
    public void processInfo() {
        ProcessHandle.Info info = ProcessHandle.current().info();
        System.out.println("command: " + info.command());
        System.out.println("args: " + String.join(" ", info.arguments().orElse(new String[0])));
    }
}
