package com.coreexamples.CoreJava;

public class FindClosestNumber {

	public static void main(String[] args) {

		int arr[] = { 1, 2, 4, 5, 6, 20, 26, 30 };
		System.err.println(getClosestNumber(arr, 4));
	}

	public static int getClosestNumber(int arr[], int target)
	{
		if(arr.length == 0)
			System.exit(0);
		
		if(target <= arr[0])
			return arr[0];
		
		if(target >= arr[arr.length-1])
			return arr[arr.length-1];
		
		int start = 0;
		int end = arr.length-1;
		int mid = 0;
		
		while(end-start != 1)
		{
			mid = (start+end)/2;
			if(target == arr[mid])
				return arr[mid];
			
			if(target < arr[mid])
				end = mid;
			if(target > arr[mid])
				start = mid;
		}
		
		return Math.abs(target-arr[start]) <= Math.abs(target-arr[end]) ? arr[start] : arr[end];
	}
}
