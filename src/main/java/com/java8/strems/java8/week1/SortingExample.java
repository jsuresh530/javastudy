package com.java8.strems.java8.week1;

import lombok.Data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Data
class Developer {
    int age;
    String location;

    Developer(int ae, String l){
        age = ae;
        location = l;
    }
}
public class SortingExample {
    public static void main(String[] args) {
        List<Developer> developers = getDevelopers ();


        //before java 8
        Collections.sort (developers, new Comparator<Developer> () {

            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getLocation ().compareTo (o2.getLocation ());
            }
        });
        // sort lambda
        developers.sort (new Comparator<Developer> () {
            @Override
            public int compare(Developer o1, Developer o2) {
                return o1.getAge ()-o2.getAge ();
            }
        });

       // developers.sort ((Developer d1, Developer d2 ) -> d1.getAge ()-d2.getAge ());
        developers.sort (( d1, d2 ) -> d1.getLocation ().compareTo (d2.getLocation ()));
        developers.forEach (System.out::println);

        Comparator<Developer> locationComparator = ( c1, c2 ) -> c1.getLocation ().compareTo (c2.getLocation ());
        developers.sort (locationComparator.reversed ());
    }


    public static List<Developer> getDevelopers(){
        List<Developer> developers = new ArrayList<> ();

        developers.add (new Developer (23,"susu"));
        developers.add (new Developer (12,"tester"));
        developers.add (new Developer (55,"hello"));

        return developers;
    }
}
