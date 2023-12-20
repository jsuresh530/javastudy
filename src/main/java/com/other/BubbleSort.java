package com.other;

import java.util.Arrays;


public class BubbleSort
{

	public static void main(String[] args)
	{
		int [] arry = {7, -4, 5, -2,9,-3,-5};
		
		bubble_sort(arry);
		System.err.println("\n ");
		
		insertion_Sort(arry);
		
		selectionSort(arry);
		
		swapStrings();
		
		countDistinct(arry, arry.length);
		try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.err.println(binarySearch(arry, 9));
		
		System.err.println(binarySearch(arry,0, arry.length, -5));
		
	}
	
	static int binarySearch(int arr[], int l, int r, int x) 
	{ 
	    while (l <= r) 
	    { 
	        // find index of middle element 
	        int m = (l+r)/2; 
	  
	        // Check if x is present at mid 
	        if (arr[m] == x) return m; 
	  
	        // If x greater, ignore left half 
	        if (arr[m] < x) l = m + 1; 
	  
	        // If x is smaller, ignore right half 
	        else r = m - 1; 
	    } 
	  
	    // if we reach here, then element was not present 
	    return -1; 
	}

	private static int binarySearch(int[] arr, int key)
	{
		System.err.println("POSITION IS ::: ");
		int l = 0, r = arr.length - 1; 
        while (l <= r) { 
            int m = l + (r - l) / 2; 
  
            // Check if x is present at mid 
            if (arr[m] == key) 
                return m; 
  
            // If x greater, ignore left half 
            if (arr[m] < key) 
                l = m + 1; 
  
            // If x is smaller, ignore right half 
            else
                r = m - 1; 
        } 
  
        // if we reach here, then element was 
        // not present 
        return -1; 
	}


	private static void countDistinct(int[] arry, int n)
	{
		Arrays.sort(arry); 
		
		int res =0;
		
		for (int i = 0; i < n; i++)
		{
			while (i< n-1 && arry[i] == arry[i+1])
			{
				i++;
			} res++;
		}
		
		System.err.println("re is :  "+res);
	}

	/**
	 * 
	 */
	private static void swapStrings()
	{
		String str1 = "babu" , str2 ="suresh";
		
		  System.out.println("Strings before swapping: " + str1 + " " + str2);    
		  
		  str1 =str1+str2;
		  
		  str2 = str1.substring(0, (str1.length()-str2.length()));
		  
		  str1 =str1.substring(str2.length());
		  
		  System.out.println("Strings AFTER swapping: " + str1 + " " + str2);    
	}

	/*
    	Algorithm repeatedly searches for the lowest element.
    	Swap current element with an element having the lowest value
    	With every iteration/pass of selection sort, elements are swapped.
	 */
	static void selectionSort(int arry[]){
		for (int i = 0; i < arry.length -1 ; i++)
		{
			int index =i;
			for (int j = i+1; j < arry.length; j++)
			{
				if(arry[j] < arry[index]){
					index = j;
				}
			}
			
			int smallNo = arry[index];
			arry[index] = arry[i];
			arry[i] = smallNo;
		}
		
		System.err.println("\n "+Arrays.toString(arry));
	}
	
	/*
	 * Insertion sort is a simple sorting algorithm suited for small data sets. During each iteration, the algorithm
       Removes an element from an array Compares it against the largest value in the array Moves the element to its correct location.
	 */
	static void insertion_Sort(int array[]){
		int n = array.length;
		for (int i = 1; i < n; i++)
		{
			int key = array[i];
			int j = i-1;
			
			while ( (j > -1) && (array[j] > key) )
			{
				array[j+1] = array[j];
				j--;
			}
			 array[j+1] = key;
		}
		
		printArray(array);
	}
	
	static void  bubble_sort( int array[] ) {
	    int temp = 0;
	    int length = array.length;
	    for (int i = 0; i < length; i++)
		{
			for (int j = 1; j < (length-i); j++)
			{
				if(array[j-1] > array[j]){
					temp = array[j-1];
					array[j-1] = array[j];
					array[j] = temp;
					
					//System.out.println(array[j]  + " is greater than " + array[j-1]);
				}
			}
		}
	    
	    printArray(array);
	}
	
	static void printArray(int array[] ){
		for (int i = 0; i < array.length; i++)
		{
			System.err.print(" " +array[i]);
		}
	}
	
}
