package com.other.algorithms;


/**
 * @author sjonnalagadda
 * 
 * 	
    Worst Case Time Complexity [ Big-O ]: O(n2)
    Best Case Time Complexity [Big-omega]: O(n)
    Average Time Complexity [Big-theta]: O(n2)
    Space Complexity: O(1)

	Hence the time complexity of Bubble Sort is O(n2).
	
 *
 */
public class BubbleSort
{

	public static void main(String[] args)
	{
		 BubbleSort ob = new BubbleSort();
	        int arr[] = {-64, 0, 25, 12, 2, 11, 90};
	        ob.bubbleSort(arr);
	        System.out.println("Sorted array");
	        ob.printArray(arr);
	}
	
	
	// An optimized version of Bubble Sort
    static void bubbleSort1(int arr[], int n)
    {
        int i, j, temp;
        boolean swapped;
        for (i = 0; i < n - 1; i++) 
        {
            swapped = false;
            for (j = 0; j < n - i - 1; j++) 
            {
                if (arr[j] > arr[j + 1]) 
                {
                    // swap arr[j] and arr[j+1]
                    temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                    swapped = true;
                }
            }
 
            // IF no two elements were 
            // swapped by inner loop, then break
            if (swapped == false)
                break;
        }
    }
    
	void bubbleSort(int [] arr)
	{
		int n = arr.length;
		for (int i = 0; i < n-1; i++)
		{
			for (int j = 0; j < n-i-1; j++)
			{
				if(arr[j] > arr[j+1])
				{
					int temp = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = temp;
				}
			}
		}
	}
	
	//print array
	
	void printArray(int[] arr)
	{
		for (int i = 0; i < arr.length; i++)
		{
			System.out.print(arr[i]+" ");
		}
	}
}
