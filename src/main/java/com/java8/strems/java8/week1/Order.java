package com.java8.strems.java8.week1;

import java.util.Objects;
import java.util.stream.Stream;

public class Order {

    public static void main(String[] args) {
        Stream.of ("MON","Tue","Thrus","Frid").
                map (s -> { return  s.toUpperCase();}).
                filter (s -> {
                    Objects.nonNull (s);
                    return s.startsWith ("T");
                }).
                forEach (s->System.err.println ("in for each :"+s));

        Stream.of ("MON","Tue","Thrus","Frid").
                filter (s -> { return s.startsWith ("M");}).
                map (s -> { return s.toLowerCase (); }).
                forEach (System.err::println);
    }
}
