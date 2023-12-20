package com.java8.strems.udemy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamBasics {

    public static void main(String[] args) {
        int[] num = {1,3,2,4,4};

        // ::operator or method reference.
        Arrays.stream (num).forEachOrdered (System.out::println);

        int sum = Arrays.stream (num).sum ();

        IntStream.range (0,5).forEach (x -> System.out.println (x));

        IntStream.range (0,10).filter (x -> x>4).forEach (x -> System.out.println (x+" "));


        String[] names = {"suresh", "babu", "xoxo", "kjh"};

        Stream.of (names).sorted (Comparator.reverseOrder ()).forEach (System.out::println);
        Stream.of (names).filter (x -> x.startsWith ("s")).forEach (System.out::println);

        Arrays.stream(names).sorted ();

    }
}
