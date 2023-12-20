package com.multithreads.sort;
class ParallelSum {
    private ParallelWorker[] workers;
    private int noOfThreads;

    public  ParallelSum(int noOfThreads){
        this.noOfThreads = noOfThreads;
        this.workers = new ParallelWorker[noOfThreads];
    }

    public int sum(int[] nums){

        int size = (int) Math.ceil (nums.length*1.0/noOfThreads );

        for (int i = 0; i < noOfThreads; i++) {
            workers[i] = new ParallelWorker (nums, i*size, (i+1)*size);
            workers[i].start ();
        }

        for (ParallelWorker worker : workers) {
            try {
                worker.join ();
            } catch (InterruptedException e) {
                e.printStackTrace ();
            }
        }

        int total =0;
        for (ParallelWorker worker : workers)
            total += worker.getPartialSum ();

        return total;
    }
    public static void main(String[] args) {

        int[] nums = {1,2,3,4,5,0,6,8,2,4,7,1,5,5,6};
        int n = Runtime.getRuntime ().availableProcessors ();
        ParallelSum parallelSum = new ParallelSum (n);
        System.out.print (parallelSum.sum (nums));
    }
}
public class ParallelWorker extends Thread{

    private int[] nums;
    private int low;
    private int high;
    private int partialSum;

    public ParallelWorker(int[] nums, int low, int high) {
        this.nums = nums;
        this.low = low;
        this.high = Math.min (nums.length, high);
    }

    @Override
    public void run(){
        partialSum = 0;
        for (int i = low; i < high; i++) {
            partialSum += nums[i];
        }
    }

    public int getPartialSum() {
        return partialSum;
    }
}
