/**
 * 
 */
package com.other.arrays;

import java.util.Arrays;
import java.util.Collections;


/**
 * @author sjonnalagadda
 *
 */
public class ReverseArray
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		int arr[] = {-3,6,7,0,-9};
		reverse(arr, arr.length);
	}
	
	public class ComparisonStringChallenge {
		public  void main(String... doYourBest) {
			String result = "";
			result += " powerfulCode ".trim() == "powerfulCode" 
					? "0" : "1";

			result += "flexibleCode" == "flexibleCode" ? "2" : "3";
			
			result += new String("doYourBest") 
					== new String("doYourBest") ? "4" : "5";

			result += new String("noBugsProject")
					.equals("noBugsProject") ? "6" : "7";

	        result += new String("breakYourLimits").intern()
	                == new String("breakYourLimits").intern() ? "8" : "9";

			System.out.println(result);
		}
	}
	
	static void reverse(int arr[], int len){
		int i,j,k;
		for (i = 0; i < len/2; i++)
		{
			k = arr[i];
			arr[i] = arr[len-i-1];
			arr[len-i-1] = k;
		}
		System.err.println("Reversed array is :\n");
		for (k = 0;  k < len; k++)
		{
			System.out.print(arr[k]+" ");
		}
		
		reverse2(arr, len);
	}
	
	static void reverse2(int arr[], int len){
		
		int b [] = new int[len];
		int j = len;
		for (int i = 0; i < len; i++)
		{
			b[j-1] = arr[i];
			j =j-1;
		}
		
		System.err.println("\n Reversed array is :\n");
		for (int k = 0;  k < len; k++)
		{
			System.out.print(arr[k]+" ");
		}
		
		Collections.reverse(Arrays.asList(arr)); 
        System.out.println("@@@@@@ "+Arrays.asList(arr)); 
	}
}
