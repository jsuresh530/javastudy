package com.multithreads.chopstick;

import java.util.Random;

public class Philosopher implements Runnable {

    @Override
    public String toString() {
        return "Philosopher : " + id;
    }

    private int id;

    public boolean isFull() {
        return full;
    }

    public void setFull(boolean full) {
        this.full = full;
    }

    private volatile boolean full;
    private ChopStick left;
    private ChopStick right;

    private Random random;
    private int eatingCounter;


    public Philosopher(int id, ChopStick left, ChopStick right) {
        this.id = id;
        this.left = left;
        this.right = right;
        this.random = new Random ();
    }

    @Override
    public void run() {

        try {
            while (!full) {
                think ();

                if (left.pickUp (this, State.LEFT)) {
                    if (right.pickUp (this, State.RIGHT)) {
                        eat ();
                        right.putDown (this, State.RIGHT);
                    }
                    left.putDown (this, State.LEFT);
                }
            }
        } catch (Exception e) {
            e.printStackTrace ();
        }
    }

    private void think() throws InterruptedException {
        System.out.println (this + " is thinking ... ");
        Thread.sleep (random.nextInt (1000));
    }

    private void eat() throws InterruptedException {
        System.out.println (this + " is eating ... ");
        eatingCounter++;
        Thread.sleep (random.nextInt (1000));
    }

    public int getEatingCounter(){

        return this.eatingCounter;
    }

}
