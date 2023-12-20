/**
 * 
 */
package com.other.talent;


/**
 * @author sjonnalagadda
 *
 */
public class SortArray
{

	public static void sortArray(int[] arr, int n)
	{
		for (int i = 0; i < n; i++)
		{
			arr[i] = i+1;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int arr [] = {5,3,2,7,9,8,4,1};
		
		int length = arr.length;
		sortArray(arr, length);
		
		
		for (int i = 0; i < length; i++)
		{
			System.err.println(arr[i]+" ");
		}
	}
}
