package com.multithreads.concurrent.collection;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

class BarrierWorker implements Runnable{

    private int id;
    private Random random;
    private CyclicBarrier cyclicBarrier;

    public BarrierWorker(int id, CyclicBarrier cb) {
        this.id=id;
        this.random =new Random ();
        this.cyclicBarrier =cb;
    }

    @Override
    public void run() {
        doWork();
    }

    private void doWork() {
        System.err.println ("Thread with ID :"+this.id+" Starts the work : ");
        try {
            Thread.sleep (random.nextInt (3000));
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }

        try {
            cyclicBarrier.await ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        } catch (BrokenBarrierException e) {
            e.printStackTrace ();
        }

        System.err.println ("After the await method :");
    }
}
public class CyclicBarrierExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool (5);
        CyclicBarrier cyclicBarrier =new CyclicBarrier (5, new Runnable () {
            @Override
            public void run() {
                System.err.println ("All the tasks are done");
            }
        });

        for (int i = 0; i < 5; ++i) {
            executorService.execute (new BarrierWorker (i+1, cyclicBarrier));
        }

        executorService.shutdown ();


    }
}
