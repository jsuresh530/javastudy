package com.other.algorithms;


/**
 * @author sjonnalagadda
 *	Worst-case performance: O(n2)
	Best-case performance: O(n log n)
	Average performance: O(n log n)
	
	Quicksort is a divide and conquer algorithm. Quicksort first divides a large array into two smaller sub-arrays:
	 the low elements and the high elements. Quicksort can then recursively sort the sub-arrays.

The steps are:

    Pick an element, called a pivot, from the array.
    Partitioning: reorder the array so that all elements with values less than the pivot come before the pivot, while all elements with values 
    greater than the pivot come after it (equal values can go either way). After this partitioning, the pivot is in its final position. 
    This is called the partition operation.
    Recursively apply the above steps to the sub-array of elements with smaller values and separately to the sub-array of elements with greater 
    values.

The base case of the recursion is arrays of size zero or one, which are in order by definition, so they never need to be sorted. 

Like Merge Sort, QuickSort is a Divide and Conquer algorithm. It picks an element as pivot and partitions the given array around the picked pivot. 
There are many different versions of quickSort that pick pivot in different ways.

    Always pick first element as pivot.
    Always pick last element as pivot (implemented below)
    Pick a random element as pivot.
    Pick median as pivot.

The key process in quickSort is partition(). Target of partitions is, given an array and an element x of array as pivot, 
put x at its correct position in sorted array and put all smaller elements (smaller than x) before x, and put all greater elements 
(greater than x) after x. All this should be done in linear time.


	
 */
public class QuickSort
{

	public static void main(String[] args)
	{
		int arr[] = {-10, 97, 8, 9, -1, -5}; 
        int n = arr.length; 
  
        QuickSort ob = new QuickSort(); 
        ob.sort(arr, 0, n-1); 
  
        System.out.println("sorted array"); 
        printArray(arr); 
	}
	
	/* This function takes last element as pivot, 
    places the pivot element at its correct 
    position in sorted array, and places all 
    smaller (smaller than pivot) to left of 
    pivot and all greater elements to right 
    of pivot */
	int partition(int[] arr, int low, int high)
	{
		int pivot = arr[high];
		int i = (low-1); // index of smaller element 
		
		for (int j = low; j < high; j++)
		{
            // If current element is smaller than or equal to pivot 
			if(arr[j] <= pivot)
			{
				i++;
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
        // swap arr[i+1] and arr[high] (or pivot) 
		int temp = arr[i+1];
		arr[i+1] = arr[high];
		arr[high] = temp;
		
		return i+1;
	}
	
	void sort(int[] arr, int low, int high)
	{
		if(low < high)
		{
			int pi = partition(arr, low, high);
			
			// Recursively sort elements before 
            // partition and after partition 
			sort(arr, low, pi-1);
			sort(arr, pi+1, high);
		}
	}
	
	static void printArray(int[] arr)
	{
		int length = arr.length;
		for (int i = 0; i <length; i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
}
