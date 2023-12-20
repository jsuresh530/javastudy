package com.java8.strems.java8.week1;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

enum Type{
    DEBIT,CREDIT;
}
enum Month{
    JAN,FEB,MAR,APR,MAY;
}
@Data
public class Transaction {
    private int id;
    private Long amount;
    private Type type;
    private Month month;

    public Transaction(int id, Long amount, Type type){
        this.id=id;
        this.amount=amount;
        this.type=type;
    }

    public Transaction(int id, Long amount, Type type, Month month){
        this.id=id;
        this.amount=amount;
        this.type=type;
        this.month =month;
    }


    public static void main(String[] args) {

        List<Transaction> list = new ArrayList<> ();
        list.add (new Transaction (1,1000L,Type.DEBIT));
        list.add (new Transaction (19,600L,Type.CREDIT));
        list.add (new Transaction (33,1000L,Type.CREDIT));

        List<Integer> transactionIds = new ArrayList<> ();

        for (Transaction t : list){
            if(t.getType ()==Type.CREDIT){
                transactionIds.add (t.getId ());
            }
        }
        System.out.println(transactionIds);

        List<Integer> collect = list.stream ().filter ((t) -> {
                    return t.getType () == Type.CREDIT;
                })
                .sorted (Comparator.comparing (Transaction::getAmount).reversed ())
                .map (Transaction::getId).collect (toList ());
        System.out.println(collect);



        list = new ArrayList<> ();
        list.add (new Transaction (1,1000L,Type.DEBIT, Month.JAN));
        list.add (new Transaction (19,600L,Type.CREDIT, Month.APR));
        list.add (new Transaction (33,1000L,Type.CREDIT, Month.FEB));
//summingLong
        //summarizingLong
System.err.println (list.stream ().collect(Collectors.groupingBy (Transaction::getMonth, Collectors.summarizingLong (Transaction::getAmount))));

    }


}
