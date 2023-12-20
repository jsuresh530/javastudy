package com.multithreads;

class Process{
    public void produce() throws InterruptedException {
        synchronized (this){
            System.err.println ("in the producer method :");
            wait ();
            System.err.println ("Again the producer method");
        }
    }

    public void consume() throws InterruptedException {
        Thread.sleep (1000);
        synchronized (this){
            System.err.println ("Consume method called.");
            notify ();
            //If we put Thread.sleep(5000), it waits for 5 secs until send notification to the wait method.
        }
    }
}
public class WaitAndNotify {

    public static void main(String[] args) {
        Process process = new Process ();

        Thread t1 =new Thread (new Runnable () {
            @Override
            public void run() {
                try {
                    process.produce ();
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        });

        Thread t2 =new Thread (new Runnable () {
            @Override
            public void run() {
                try {
                    process.consume ();
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        });

        t1.start ();
        t2.start ();
    }
}
