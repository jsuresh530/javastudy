package com.other.algorithms;

public class MinMax
{

	public static void main(String[] args)
	{
		int[] arry = { -99, 366, 41, 99, -1 };
		findMin(arry);
		findMax(arry);

		sortArray(arry);
		
		randomNumberArray();
	}

	private static void randomNumberArray()
	{
		int[] arry = new int[10];
		for (int i = 0; i < arry.length; i++)
		{
			arry[i] = (int) (Math.random() * 100 +1);
		}
		System.out.println("Before Sorting...");
		for (int i = 0; i < arry.length; i++)
		{
			System.out.print(" "+arry[i]+" ");
		}
		
		System.out.println("After Sorting...");
		for (int i = 0; i < arry.length-1; i++)
		{
			for (int j = 1; j < arry.length-i; j++)
			{
				if(arry[j-1] > arry[j])
				{
					int temp = arry[j];
					arry[j] = arry[j-1];
					arry[j-1] =temp;
				}
			}
		}
		
		for (int i = 0; i < arry.length; i++)
		{
			System.out.print(" "+arry[i]+" ");
		}
	}

	private static void sortArray(int[] array)
	{
		System.out.println("Before Sorting...");
		for (int i = 0; i < array.length; i++)
		{
			System.out.print(array[i] + " ");
		}
		/*
		 * int length = arry.length -1; for (int i = 0; i < length; i++) { for
		 * (int j = 1; j < arry.length-i; j++) { if(arry[j-1] > arry[j]) { int
		 * temp = arry[j-1]; arry[j-1] = arry[j]; arry[j] = temp; } } }
		 */

		for (int i = 0; i < array.length; i++)
		{
			for (int j = 0; j < array.length; j++)
			{
				if (array[i] < array[j])
				{
					int temp = array[i];
					array[i] = array[j];
					array[j] = temp;
				}
			}
		}
		
		System.out.println("After Sorting...");
		for (int i = 0; i < array.length; i++)
		{
			System.out.print( array[i] + " ");
		}
	}

	private static void findMax(int[] arry)
	{
		int max = Integer.MIN_VALUE;
		int secMax = Integer.MIN_VALUE;
		for (int i = 0; i < arry.length; i++)
		{
			if (arry[i] > max)
			{
				secMax = max;
				max = arry[i];
			}
			else if (arry[i] > secMax)
			{
				secMax = arry[i];
			}

		}
		System.out.println("max is : " + max + " ---  " + secMax);
	}

	private static void findMin(int[] arry)
	{
		int min = Integer.MAX_VALUE;
		int secMin = Integer.MAX_VALUE;

		for (int i = 0; i < arry.length; i++)
		{
			if (arry[i] < min)
			{
				secMin = min;
				min = arry[i];
			}
			else if (arry[i] < secMin)
			{
				secMin = arry[i];
			}
		}

		System.out.println("min is : " + min + "------------ " + secMin);
	}

}
