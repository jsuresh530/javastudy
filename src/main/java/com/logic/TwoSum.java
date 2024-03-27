package com.logic;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public static void main(String[] args) {
        int [] arr = {7,1,5,8,4,5,6};
        int target =9;
        System.out.println("array sum : "+ Arrays.toString(twoSumHashMap(arr, target)));
    }
    
    public static int[] twoSum(int[] arr, int target){
        int [] result = new int[2];

        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if(arr[i]+arr[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    public static int[] twoSumHashMap(int[] arr, int target){

        Map<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int secondNumber = target - arr[i];
            if(hashMap.containsKey(secondNumber)){
                return new int[]{hashMap.get(secondNumber), i};
            }
            hashMap.put(arr[i], i);
        }
       throw new IllegalArgumentException("No such numbers found");
    }
}
