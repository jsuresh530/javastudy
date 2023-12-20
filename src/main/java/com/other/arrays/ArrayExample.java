package com.other.arrays;

import java.util.ArrayList;
import java.util.Arrays;

public class ArrayExample
{

	public static void main(String[] args)
	{
		listExample();
		compareArrays();
		int ar[] = { 1, 2, 3, 4, 5 };
		for (int i = 0; i < ar.length; i++)
		{
			System.out.println(ar[i]);
		}

	}

	public static void compareArrays()
	{
		int arr1[] = { 1, 2, 3 };
		int arr2[] = { 1, 2, 3 };

		if (arr1 == arr2) // Same as arr1.equals(arr2)
			System.out.println("Same");
		else
			System.out.println("Not same");

		if (Arrays.equals(arr1, arr2)) System.out.println("Same");
		else
			System.out.println("Not same");

		Object[] arr11 = { arr1 }; // arr1 contains only one element
		Object[] arr22 = { arr2 }; // arr2 also contains only one element
		if (Arrays.equals(arr11, arr22)) System.out.println("Same");
		else
			System.out.println("Not same");

		if (Arrays.deepEquals(arr11, arr22)) System.out.println("Same");
		else
			System.out.println("Not same");

	}

	public static void listExample()
	{
		ArrayList<Integer> arr = new ArrayList<>(4);

		arr.add(1);
		arr.add(2);
		arr.add(3);
		arr.add(4);

		// list initially
		System.out.println("The list initially: " + arr);

		// clear fucntion used
		arr.clear();

		// list after clearing all elements
		System.out.println("The list after using clear() method: " + arr);
	}
	
	

}
