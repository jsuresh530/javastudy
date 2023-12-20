package com.java8.strems.java8.week1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListExample {
    public static void main(String[] args) {

        List<String> list = Arrays.asList ("a", "b", "c");
        String result = list.stream ().map (x -> x.toUpperCase ()).collect (Collectors.joining (","));
        System.err.println ("result : "+result);

        //Lambda expression
        List<String> progra = Arrays.asList ("java", "c", "net");
        progra.forEach (x -> System.out.println (x));

        //Method reference
        progra = Arrays.asList ("java", "c", "net");
        progra.forEach (System.out::println);

       // Both lambda expression or method reference does nothing but just another
        // way call to an existing method. With method reference, it gains better readability.

      // for each example

        Map<String, String> hashMap = new HashMap<> ();
        hashMap.put ("suresh","hockey");
        hashMap.put ("babu","cricket");
        hashMap.put (null,"test");
        hashMap.put ("chalo","janu");

        //hashMap.forEach ((k,v) -> System.out.println(k+" "+v));
        hashMap.forEach ((k,v) -> {
            if(k != null){
                System.err.print (k+" : "+v);
            }
        });



    }
}
