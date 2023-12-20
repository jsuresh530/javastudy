package com.multithreads.concurrent.collection;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class Worker implements Runnable {
    private int id;
    private CountDownLatch countDownLatch;

    public Worker(int id, CountDownLatch cdl) {
        this.id = id;
        this.countDownLatch = cdl;
    }

    @Override
    public void run() {
        doWork ();
        countDownLatch.countDown ();
    }

    private void doWork() {

        try {
            System.err.println ("Thread with id "+id+" starting ...");
            Thread.sleep (2000);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }
}

public class LatchExample {
    public static void main(String[] args) {
        CountDownLatch countDownLatch = new CountDownLatch (5);
        ExecutorService executorService = Executors.newSingleThreadExecutor ();

        for (int i = 0; i < 5; i++) {
            executorService.execute (new Worker (i,countDownLatch));
        }

        try {
            countDownLatch.await ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        System.err.println ("All the tasks have been completed :");
        executorService.shutdown ();
    }
}
