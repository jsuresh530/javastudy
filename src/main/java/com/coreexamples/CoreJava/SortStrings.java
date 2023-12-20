package com.coreexamples.CoreJava;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.ListIterator;

public class SortStrings {

	public static void main(String[] args) {
		sortString("SURuresh babu onnalagadda");
		
		reverseString();
	}
	
	public static String reverseString()
	{
		String rev = "";
		String name = "sureh babu";
		
		for(int i = name.length() -1;i >= 0 ; i--)
		{
			rev += name.charAt(i);
		}
		
		//Another approach
		
		char[] charArray = name.toCharArray();
		
		List<Character> list = new ArrayList<Character>();
		
		for (Character character : charArray) {
			list.add(character);
		}
		
		Collections.reverse(list);
		
		ListIterator<Character> listIterator = list.listIterator();
		while (listIterator.hasNext()) {
			Character character = (Character) listIterator.next();
		    
			System.err.print(character);
		}
		
		System.err.println(rev);
		return rev;
	}
	public static void sortString(String s )
	{
		char[] charArray = s.toCharArray();
		Arrays.sort(charArray);
		//for (char c : charArray) {
			//System.err.print(c);
		//}
		System.err.println("1.	"+new String(charArray));
		
		
		//Second way
		
		Character[] car = new Character[s.length()];
		
		for (int i = 0; i < charArray.length; i++) {
			car[i] = s.charAt(i);
		}
		
		Arrays.sort(car, new Comparator<Character>() {

			@Override
			public int compare(Character o1, Character o2) {
				return Character.compare(Character.toLowerCase(o1), Character.toLowerCase(o2));
			}
		});
		
		StringBuilder sb = new StringBuilder(car.length);
		
		for (Character character : car) {
			sb.append(character.charValue());
		}
		
		System.err.println("2:	"+sb);
		
		//Using nested loops
		
		char[] arr = s.toCharArray();
		char temp; int i =0;
		
		while(i < arr.length)
		{
			int j = i+1;
			
			while(j < arr.length)
			{
				if(arr[j] < arr[i])
				{
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
				j += 1;
			}
			i += 1;
		}
		
		
		System.err.println("3:	"+new String(arr));
		
	}

}
