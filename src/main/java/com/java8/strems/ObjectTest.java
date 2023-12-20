package com.java8.strems;

import java.util.HashMap;

interface Test
{
	int x =10;
}

public class ObjectTest{
	
	
	public void test()
	{
		System.err.println("testing happend");
	}

	public static void main(String[] args) {
		
		
		String test = "My name is . . , / @#";
		System.err.println(test.replaceAll("[@_,.#^/]", ""));
		
		
		//System.exit(0);

		String sur = "suresh";
		//System.err.println(sur.hashCode()+" "+ (sur.hashCode() & (16-1)));
		
		HashMap<String, String> hm = new HashMap<>();
		//Test.x = 20;
		System.err.println();
		String s = "Suresh";
		String s2 = "Suresh";
		
		String s3 = new String("Suresh1");
		
		s2 = s2.concat("babu");
		
		System.err.println(s2);
		
		System.err.println(s.hashCode()+" "+s3.hashCode());
	}
	

}
