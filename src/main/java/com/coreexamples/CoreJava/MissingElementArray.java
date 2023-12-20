package com.coreexamples.CoreJava;

import java.util.Arrays;

public class MissingElementArray {

	public static void main(String[] args) {
		
		int[] arr = new int[] {7,2,4,1};

		System.err.println(getMissingElement(arr));
		
		int[] sortArray = sortArray(arr);
		
		for (int i : sortArray) {
			System.err.print(i+" , ");
		}
		
		System.err.println(getMissingNumber(arr));
	}
	
	
	public static int[] sortArray(int[] arr)
	{
		for (int i = 0; i < arr.length; i++) {
			for (int j = 1; j < arr.length; j++) {
				if(arr[j-1] > arr[j])
				{
					int temp = arr[j-1];
					arr[j-1] = arr[j];
					arr[j] = temp;
				}
			}
		}
		
		return arr;
	}
	
	private static int getMissingNumber(int[] arr)
	{
		int result =0;
		for (int i = 0; i < arr.length; i++) {
			int index = i+1;
			if(arr[i] != index)
			{
				result =index;
				break;
			}
		}
		
		return result;
	}
	
	private static int getMissingElement(int[] array)
	{
		Arrays.sort(array);
		
		//System.err.println(Arrays.toString(array));
		
		int low = 0, missingElement = 0;
		int high = array.length-1;
		
		while(low <= high)
		{
			int mid = (low+high)/2;
			
			//System.err.println("mid: "+mid+" : "+array[mid]);
			
			if(array[mid] != mid+1)
			{
				high = mid -1;
				missingElement = mid+1;
			}
			else
			{
				//System.err.println("else");
				low = mid+1;
			}
		}
		
		if(missingElement == 0)
		{
			return array.length+1;
		}
		return missingElement;
		
	}

}
