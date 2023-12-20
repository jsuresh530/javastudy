package com.java8.strems.java8.week1;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;

class Tester {
    public static void print(String str) {
        System.out.println(str);
    }
}
public class MethodReferenceExample {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList ("h", "jjs", "hello", "jai");

        //Anonymous class
        strings.forEach (new Consumer<String> () {
            @Override
            public void accept(String s) {
                Tester.print (s);
            }
        });

        //Lambda
        strings.forEach (s-> Tester.print (s));
        strings.forEach (System.out::println);

        List<String> integerList = Arrays.asList ("4", "5", "2", "9");

        integerList.stream ().map (new Function<String, Object> () {

            @Override
            public Object apply(String s) {
                return Integer.parseInt (s);
            }
        }).collect (Collectors.toList ());

        //lambda
        List<Integer> collect = integerList.stream ().map (s -> Integer.parseInt (s)).collect (Collectors.toList ());
        List<Integer> collect1 = integerList.stream ().map (Integer::parseInt).collect (Collectors.toList ());
        System.err.println (collect1);
    }
}
