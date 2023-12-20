package com.java8.strems.udemy;

import java.util.stream.LongStream;

public class Parallelization {

    public static void main(String[] args) {

        long start = System.currentTimeMillis ();
        System.out.println (sum (1000));
        System.out.println ("time taken "+(System.currentTimeMillis () - start));

        start = System.currentTimeMillis ();
        System.out.println (parallelSum (1000));
        System.out.println ("time taken for parallel "+(System.currentTimeMillis () - start));

    }

    private static long sum(long n){
        return LongStream.rangeClosed (1, n).reduce (0L, Long::sum);
    }

    private static long parallelSum(long n){
        return LongStream.rangeClosed (1, n).parallel ().reduce (0L, Long::sum);
    }
}
