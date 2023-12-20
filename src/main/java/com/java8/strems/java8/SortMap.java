package com.java8.strems.java8;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SortMap {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		HashMap<Integer, String> hm =new HashMap<>();
		
		hm.put(1, "hyd");
		hm.put(Integer.valueOf("1"), "Bang");
		
		
		System.err.println(hm.get(1));
		
		HashMap<Integer, String> unSortTheMap = sortTheMap(new HashMap<>());
		
		System.err.println(unSortTheMap);
		
		//HashMap<Integer, String> sortMap = new HashMap<>(Collections.reverseOrder());		
		
		//sortMap.putAll(unSortTheMap);

		//System.err.println("------>  "+sortMap.toString());
		
		sortByJava8Way();
	}
	
	
	/**
	 * 
	 */
	public static void sortByJava8Way()
	{
		HashMap<Integer, String> unSortTheMap = sortTheMap(new HashMap<>());
		
		
		LinkedHashMap<Integer, String> unSortLM = new LinkedHashMap<>();
		
		unSortTheMap.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEachOrdered(x -> unSortLM.put(x.getKey(), x.getValue()));

		
	    System.out.println("Sorted Map   : " + unSortTheMap);

	}
	
	
	/**
	 * @param tm
	 * @return
	 */
	public static HashMap<Integer, String> sortTheMap(HashMap<Integer, String> tm)
	{
		tm.put(14, "suresh");
		tm.put(35, "Banana");
		tm.put(3, "kkj");
		tm.put(77, "ganesha");
		tm.put(22, "bbbbali");
		
		return tm;
	}

}
