package com.multithreads;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LiveLockExample {
    private Lock lock1 = new ReentrantLock (true);
    private Lock lock2 = new ReentrantLock (true);

    public static void main(String[] args) {
        LiveLockExample liveLockExample = new LiveLockExample ();

        new Thread (liveLockExample::worker1, "worker1").start ();
        new Thread (liveLockExample::worker2, "worker1").start ();
    }

    private void worker1(){

        while (true){
            try {
                lock1.tryLock (50, TimeUnit.MILLISECONDS);
                System.err.println ("Worker 1 acquire the lock1");
            }catch (Exception e){
                e.printStackTrace ();
            }
            System.err.println ("Worker 1 tries to acquire the lock2");
            if(lock2.tryLock ()){
                System.err.println ("Worker 1 acquires the lock2");
                lock2.unlock ();
            }else{
                System.err.println ("Worker 1 can not acquires the lock2");
                continue;
            }
                break;
        }

        lock1.unlock ();
        lock2.unlock ();
    }


    public void worker2(){
        while (true){
            try {
                lock2.tryLock (50, TimeUnit.MILLISECONDS);
                System.err.println ("worker 2 acquires the lock2");
            }catch (Exception e){
                e.printStackTrace ();
            }
            System.err.println ("worker 2 tries to acquire the lock1");
            if(lock1.tryLock ()){
                System.err.println ("worker 2 acquire the lock1");
            }else{
                System.err.println ("worker 2 can not acquire the lock1");
                continue;
            }
            break;
        }

        lock1.unlock ();
        lock2.unlock ();

    }
}
