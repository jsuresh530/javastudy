package com.coreexamples.CoreJava;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

final class Student {

	// Member attributes of final class
	private final String name;
	private final int regNo;
	private final Map<String, String> metadata;

	// Constructor of immutable class
	// Parameterized constructor
	public Student(String name, int regNo, Map<String, String> metadata) {

		// This keyword refers to current instance itself
		this.name = name;
		this.regNo = regNo;

		// Creating Map object with reference to HashMap
		// Declaring object of string type
		Map<String, String> tempMap = new HashMap<>();

		// Iterating using for-each loop
		for (Map.Entry<String, String> entry : metadata.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}

		this.metadata = tempMap;
	}

	// Method 1
	public String getName() {
		return name;
	}

	// Method 2
	public int getRegNo() {
		return regNo;
	}

	// Note that there should not be any setters

	// Method 3
	// User -defined type
	// To get meta data
	public Map<String, String> getMetadata() {

		// Creating Map with HashMap reference
		Map<String, String> tempMap = new HashMap<>();

		for (Map.Entry<String, String> entry : this.metadata.entrySet()) {
			tempMap.put(entry.getKey(), entry.getValue());
		}
		return tempMap;
	}
}

public final class ImmutableExample {

	public static void main(String[] args) {
		
		int[] no = {7,5,2,1};
		int index =0;
		Arrays.sort(no);
		for (int i = 1; i < no[no.length-1]; i++) {
			if(i == no[index])
			{
				index++;
			}
			else
			{
				System.err.print(i+" ");
			}
			
		}
		
		//Missing elemnt
		
		int [] no1 = {7,5,2,1};
		int n =no1.length;
		int missed = 0;
		for (int i = 0; i < n; i++) {
			int index1 =i+1;
			if(no1[i] != index1)
			{
				missed =index;
				break;
			}
		}
		
		
		System.err.println("\n missed :  "+missed);

		Map<String, String> hm = new HashMap<>();
		
		hm.put("name", "suresh");
		hm.put("age", "22");
		
		Student example = new Student("suresh",123,hm);
		System.err.println(example.getName());
		System.err.println(example.getRegNo());
		System.err.println(example.getMetadata());
		
		hm.put("1", "bbaa");
		
		
		System.err.println(example.getMetadata());
		
		System.err.println();
		
	}

}
