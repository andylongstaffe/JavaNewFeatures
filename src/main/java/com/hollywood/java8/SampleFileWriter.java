package com.hollywood.java8;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SampleFileWriter {

    public static void main(String[] args) throws IOException  {
        Path path = Paths.get("./testoutput.txt");

        try (BufferedWriter writer = Files.newBufferedWriter(path)) {
            writer.write("Hello, world!!!");
        }
    }

}
