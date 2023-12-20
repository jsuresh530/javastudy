package com.multithreads.concurrent.collection;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

class WriteTask implements Runnable {

    private List<Integer> list;
    private Random random;

    public WriteTask(List<Integer> arrayList) {
        this.list = arrayList;
        this.random = new Random ();
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep (50);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            list.set (random.nextInt (list.size ()), random.nextInt (7));
        }
    }
}

class ReadTask implements Runnable {
    private List<Integer> list;

    public ReadTask(List<Integer> integers) {
        this.list = integers;
    }

    @Override
    public void run() {
        while (true){
            try {
                Thread.sleep (60);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }

            System.err.println (list);
        }
    }
}

public class ConcurrentArrayExample {
    private List<Integer> list;

    public ConcurrentArrayExample() {
        this.list = new CopyOnWriteArrayList<> ();
        this.list.addAll (Arrays.asList (0, 0, 0, 0, 0, 0, 0));
    }

    public void stimulate(){
        Thread t1 =new Thread (new WriteTask (list));
        Thread t2 =new Thread (new WriteTask (list));
        Thread t3 =new Thread (new WriteTask (list));
        Thread t4 = new Thread (new ReadTask (list));

        t1.start ();
        t2.start ();
        t3.start ();
        t4.start ();
    }
    public static void main(String[] args) {

new ConcurrentArrayExample ().stimulate ();

    }

}
