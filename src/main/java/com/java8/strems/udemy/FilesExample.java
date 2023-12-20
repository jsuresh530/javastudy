package com.java8.strems.udemy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilesExample {

    public static void main(String[] args) throws IOException {

        String path = "src/suresh.txt";

        final Stream<String> lines = Files.lines (Paths.get (path));
        final List<String> collect = lines.filter (x -> x.startsWith ("s")).collect (Collectors.toList ());

        collect.forEach (System.out::println);

    }
}
