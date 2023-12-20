package com.apna;

import java.util.Arrays;

public class ListSplit {

    public static void main(String[] args) {

        String s = "77S NUMBER 1 23 23 5";

        final int sum = Arrays.stream (s.split (" ")).filter (k -> k.matches ("\\d+")).mapToInt ( Integer::valueOf).sum ();

        System.err.println ("sum : "+sum);



    }
}
