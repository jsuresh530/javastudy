package com.java8.strems.java8.youtube;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class FindDuplicates {

    public static void main(String[] args) {
        String str = "hello hello";

        // String to stream
        final IntStream chars = str.chars ();
        final List<String> list = Arrays.asList (str);

        final Integer count = list.stream ().map (s -> s.replaceAll ("[^aeiou]", "").length ()).
                reduce (0, Integer::sum);
        System.out.println ("vowels count : "+count);

       long filterCount =  str.chars ().filter ((x) -> {
            return (x == 'a'|| x=='e' || x=='i' || x=='o' || x=='u');
        }).count ();
        System.out.println ("count : "+filterCount);

        //Find duplicates
        final Map<String, Long> collect = str.chars ().
                filter (c -> !Character.isWhitespace (c)).
                mapToObj (x -> (char) x).
                collect (Collectors.groupingBy (Object::toString, Collectors.counting ()));
        collect.forEach ((k,v) -> System.out.println (k+" : "+v));

    }
}
