package com.multithreads;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class DeadLockExample {

    private Lock lock1 = new ReentrantLock (true);
    private Lock lock2 = new ReentrantLock (true);

    public void worker1(){
        lock1.lock ();
        System.err.println ("worker1 acquirer the lock1 ");
        try {
            Thread.sleep (300);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        lock2.lock ();
        System.err.println ("worker1 acquirer the lock2 ");
        lock1.unlock ();
        lock2.unlock ();
    }

    public void worker2(){
        lock1.lock ();
        System.err.println ("worker2 acquirer the lock1 ");
        try {
            Thread.sleep (300);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        lock2.lock ();
        System.err.println ("worker1 acquirer the lock2 ");
        lock1.unlock ();
        lock2.unlock ();
    }

    public static void main(String[] args) {

        DeadLockExample deadLockExample = new DeadLockExample ();
        new Thread (deadLockExample::worker1,"worker1").start ();
        new Thread (deadLockExample::worker2,"worker2").start ();

    }
}
