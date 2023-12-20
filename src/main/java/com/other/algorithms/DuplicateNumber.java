

package com.other.algorithms;

import java.util.HashSet;

public class DuplicateNumber
{

	public static void main(String[] args)
	{
		findDuplicateNo();
		printTwoMaxNo();
		printTwoMinNo();
		sumAllNo();
	}

	public static void sumAllNo()
	{
		String s = "suresh 12 12";
		//s = s.replaceAll("[\\D]+", " ");
		String[] split = s.split("\\s+");
		int sum = 0;
		for (int i = 0; i < split.length; i++)
		{
			try
			{
				sum += Integer.parseInt(split[i]);
			}
			catch (NumberFormatException nfe)
			{
				//System.err.println("exception " + nfe.getMessage());
			}
		}
		System.out.println("Sum is : " + sum);
	}

	public static void findDuplicateNo()
	{
		int[] numbers = { 12, 13, 13, 22, 112, 2 };
		int total = getSum(numbers);
		int innerLen = numbers.length;
		for (int i = 0; i < innerLen - 1; i++)
		{
			for (int j = i + 1; j < innerLen; j++)
			{
				if ((numbers[i] == numbers[j]) && (i != j))
				{
					System.out.println("Duplicate Element : " + numbers[j]);
				}
			}
		}
		String[] strArr = { "ss", "ss", "mno", "xyz", "pqr", "xyz", "def" };
		HashSet<String> set = new HashSet<String>();
		for (String str : strArr)
		{
			if (!set.add(str))
			{
				System.out.println("Duplicate Element is : " + str);
			}
		}
	}

	private static int getSum(int[] numbers)
	{
		int sum = 0;
		for (Integer i : numbers)
		{
			sum += i;
		}
		return sum;
	}

	private static void printTwoMaxNo()
	{
		int maxOne = Integer.MIN_VALUE;
		int maxTwo = Integer.MIN_VALUE;
		int num[] = {25, 992, 997, 88 };
		for (int i : num)
		{
			if (i > maxOne)
			{
				maxTwo = maxOne;
				maxOne = i;
			}
			else if (i > maxTwo)
				maxTwo = i;
		}
		System.out.println("MAx ONE & MAX TWO " + maxOne + " " + maxTwo);
	}

	private static void printTwoMinNo()
	{
		int min = Integer.MAX_VALUE;
		int secMin = Integer.MAX_VALUE;
		int num[] = { 5, 12, 7, 88 };
		for (int i : num)
		{
			if (i < min)
			{
				secMin = min;
				min = i;
			}
			else if (i < secMin)
			{
				secMin = i;
			}
		}
		System.out.println(" MIN and SEC MIN is : " + min + "************"
				+ secMin);
	}
}
