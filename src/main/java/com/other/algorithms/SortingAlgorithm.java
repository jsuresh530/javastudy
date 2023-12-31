package com.other.algorithms;

/**
 * @author sjonnalagadda
 *
 *There are some common running times when analyzing an algorithm:

    O(1) – Constant Time Constant time means the running time is constant, it’s not affected by the input size.

    O(n) – Linear Time When an algorithm accepts n input size, it would perform n operations as well.

    O(log n) – Logarithmic Time Algorithm that has running time O(log n) is slight faster than O(n). Commonly, algorithm divides the problem 
    into sub problems with the same size. Example: binary search algorithm, binary conversion algorithm.

    O(n log n) – Linearithmic Time This running time is often found in "divide & conquer algorithms" which divide the problem into sub problems 
    recursively and then merge them in n time. Example: Merge Sort algorithm.

    O(n2) – Quadratic Time Look Bubble Sort algorithm!

    O(n3) – Cubic Time It has the same principle with O(n2).

    O(2n) – Exponential Time It is very slow as input get larger, if n = 1000.000, T(n) would be 21000.000. Brute Force algorithm has this running 
    time.

    O(n!) – Factorial Time THE SLOWEST !!! Example : Travel Salesman Problem (TSP)
    
    
    
    Algorithm 	Time Complexity 						Space Complexity
					Best 			Average 		Worst 			Worst
	Quicksort 	(omega)Ω(n log(n)) 	Θ(n log(n)) 	O(n^2) 			O(log(n))
	Mergesort 		Ω(n log(n)) 	Θ(n log(n)) 	O(n log(n)) 	O(n)
	Timsort 		Ω(n) 			Θ(n log(n)) 	O(n log(n)) 	O(n)
	Heapsort 		Ω(n log(n)) 	Θ(n log(n)) 	O(n log(n)) 	O(1)
	Bubble Sort 	Ω(n) 			Θ(n^2) 			O(n^2) 			O(1)
	Insertion Sort 	Ω(n) 			Θ(n^2) 			O(n^2) 			O(1)
	Selection Sort 	Ω(n^2) 			Θ(n^2) 			O(n^2) 			O(1)
	Tree Sort 		Ω(n log(n)) 	Θ(n log(n)) 	O(n^2) 			O(n)
	Shell Sort 		Ω(n log(n)) 	Θ(n(log(n))^2) 	O(n(log(n))^2) 	O(1)
	Bucket Sort 	Ω(n+k) 			Θ(n+k) 			O(n^2) 			O(n)
	Radix Sort 		Ω(nk) 			Θ(nk) 			O(nk) 			O(n+k)
	Counting Sort 	Ω(n+k) 			Θ(n+k) 			O(n+k) 			O(k)
	Cubesort 		Ω(n) 			Θ(n log(n)) 	O(n log(n)) 	O(n)



 */
public class SortingAlgorithm {
	
	private static int[] theArray;
	private static long startTime,stopTime;
	
	  private static int[] numbers;
	  private static int[] helper;
	  private static int number;
	  
	public static void main(String args[]){
		
		int [] array =  {10,15,2,0,55,66,8,1};
		
		System.out.println("array Before bubble sorting");
		//displayArray(array);
		
		//quickSort(array);
		
		System.out.println("array After bubble sorting");
		//displayArray(array);
		
		System.out.println("\n\narray Before quick sorting");
		displayArray(array);
		
		quickSort(array);
		
		System.out.println("array After quick sorting");
		displayArray(theArray);
		
		System.out.println("\n\narray Before merge sorting");

	    sort_mearg(array);

		System.out.println("\n\narray Before merge sorting");
	}
	
