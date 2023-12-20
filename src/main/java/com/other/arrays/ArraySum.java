package com.other.arrays;

import java.util.Scanner;

public class ArraySum
{

	public static void main(String[] args)
	{
		findSum();

	}

	private static void findSum()
	{
		System.out.println("How many elments ....>");
		Scanner sc =new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		
		System.out.println("Enter elements...");
		int sum = 0;
		
		for (int i = 0; i < n; i++)
		{
			arr[i] = sc.nextInt();
		}
		
		for (int i : arr)
		{
			sum += i;
		}
		
		System.out.println("Sum is: "+sum);
		
		if(sc != null) sc.close();
	}

}
