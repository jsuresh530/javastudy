package com.multithreads.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Task implements Runnable {

    private int id;
    
    public Task(int id){
        this.id = id;
    }
    @Override
    public void run() {
        System.err.println ("Task with id : "+id+" is in work - thread -id : "+Thread.currentThread ().getId ());
       long duration = (long) (Math.random ()*5);
        try {
            TimeUnit.SECONDS.sleep (duration);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }

    }
}

public class SingleThreadExecutor {

    public static void main(String[] args) {
       // ExecutorService executor = Executors.newSingleThreadExecutor ();
        ExecutorService executor = Executors.newFixedThreadPool (2);
        for (int i = 0; i < 15; i++) {
            executor.execute (new Task (i));
        }

    }
}
