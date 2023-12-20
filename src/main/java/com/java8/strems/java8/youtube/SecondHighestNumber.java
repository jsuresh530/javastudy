package com.java8.strems.java8.youtube;

import java.util.Arrays;
import java.util.Comparator;

public class SecondHighestNumber {
    public static void main(String[] args) {
        Integer[] arr = {8,9,5,11,6,1,7,6};

        final Integer integer = Arrays.stream (arr).distinct ().sorted (Comparator.reverseOrder ())
                .skip (1).findFirst ().get ();

        System.out.println ("integer "+integer);

        int size = arr.length;

        int maxFromRight = arr[size-1];
        arr[size-1] = -1;

        for (int i = size-2; i >= 0; i--) {
            int temp = arr[i];

            if(maxFromRight > arr[i]){
                arr[i] = maxFromRight;
            }else {
                arr[i] = -1;
            }

            if(maxFromRight < temp){
                maxFromRight = temp;
            }
        }

        for (int i=0;i<size;i++){
            System.out.print(arr[i]+" ");
        }

        arr = new Integer[]{8, 9, 5, 11, 6, 1, 7, 6};
        //Approach 2
        int temp1 = -1;
        for (int i = 0; i < size; i++) {
            temp1 = -1;

            for (int j = 0; j < size; j++) {
                if(temp1 < arr[j] && arr[j] > arr[i]){
                    temp1 = arr[j];
                }
            }
        arr[i] = temp1;
        }

        for (int i=0;i<size;i++){
            System.out.print(" "+arr[i]+" ");
        }
    }
}
