package com.coreexamples.CoreJava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

public class ReverseStringExample {

	public static void main(String[] args) {
		reverseString("by b u");
	}
	
	public static void removeWhiteSpace(String s)
	{
		String replaceAll = s.replaceAll("\\s", "");
		System.err.println(replaceAll);
	}
	
	
	public static void reverseString(String s)
	{
		removeWhiteSpace(s);
		String reve = "";
		for (int i = s.length()-1; i >= 0; i--) 
		{
			reve += s.charAt(i);
		}
		System.err.println(reve);
		
		char[] charArray = s.toCharArray();
		List<Character> ll = new ArrayList<Character>();
		
		for (char c : charArray) 
		{
			ll.add(c);
		}
		
		Collections.reverse(ll);
		ListIterator<Character> listIterator = ll.listIterator();
		while (listIterator.hasNext()) {
			System.err.print(listIterator.next());
			
		}
	}

}
