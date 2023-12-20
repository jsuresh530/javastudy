package com.multithreads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

enum  Downloader {
    INSTANCE;
    private Semaphore semaphore = new Semaphore (3, true);
   // It is used to control access to a shared resource that uses a counter variable.
    // it maintains a set of permits, acquire - if a permit is availble then takes it
    // release - adds a permit
    // semaphore just keeps a count of the the number of permits available new Semaphore(count, fairness)
    public void download(){
        try {
            semaphore.acquire ();
            downloadData ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }finally {
            semaphore.release ();
        }
    }

    private void downloadData(){
        try {
            Thread.sleep (5000);
            System.err.println ("Downloading data from the web .");
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }
}
public class SemaPhoresExample {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool ();
        for (int i = 0; i < 12; i++) {
            service.execute (new Runnable () {
                @Override
                public void run() {
                    Downloader.INSTANCE.download ();
                }
            });
        }
    }
}
