package com.multithreads.sort;

import java.util.Random;

public class ParallelMergeSort {

    private int[] nums;
    private int[] tempArray;


    public ParallelMergeSort(int[] nums) {
        this.nums = nums;
        this.tempArray = new int[nums.length];
    }

    public void parallelMergeSort(int l, int high, int noOfThreads) {
        if (noOfThreads <= 1){
            mergeSort (l,high);
            return;
        }
        int middleIndex = (l+high)/2;
        Thread leftSorter = createThread (l, middleIndex, noOfThreads);
        Thread rightSorter = createThread (middleIndex+1,high,noOfThreads);

        leftSorter.start ();
        rightSorter.start ();

        try {
            leftSorter.join ();
            rightSorter.join ();
        } catch (InterruptedException e) {
            e.printStackTrace ();
        }


        merge (l, middleIndex,high);

    }

    private Thread createThread(int l, int h, int noOfThreads){
        return new Thread () {
            @Override
            public void run(){
                parallelMergeSort(l,h, noOfThreads/2);
            }
        };
    }

    public void sort() {
        mergeSort (0, nums.length - 1);
    }

    //Divide and conquer approach
    private void mergeSort(int low, int high) {
        if (low >= high) return;
        int middleIndex = (low + high) / 2;

        //We keep splitting the problem into smaller and smaller sub problems until a given array contains just 1 item
        mergeSort (low, middleIndex);
        mergeSort (middleIndex + 1, high);

        //We have to combine the sub-solutions
        merge (low, middleIndex, high);

    }

    private void merge(int low, int middle, int high) {
        for (int i = 0; i <= high; i++) {
            tempArray[i] = nums[i];
        }

        int i = low;
        int j = middle + 1;
        int k = low;

        //We consider the temp array and copy the items into the nums
        while (i <= middle && j <= high) {
            if (tempArray[i] < tempArray[j]) {
                nums[k] = tempArray[i];
                ++i;
            } else {
                nums[k] = tempArray[j];
                ++j;
            }
            ++k;
        }
//We have to copy items from the left sub array if there are any
        while (i <= middle) {
            nums[k] = tempArray[i];
            ++k;
            ++i;
        }
        //We have to copy items from the right sub array if there are any

        while (i <= middle) {
            nums[k] = tempArray[i];
            ++k;
            ++i;
        }


    }

    public void showArray() {
        for (int i = 0; i < nums.length; i++) {
            System.out.print (nums[i] + " ");
        }
    }

    private void swap(int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {

        int noOfThreads = Runtime.getRuntime ().availableProcessors ();

        System.err.println ("noOfThreads "+noOfThreads);
        int[] numbers1 = createArray(10000);
        int[] numbers2 = new int[numbers1.length];

        for (int i = 0; i < numbers1.length; i++) {
            numbers2[i] = numbers1[i];
        }

        ParallelMergeSort mergeSort = new ParallelMergeSort (numbers1);
        long startTime = System.currentTimeMillis ();
        mergeSort.parallelMergeSort (0, numbers1.length-1, noOfThreads);
        long endTime = System.currentTimeMillis ();

        System.out.printf ("TIme taken with parallel : %6d ms \n ", endTime-startTime);

        startTime = System.currentTimeMillis ();
        MergeSort mergeSort1 = new MergeSort (numbers2);
        mergeSort1.mergeSort (0, numbers2.length-1);
        endTime = System.currentTimeMillis ();
        System.out.printf ("TIme taken with sequential : %6d ms \n ", endTime-startTime);


    }

    private static int[] createArray(int i) {
        Random r = new Random ();
        int[] a = new int[i];

        for (int j = 0; j < i; j++) {
            a[j] = r.nextInt (i);
        }

        return  a;
    }
}
