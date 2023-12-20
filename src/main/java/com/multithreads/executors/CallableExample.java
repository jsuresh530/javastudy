package com.multithreads.executors;

import com.java8.strems.java8.week1.Processor;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

class Processor1 implements Callable<String>{

    private int id;

    public Processor1(int id){
        this.id =id;
    }
    @Override
    public String call() throws Exception {
        Thread.sleep (2000);
        return "Id : "+id;
    }
}
public class CallableExample {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool (2);
        List<Future<String>> list = new ArrayList<> ();

        for (int i=0;i<5;i++){
            list.add(executorService.submit (new Processor1 (i+1)));
        }

        for (Future<String> s : list){
            try {
                System.err.println (s.get ());
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace ();
            }
        }
    }
}
