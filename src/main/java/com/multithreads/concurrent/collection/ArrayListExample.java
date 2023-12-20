package com.multithreads.concurrent.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ArrayListExample {

    public static void main(String[] args) {
        //List<Integer> list = new ArrayList<> ();
        // add, remove methods are synchronized.
        //intrinsic locks are not that effiecient, because threads have to wait for each other
        //when we want to exceute independent methods.
        //concurrent collections
        List<Integer> list = Collections.synchronizedList (new ArrayList<> ());
        Runnable r1 = () -> {
            for (int i = 0; i < 1000; i++) {
                list.add (i);
            }
        };

        Runnable R2 = () -> {
            for (int i = 0; i < 1000; i++) {
                list.add (i);
            }
        };

        Thread t1 = new Thread (r1);
        Thread t2 = new Thread (R2);

        t1.start ();
        t2.start ();

        try {
            t1.join ();
            t2.join ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }

        System.err.print ("Size of array : "+list.size ());

    }

}
