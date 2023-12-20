package com.multithreads;

class Runnable1 implements Runnable {

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {

            try {
                Thread.sleep (10);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
            System.err.println ("Runnable 1 : "+i);
        }
    }
}

class Runnable2 implements Runnable {

    @Override
    public synchronized void run() {
        for (int i = 0; i < 10; i++) {
            System.err.println ("Runnable 2 :"+i);
        }
    }
}
public class RunnableExample {
    public static void main(String[] args) {

        Thread t1 =new Thread (new Runnable1 ());
        Thread t2 = new Thread (new Runnable2 ());
        t1.start ();
        // with synchronized it allow access to only threda1 first
        t2.start ();

        try {
            t1.join ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        System.err.println ("Done with execution of the threads.");
    }
}
