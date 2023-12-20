package com.other.arrays;

import java.util.Arrays;

public class TwodimensionalArray
{

	public static void main(String[] args)
	{
		test2DArray();

	}
	
	public static void test2DArray()
	{
		int marks[][] = new int[3][5];
		
		marks[0][0] = 1;
		marks[0][1] = 1;
		marks[0][2] = 1;
		marks[0][3] = 1;
		marks[0][4] = 1;
		
		System.out.println(Arrays.deepToString(marks));
		
	}

}
