package com.multithreads.sort;

public class SequentialSum {

    //Liner running O(N)
    public int sum(int[] nums){
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum+= nums[i];
        }

        return sum;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};

        SequentialSum sequentialSum = new SequentialSum ();
        System.out.println (sequentialSum.sum (nums));
    }
}
