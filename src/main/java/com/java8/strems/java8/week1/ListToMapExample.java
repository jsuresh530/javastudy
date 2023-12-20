package com.java8.strems.java8.week1;

import lombok.Data;

import java.util.*;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toMap;

@Data
class Student1 {
    private int id;
    private String name;
    private String location;

    public Student1(int i, String n, String l){
        this.id=i;
        this.name=n;
        this.location=l;
    }
}
public class ListToMapExample {
    public static void main(String[] args) {

        try (Stream<String> stream = Stream.of ("c", "Z", "s", "F", "D")) {
            //forEach
            stream.parallel ().forEachOrdered (x -> System.err.println (x));
        }

        List<Student1> studentList = new ArrayList<> ();
        studentList.add (new Student1 (5, "suresh", "hyd"));
        studentList.add (new Student1 (3, "balu", "kochi"));
        studentList.add (new Student1 (9, "balu", "kochi"));

        studentList.forEach (System.out::println);
        studentList.stream ().filter (Objects::nonNull).forEach (System.out::println);
        //method reference
        Map<Integer, String> collectTest = studentList.stream ().collect (toMap (Student1::getId, Student1::getLocation));
        System.out.println ("collect : "+collectTest);

        //lambda expression
        //Handling duplicate key with hashmap (x,y) - >x replace old value with new value.
        Map<String, String> collect1 = studentList.stream ().collect (toMap (x -> x.getLocation (), x -> x.getName ()
        , (x, y) -> x));
        System.err.println ("collect1 : "+collect1);

        //Sort the keys using the values.
        LinkedHashMap<Integer, String> collect2 = studentList.stream ().sorted (Comparator.comparing (Student1::getId).reversed ())
                .collect (toMap (Student1::getId, Student1::getName, (oldValue, newValue) -> newValue, LinkedHashMap::new));

        System.err.print ("collect2 "+collect2);
    }
}
