package com.multithreads;

public class IncrementMultiThreads {

    public static int increment1 = 0;
    public  int increment2 = 0;

    public static final Object lock1 = new Object ();
    public static final Object lock2 = new Object ();
    //public static synchronized void increment(){
        //increment++;
    //}

    public static synchronized void increment1(){
        //class level locking
        synchronized (lock1){
            increment1++;
        }
    }

    public void  increment2(){
        synchronized(lock2){
            increment2++;
        }

    }

    public static void doWork(){
        Runnable run1 = () ->{
            for (int i = 0; i < 100; i++) {
                increment1();
            }

            System.err.println ("Thread1 value : "+increment1);
        };

        IncrementMultiThreads incrementMultiThreads = new IncrementMultiThreads ();
        Runnable run2 = () -> {
            for (int i = 0; i < 100; i++) {
                incrementMultiThreads.increment2();
            }
            System.err.println ("Thread2 value : "+incrementMultiThreads.increment2);
        };

        Thread t1 = new Thread (run1);
        t1.start ();

        Thread t2 = new Thread (run2);
        t2.start ();


        try {
            t1.join ();
            t2.join ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }

    }
    public static void main(String[] args) {
        doWork ();
    }
}
