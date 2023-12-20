package com.multithreads.concurrent.collection;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

class BlockingQu implements  Runnable{
    private BlockingQueue<Integer> blockingQueue;

    public BlockingQu(BlockingQueue<Integer> bq){
        this.blockingQueue =bq;
    }

    @Override
    public void run() {
        int counter = 0;

        while (true){
            try {
                blockingQueue.put (counter);
                System.err.println ("Putting items into the queue : counter "+counter);
                counter++;
                Thread.sleep (100);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
    }
}

class BlockingQu1 implements  Runnable{
    private BlockingQueue<Integer> blockingQueue;

    public BlockingQu1(BlockingQueue<Integer> bq){
        this.blockingQueue =bq;
    }

    @Override
    public void run() {
        int counter = 0;

        while (true){
            try {
                Integer take = blockingQueue.take ();
                System.err.println ("Taking items from the queue : counter "+take);
                Thread.sleep (300);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }
    }
}

public class BlockingQueueExample {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue = new ArrayBlockingQueue<> (10);
        BlockingQu worker1 = new BlockingQu (blockingQueue);
        BlockingQu1 worker2 = new BlockingQu1 (blockingQueue);

        new Thread (worker1).start ();
        new Thread (worker2).start ();

    }
}
