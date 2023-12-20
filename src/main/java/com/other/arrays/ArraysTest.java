package com.other.arrays;

import java.util.Arrays;


public class ArraysTest
{

	public static void main(String[] args)
	{
		int arr[] = { 12, 13, 14, 15, 16, 17, 18};
		System.out.println("arr.length+3 --------> "+(arr.length+3));
		int[] copyOfRange = Arrays.copyOfRange(arr, 2, arr.length+1);
		
		
		System.out.println(Arrays.toString(copyOfRange));
	}
}
