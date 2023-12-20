package com.java8.strems.java8;

import java.util.Optional;

public class OptionalExample {
	
	public static void main(String[] args) {
		
		String[] string = new String[10];
		
		string[5] = "navaya rani";
		
		Optional<String> ofNullable = Optional.ofNullable(string[5]);
		
		ofNullable.ifPresent(System.out::println);
		if(ofNullable.isPresent())
		{
			System.err.println(string[5].toUpperCase());
		}
		else
		{
			System.err.println("String value is not available");
		}
	}

}
