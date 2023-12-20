package com.multithreads;

class Worker implements Runnable {

    //store in the main memory and this is available to all the threads.
    private volatile boolean terminated;
    @Override
    public void run() {
    while (!terminated){
        System.err.println ("Worker class is not terminated...");
        try {
            Thread.sleep (500);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
    }
    }

    public void setTerminated(boolean terminated) {
        this.terminated = terminated;
    }

    public boolean isTerminated() {
        return terminated;
    }
}
public class VolatileExample {
    public static void main(String[] args) {
        Worker worker = new Worker ();
        Thread t1 =new Thread (worker);
        t1.start ();

        try {
            Thread.sleep (3000);
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }
        worker.setTerminated (true);
        System.err.println ("Worker class is Terminated ...");
    }
}
