package com.multithreads.concurrent.collection;

import java.util.concurrent.Exchanger;

class FirstExchange implements Runnable{

    private int counter;
    private Exchanger<Integer> exchanger;

    public FirstExchange(Exchanger<Integer> exchanger){
        this.exchanger=exchanger;
    }
    @Override
    public void run() {
        while (true){
            counter++;
            System.out.println ("first thread incremented the counter : "+counter);
            try {
                counter = exchanger.exchange (counter);

                Thread.sleep (2000);
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }


        }
    }
}
class SecondExchange implements Runnable{

    private int counter;
    private Exchanger<Integer> exchanger;
    public SecondExchange(Exchanger<Integer> exchanger){
        this.exchanger =exchanger;
    }

    @Override
    public void run() {
        while (true){
            counter--;
            try {
                System.out.println ("Second thread decremented the counter : "+counter);
                counter = exchanger.exchange (counter);
                System.out.println ("First thread get the counter : "+counter);

                Thread.sleep (2000);
            }catch (InterruptedException exception){

            }
        }
    }
}
public class ExchangerExample {
    public static void main(String[] args) {
        Exchanger<Integer> exchanger = new Exchanger<> ();
        FirstExchange firstExchange = new FirstExchange (exchanger);
        SecondExchange secondExchange = new SecondExchange (exchanger);

        new Thread (firstExchange).start ();
        new Thread (secondExchange).start ();
    }
}
