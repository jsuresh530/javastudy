package com.coreexamples.CoreJava;

import java.util.HashSet;

public class HashSetExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<String> hs = new HashSet<>();
			hs.add("suresh");
			hs.add("Suresh");
			hs.add(null);
			hs.add(null);
			
			
			System.err.println(hs.toString());

	}

}
