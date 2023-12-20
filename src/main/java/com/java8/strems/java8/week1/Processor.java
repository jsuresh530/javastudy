package com.java8.strems.java8.week1;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Data
public class Processor {
    private int id;
    private Long amount;
    private Type type;

    public Processor(int id, Long amount, Type type){
        this.id=id;
        this.amount=amount;
        this.type=type;
    }

    public static void main(String[] args) {

        List<Transaction> list = new ArrayList<> ();
        list.add (new Transaction (3,100L, Type.CREDIT));
        list.add (new Transaction (5,500L, Type.DEBIT));
        list.add (new Transaction (9,800L, Type.CREDIT));


        System.err.println ("Filter example :"+list.stream ().filter ((t) -> { return t.getType () == Type.CREDIT;}).count ());
        System.err.println ("Map Example : ");
        list.stream ().map ((t) -> {return t.getAmount ();}).forEach (s -> System.err.print (s+" , "));
        System.err.println ("chaining example ");
        list.stream ().filter ((t) -> {
            System.out.println (t.getType () == Type.CREDIT);
            return t.getType () == Type.CREDIT;
        }).map ((t) -> {
            System.out.println ("In map amount :");
            return  t.getAmount ();
        }).forEach (s -> System.out.print ("in loop : "+s));

        System.err.print ("chaining concise example : ");

        list.stream ().filter (t ->  t.getType () == Type.CREDIT)
                .map (t -> t.getAmount ())
                .forEach (s -> System.err.print (s));

        System.err.print ("Sorting example ");

        list.stream ().sorted (Comparator.comparing (Transaction::getAmount).reversed ())
                .forEach (System.out::println);
    }
}
