package com.multithreads.chopstick;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChopStick {
    @Override
    public String toString() {
        return " " +id;
    }

    private int id;
    private Lock lock;

    public ChopStick(int id){
        this.id=id;
        this.lock = new ReentrantLock ();
    }

    public boolean pickUp(Philosopher philosopher, State state) throws InterruptedException {
        if(lock.tryLock (10, TimeUnit.MILLISECONDS)){
            System.out.println (philosopher+" pick up "+state.toString ()+" "+this);
            return true;
        }
        return false;
    }

    public void putDown(Philosopher philosopher, State state){
        lock.unlock ();
        System.out.println (philosopher+" puts down "+state.toString ()+" "+this);
    }
}
