package com.other.threads;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TestMap {

	public static void main(String[] args) {
		
		Employee e =new Employee("babu");
		Employee e2 =new Employee("babu");
		
		Map<Employee, String> hm =new HashMap<Employee, String>();
		hm.put(e, "babu");
		hm.put(e2, "babu");
		
		//System.err.println("...... "+isAnagram("suresh", "suresh1"));
		
		isAnagram2("abb", "bab");
	}
	
	static void isAnagram2(String s1, String s2){
		
		
		s1 =s1.toLowerCase();
		s2 =s2.toLowerCase();
		int[] letters =new int[1<<8]; //56 elements longeer 1 bye
		for (char c : s1.toCharArray()) {
			letters[c]++;
		}
		
		for (char c : s2.toCharArray()) {
			letters[c]++;
		}
		
		for (int i : letters) {
			if(i != 0)System.err.println("not anargam");
			else System.err.println("ananrgam");
		}
		
	}
	static boolean isAnagram(String s1, String s2){
		boolean isValue =false;
		s1 = s1.replace(" ", "");
		s2 = s2.replace(" ", "");
		
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		
		Arrays.sort(c1);
		Arrays.sort(c2);
		if(Arrays.equals(c1, c2)){
			
			isValue = true;
		}
		
		return isValue;
	}
	
	static void tomakeAnargam(String s1, String s2){
		int numberNeeded = numberNeeded(s1, s2);
		
		System.err.println("numberNeeded "+numberNeeded);
	}

	public static int getDelta(int arr[], int arr2[]){
		if(arr.length != arr2.length){
			return -1;
		}
		int delta =0;
		for (int i = 0; i < arr.length; i++) {
			int diff = Math.abs(arr[i] - arr2[i]);
			delta += diff;
		}
		return delta;
	}
	public static int numberNeeded(String s1, String s2){
		int[] arr = getCharCounts(s1);
		int[] arr2 = getCharCounts(s2);
		return getDelta(arr, arr2);
	}
	public static int[] getCharCounts(String s){
		int[] charCounts = new int[26];
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			int offset = (int)'a';
			int code = c - offset;
			charCounts[code]++;
		}
		//System.err.println("charCounts "+Arrays.toString(charCounts));
		return charCounts;
	}
}

class Employee{
	
	private String name;
	
	public Employee(String name){
		this.name =name;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}
	
	
}