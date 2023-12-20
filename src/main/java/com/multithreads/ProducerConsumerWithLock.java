package com.multithreads;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

class Locker{
    private Lock lock = new ReentrantLock ();
    private Condition condition = lock.newCondition ();

    public void produce() throws InterruptedException {
        lock.lock ();
        System.out.println ("In the producer");
        condition.await ();
        System.out.println ("Again In the producer");
    }

    public void consumer() throws InterruptedException{
        Thread.sleep (2000);
        lock.lock ();
        System.out.println ("Consumer method");
        Thread.sleep (3000);
        condition.signal ();
        lock.unlock ();
    }
}
public class ProducerConsumerWithLock {

    public static void main(String[] args) {
        Locker locker = new Locker ();
        Thread t1 =new Thread (new Runnable () {
            @Override
            public void run() {
                try {
                    locker.produce ();
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        });

        Thread t2 =new Thread (new Runnable () {
            @Override
            public void run() {
                try {
                    locker.consumer ();
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        });

        t1.start ();
        t2.start ();
    }
}
