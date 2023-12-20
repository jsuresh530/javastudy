package com.multithreads.concurrent.collection;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

class FirstMapExample implements Runnable{
    private ConcurrentMap<String, Integer> map;

    public FirstMapExample(ConcurrentMap<String, Integer> chm){
        this.map=chm;
    }
    @Override
    public void run() {
        map.put ("A",11);
        try {
            Thread.sleep (1000);
            map.put ("C",33);
            Thread.sleep (5000);
            map.put ("K",34);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }

    }
}
class SecondMapExample implements Runnable{

    private ConcurrentMap<String,Integer> map;

    public SecondMapExample(ConcurrentMap<String, Integer> chm){
        this.map=chm;
    }
    @Override
    public void run() {
        try {
            Thread.sleep (5000);
            System.out.println (map.get ("A"));
            Thread.sleep (2000);
            System.out.println (map.get ("K"));
            System.out.println (map.get ("C"));

        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }
}

public class ConcurrentMapExample {
    public static void main(String[] args) {
        ConcurrentMap<String,Integer> concurrentMap = new ConcurrentHashMap<> ();
        FirstMapExample firstMapExample = new FirstMapExample (concurrentMap);
        SecondMapExample secondMapExample = new SecondMapExample (concurrentMap);

        new Thread (firstMapExample).start ();
        new Thread (secondMapExample).start ();
    }
}
