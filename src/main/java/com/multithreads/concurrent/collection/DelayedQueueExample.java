package com.multithreads.concurrent.collection;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;


class DelayWorker implements Delayed{
    public long getDuration() {
        return duration;
    }

    public void setDuration(long duration) {
        this.duration = duration;
    }

    private long duration;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    private String message;

    public DelayWorker(String msg, long duration){
        this.message =msg;
        this.duration = duration+System.currentTimeMillis ();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert (duration-System.currentTimeMillis (), TimeUnit.MILLISECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        if(duration < ((DelayWorker) other).getDuration ())
            return -1;
        if(duration > ((DelayWorker)other).getDuration ())
            return +1;
        return 0;
    }
}

public class DelayedQueueExample {
    // when the delay is expired, then only we can take the elements
    //if the delay is not expired, it returns the null value.


    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<DelayWorker> queue = new DelayQueue<> ();
        queue.put (new DelayWorker ("THis is the first msg", 2000));
        queue.put (new DelayWorker ("THis is the second msg", 10000));
        queue.put (new DelayWorker ("THis is the third  msg", 5000));

        while (!queue.isEmpty ()){
            System.out.println (queue.take ().getMessage ());
        }

    }

}
