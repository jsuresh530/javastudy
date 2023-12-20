package com.multithreads;

import java.util.ArrayList;
import java.util.List;

class Processor {

    private List<Integer> integerList = new ArrayList<> ();
    private static final int UPPLER_LIMIT=5;
    private static final int LOWER_LIMIT=0;
    private final Object lock =new Object ();
    private int value = 0;


    public void producer() throws InterruptedException{
        synchronized (lock){
            while (true){
                if(integerList.size () == UPPLER_LIMIT){
                    System.err.println ("Waiting for removing the elements");
                    lock.wait ();
                }else{
                    System.err.println ("Adding elements "+value);
                    integerList.add (value);
                    value++;
                    lock.notify ();
                }
                Thread.sleep (500);
            }
        }
    }

    public void consumer() throws InterruptedException {
        synchronized (lock){
            while (true){
                if(integerList.size () == LOWER_LIMIT){
                    System.err.println ("Waiting for adding elements");
                    value = 0;
                    lock.wait ();
                }else{
                    System.err.println ("Removing : "+integerList.remove (integerList.size ()-1));
                    lock.notify ();
                }
                Thread.sleep (500);
            }
        }
    }

}
public class ProducerConsumerExample {


    public static void main(String[] args) {
        Processor processor =new Processor ();
        Thread t1 =new Thread (new Runnable () {
            @Override
            public void run() {
                try {
                    processor.producer ();
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        });

        Thread t2 = new Thread (new Runnable () {
            @Override
            public void run() {
                try {
                    processor.consumer ();
                } catch (InterruptedException e) {
                    e.printStackTrace ();
                }
            }
        });

        t1.start();
        t2.start ();
    }


}
