package com.coreexamples.CoreJava;

public class LoopsExample {
	
	private void sum()
	{
		System.err.println("sum of a and b are");
	}

	public static void main(String[] args) {
		int a =5;

		//int i = a++ + ++a + ++a;

		//System.err.println(a++);
		//System.err.println(++a);
		//System.err.println(++a);
		//5 7 8 
		int [] array = {-1,1,1,1,-2,1};
		maxSum(array);
	}
	
	/**
	 * @param arr
	 */
	public static void maxSum(int[] arr)
	{
		int maxSum = 0, sum =0;
		
		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
			if(maxSum < sum)
			{
				maxSum = sum;
			}
			else if(sum < 0)
			{
				sum =0;
			}
		}
		
		System.err.println("maxSum : "+maxSum);
	}

}
