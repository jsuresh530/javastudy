package com.other.algorithms.asymetric;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.CopyOnWriteArrayList;

public class SumIt {

	public static void main(String[] args) {
		
		//sumOnlyNumbers();
		
		
		//fail-safe Iterators Contrary to fail-fast Iterator, fail-safe iterator doesn't 
		//throw any Exception if Collection is modified structurally
		//while one thread is Iterating over it because they work on clone of Collection/
		//instead of original collection and that�s why they are called as fail-safe
		//iterator. Iterator of CopyOnWriteArrayList is an example of fail-safe Iterator
		//also iterator written by ConcurrentHashMap keySet is also fail-safe iterator
		//and never throw ConcurrentModificationException in Java.
		
		
	     //failSafeEx();
		int arr[] = {1,1,5};
		//addLeastSum(arr, arr.length);
		
		printSubString();
	}

	private static void failSafeEx()
	{
		CopyOnWriteArrayList<Integer> cc = new CopyOnWriteArrayList<Integer>(); 

	     cc.add(22);
	     
		addList();
		
		
		Iterator<Integer> iterator = cc.iterator();
	     
	     while (iterator.hasNext()) {
	    	 cc.add(44);
			Integer integer = (Integer) iterator.next();
			
			System.err.println("LIST "+integer);
			
		}
	}

	private static void sumOnlyNumbers()
	{
		String str = "123 Anshuman 456 Sharma 789";
		int sum = 0;

		char[] charArray = str.toCharArray();

		for (char c : charArray) {
			// System.err.println(c);
			try {
				sum += Integer.valueOf(String.valueOf(c));

			} catch (NumberFormatException e) {
			}
		}

		System.err.println("fffffff " + sum);

		sum = 0;
		String[] split = str.split(" ");
		for (String string : split) {
			System.err.println(string);

			try {
				sum += Integer.valueOf(string);
			} catch (NumberFormatException e) {
			}
		}

		System.err.println("SUM IS : " + sum);
	}

	public static void addList() {
 //fail-fast Iterators

		// Creating an empty ArrayList
		ArrayList<Integer> list = new ArrayList<Integer>();

		// Use add() method to add
		// elements into the list
		list.add(10);
		list.add(15);
		list.add(30);
		list.add(20);
		list.add(5);

		// Displaying the list
		System.out.println("The list is: \n" + list);

		// Create an iterator for the list
		// using iterator() method
		Iterator<Integer> iter = list.listIterator();

		// Displaying the values
		// after iterating through the list
		System.out.println("\nThe iterator values" + " of list are: ");
		while (iter.hasNext()) {
			list.add(44);
			System.out.print(iter.next() + " ");
		}

	}
	
	
	public static void addLeastSum(int[] arr, int n){
		int min = Integer.MAX_VALUE, seMin =Integer.MAX_VALUE;
		
		for (int i = 0; i < n; i++)
		{
			if(arr[i] < min){
				seMin = min;
				min = arr[i];
			}else if(arr[i] < seMin && arr[i] != min){
				seMin = arr[i];
			}
		}
		
		System.err.println("Minimum is: "+(min+seMin));
		
		System.err.println("\n SWAP NUMBERS \n");
		int a =1,b=2;
		
		int temp = 0;
		temp = a; a = b; b =temp;
		
		System.err.println(" a "+a+" b "+b);
		
		int x =3, y=5;
		
		x =x+y;
		y = x-y;
		x =x-y;
		
		System.err.println(" X "+x+" Y "+y);
		printLoops();
	}
       
	public static void printLoops(){
		System.err.println(" \n FOR LOOP");
		char ch = 'a';
		for (ch  = 'a'; ch <= 'z'; ch++)
		{
			System.err.print(" "+ch);
		}
		ch = 'a';
		System.err.println(" \n while LOOP ");
		while(ch <= 'z'){
			System.err.print(" "+ch);
			ch++;
		}
		
		char c = 'A';
		System.err.println(" \n DO WHILE LOOP");
		do
		{
			System.err.print(" "+c);
			c++;
		}
		while (c <= 'Z');
	}
	
	public static void printSubString(){
		
		String string, sub;
	      int i, j, length;
	         
	      Scanner in = new Scanner(System.in).useDelimiter("\\n");
	      System.out.println("Enter a string to print it's all substrings");
	      string  = in.nextLine();
	     
	      length = string.length();  
	 
	     // System.out.println("Substrings of \""+string+"\" are:");
	     
	      for (i = 0; i < length; i++)
	      {
	         for(j = 1; j <= length - i; j++)
	         {
	            sub = string.substring(i, i+j);
	            System.out.println(sub);
	         }
	      }
	}
	
}
