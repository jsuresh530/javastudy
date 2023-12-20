package com.multithreads.sort;

public class MergeSort {

    private int[] nums;
    private int[] tempArray;


    public MergeSort(int[] nums) {
        this.nums = nums;
        this.tempArray = new int[nums.length];
    }

    public void sort() {
        mergeSort (0, nums.length - 1);
    }

    //Divide and conquer approach
    public void mergeSort(int low, int high) {
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

      /* int i =1, j;
       j = i++;

       System.err.println (i+" "+j);
       int l =1, p;
       p = ++l;
        System.err.println (l+" "+p);*/

        //int [] nums = {5,-1,0,7,2,3,2,1,0,1,2};
        int [] nums = {4,-1,0,5,4,3,2,1,1};
        MergeSort mergeSort = new MergeSort (nums);
        mergeSort.sort ();
        mergeSort.showArray ();
    }
}
