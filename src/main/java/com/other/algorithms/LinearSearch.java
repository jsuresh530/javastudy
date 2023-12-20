package com.other.algorithms;


public class LinearSearch
{

	public static void main(String[] args)
	{
		int[] arr = {2,4,6,-9,99};
		System.err.println(",,,,, "+arr.length+" ----> "+arr[0]);
		int n = arr.length;
		int search = search(arr, n, -9);
		
		System.out.println("\n search: "+search);
	}
	
	static int search(int[] arr, int n, int x)
	{
		for (int i = 0; i < n; i++)
		{
			if(arr[i] == x) return i;
		}
		return -1;
	}
}
