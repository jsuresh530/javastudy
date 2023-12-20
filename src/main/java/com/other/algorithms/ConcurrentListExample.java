package com.other.algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class ConcurrentListExample
{
	//59 11 * * *
    //m h  day(month) month day(week)
	// 59 23 * * * ? 	Fire at 12pm (noon) every day
	//44 3 * * *
	
	 public static void main(String[] args) 
	 {
	        concurrentListExample();
	  }

	private static void concurrentListExample()
	{
		List<String> list = new ArrayList<>();
		list.add("1");
		list.add("2");
		list.add("3");
		list.add("4");
		list.add("5");
		
		// get the iterator
		Iterator<String> it = list.iterator();
		
		//manipulate list while iterating
		while(it.hasNext()){
		    System.out.println("list is:"+list);
		    String str = it.next();
		    System.out.println(str);
		   if(str.equals("2"))list.add(" 2 found");
		  //  if(str.equals("2"))list.remove("2");
		    //if(str.equals("3"))list.add("3 found");
		    //below code don't throw ConcurrentModificationException
		    //because it doesn't change modCount variable of list
		    if(str.equals("5")) list.set(4, "55");
		    
		}
		
		System.out.println(list.toString());
	}
}
