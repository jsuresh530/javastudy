package com.java8.strems.udemy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MapVsFlatMap {

    public static void main(String[] args) {
        final List<String> words = Arrays.asList ("Adam", "anu", "Daniel", "shee");

        //map and flatmap are similar to selecting a colu in SQl , no of chars in every word.
        final List<Integer> lengths = words.stream ().map (String::length).collect (Collectors.toList ());
        lengths.stream ().forEach (System.out::println);

        //create alist containg the square values

        final List<Integer> nums = Arrays.asList (1, 2, 3, 4);

        nums.stream ().map (x -> x * x).collect (Collectors.toList ())
                .forEach (System.out::println);

        String[] array = {"hello", "shell"};
        final List<String> unique = Arrays.stream (array).map (w -> w.split (""))
                .flatMap (Arrays::stream).distinct ().collect (Collectors.toList ());
        unique.forEach (System.out::println);


        List<Integer> nums1 = Arrays.asList (1, 2, 3);
        List<Integer> nums2 = Arrays.asList (4, 5);
//So the result in the case should be: (1,4), (1,5), (2,4),(2,5),(3,4),(3,5)
        List<List<Integer>> pairs = nums1.stream ()
                .flatMap (i -> nums2.stream ().map (j -> Arrays.asList (i, j)))
                .collect (Collectors.toList ());

        System.out.println (Arrays.toString (pairs.toArray ()));


    }
}