	 public static void sort_mearg(int[] values) {
		 
		    numbers = values;
		    number = values.length;
		    helper = new int[number];
		    startTime= System.currentTimeMillis();
		    mergesort(0, number - 1);

		stopTime= System.currentTimeMillis();
		System.out.println("Total Time to Merge Sort is "+ (stopTime-startTime));
	}
	 
	 
	public static int[] generateRandomeArray(){
		int[] kickerNumbers = new int[10000];
		for(int i = 0; i < kickerNumbers.length; i++) {
		    kickerNumbers[i] = (int)(Math.random()*10+19);
		}
		return kickerNumbers;
	}
	public static int[] bubbleSort(int[] array){
		startTime= System.currentTimeMillis();
		for(int i = 0;i<array.length - 1 ; i++){
			for(int j = i+1;j< array.length;j++){
				if(array[i]>array[j]){
					swapValues(array,i,j);
				}
			}
		}
		stopTime= System.currentTimeMillis();
		System.out.println("Total Time to Bubble Sort is "+ (stopTime-startTime));
		return array;
	}
	/*public void selectionSort(){
		int min;
		for(int i=0; i<nElems-1; i++) // outer loop
		{
			min = i; // minimum
			for(j=i+1; j<nElems; j++) // inner loop
			if(a[j] < a[min] ) // if min greater,
				min = j; // we have a new min
			swap(i, min); // swap them
		} 
	}*/
	 private static void mergesort(int low, int high) {
		    // check if low is smaller then high, if not then the array is sorted
		    if (low < high) {
		      // Get the index of the element which is in the middle
		      int middle = low + (high - low) / 2;
		      // Sort the left side of the array
		      mergesort(low, middle);
		      // Sort the right side of the array
		      mergesort(middle + 1, high);
		      // Combine them both
		      merge(low, middle, high);
		    }
		  }

		  private static void merge(int low, int middle, int high) {

		    // Copy both parts into the helper array
		    for (int i = low; i <= high; i++) {
		      helper[i] = numbers[i];
		    }

		    int i = low;
		    int j = middle + 1;
		    int k = low;
		    // Copy the smallest values from either the left or the right side back
		    // to the original array
		    while (i <= middle && j <= high) {
		      if (helper[i] <= helper[j]) {
		        numbers[k] = helper[i];
		        i++;
		      } else {
		        numbers[k] = helper[j];
		        j++;
		      }
		      k++;
		    }
		    // Copy the rest of the left side of the array into the target array
		    while (i <= middle) {
		      numbers[k] = helper[i];
		      k++;
		      i++;
		    }

		  }

		  /*
		   * 
		   * The time complexity of Quicksort is O(n log n) in the best case, O(n log n) in the average case, and O(n^2) in the worst case.
		   *  But because it has the best performance in the average case for most inputs, Quicksort is generally considered the “fastest” sorting 
		   *  algorithm
		   */
		  public static void quickSort(int[] array){
			 theArray = array;
			 int low = 0;
			 int high = array.length-1;
			 sort(low,high);
		  }
		  public static void sort(int low, int high){
			  int temp_high = high;
			  int temp_low = low;
			  int pivot = theArray[low + (high-low)/2];
			  
			while (temp_low<=temp_high) {
			 
			  while(theArray[temp_low]<pivot){
				temp_low++; 
			  }
			  while(theArray[temp_high]>pivot){
				  temp_high--; 
			  }
			  
			  if(temp_low<=temp_high){
				  swapValues(theArray,temp_low, temp_high);
				  temp_low++; 
				  temp_high--;
			  }
			}

			if(low<temp_high){
				sort(low,temp_high);
			}
			if(temp_low<high){
				sort(temp_low,high);
			}
			
		  }
	public static void intInsertionSort(int [] a){
 	    for(int i =0;i<a.length;i++)
 	    {
 	         int temp = a[i];
 	         int j;
 	         for(j = i-1; j>=0 && a[j]>temp;j--)
	         {
	             a[j+1] = a[j];
	         }
	       a[j+1] = temp;
    	}
  }
	
	
	////// Helping functions ////////////
	
	private static void swapValues(int[] array, int i,int j){
		int temp = array[j];
		array[j]= array[i];
		array[i] = temp;
	}
	
	private static void displayArray(int[] array){
		System.out.print("{");
		for(int i = 0 ; i <array.length;i++){
			System.out.print(" "+array[i]);
		}
		System.out.print("}\n");
	}
}