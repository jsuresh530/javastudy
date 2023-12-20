package com.java8.strems.java8.youtube;

import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        String[] strArray = {"goli","soda","dog","egg"};
        //final Stream<String> inputStream = Arrays.asList (strArray).stream ();

        //inputStream.forEach (System.out::println);
        // Stream already open exception here.
        //long count = inputStream.filter (arr -> arr.equalsIgnoreCase ("dog")).count ();
        //System.out.println (count);

        // Supplier

        final Supplier<Stream<String>> inputStream = () -> Stream.of (strArray);

        inputStream.get ().forEach (System.out::println);

        inputStream.get ().filter (x -> x.equalsIgnoreCase ("egg")).count ();

        //Joiner example
        String input = "Hello there how are you.";
        String[] inputArray = input.split (" ");
        StringJoiner stringJoiner = new StringJoiner ("-","[","]");

        for (String inputStr : inputArray){
            stringJoiner.add (inputStr);
        }
        System.out.println (stringJoiner.toString ());

        List<String> listStr = Arrays.asList ("Hello","suresh","how");
        final String collect = listStr.stream ().collect (Collectors.joining ("-"));

        System.out.println ("collect "+collect);

    }
}
