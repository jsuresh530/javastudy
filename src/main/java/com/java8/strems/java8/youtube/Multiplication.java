package com.java8.strems.java8.youtube;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Multiplication {
    public static void main(String[] args) {
        Integer[] integers = {1,2,3,4,5};
        final List<Integer> list = Arrays.asList (integers);
        final Optional<Integer> output = list.stream ().reduce ((a, b) -> a * b);

        if(output.isPresent ()){
            System.out.println (output.get ());
        }
        Integer result = 1;
        for (Integer integ: list){
            result *= integ;
        }

        System.out.println ("result "+result);
    }
}
