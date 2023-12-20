package com.coreexamples.CoreJava;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class FirstNonRepeatedChar {
	
	
	static int findMissingNumber(int[] arr) {
		int n = arr.length;
		int total = (n+1)*(n+2)/2;
		for (int i = 0; i < n; i++) 
			 total -= arr[i];
		return total;
	}

	public static void main(String[] args) {
		
		
		LinkedList<String> list = new LinkedList<>();
		
		//list.p
		
		ArrayList<String> arrayList = new ArrayList<>();
		
		//arrayList.
 		// TODO Auto-generated method stub
		String s = "suresh jo";
		//System.err.println(getNonRepareatedChar(s));
		
		int[] arr = {5,3,4,1,0};
	System.err.println(findMissingNumber(arr));
		
	}

	
	
	public static char getNonRepareatedChar(String s)
	{
		char c = 0;
		HashMap<Character, Integer> hm = new HashMap<>();
		
		
		for (int i = 0; i < s.length(); i++) {
			c = s.charAt(i);
			if(hm.containsKey(c))
			{
				hm.put(c, hm.get(c)+1);
				
				return c;
			}
			else
			{
				hm.put(c, 1);
			}
		}
		
		
		
		return 0;
	}

}
