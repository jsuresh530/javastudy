package com.java8.strems.udemy;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OptionalExample
{
    public static void main(String[] args) {

        final List<Integer> nums = Arrays.asList (1, 2, 3, 4, 5);
        // we don't want to get null pointer exception
        final Optional<Integer> result = nums.stream ().reduce (Integer::min);
        result.ifPresent (System.out::println);


    }
}
