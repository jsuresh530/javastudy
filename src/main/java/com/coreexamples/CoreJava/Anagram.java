package com.coreexamples.CoreJava;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

public class Anagram {
	
    static int NO_OF_CHARS = 256;


	public static void main(String[] args)  
	{
		
	try {
		  Class c = Class.forName("LoopsExample");  
		    Object o= c.newInstance();  
		    Method m =c.getDeclaredMethod("sum", null);  
		    m.setAccessible(true);  
		    m.invoke(o, null);  
	} catch (Exception e) {
		// TODO: handle exception
	}
		System.exit(0);
		if(isAnagram("listen", "silent"))
			System.err.println("Anagrams of each other");
		else
			System.err.println("Not Anagrams of each other");
		
		//isAnagram1("listen", "silent");
		//countWords("MY B us suresh babu");
		
		
		countRepeatedCharCount("su su ssssss babu");
	}
	
	public static boolean isAnagram(String s1, String s2)
	{
		char[] charArray1 = s1.toCharArray();
		char[] charArray2 = s2.toCharArray();
		
		int len1 =charArray1.length;
		int len2 = charArray2.length;
		
		if(len1 != len2)
		return false;
		
		Arrays.sort(charArray1);
		Arrays.sort(charArray2);
		
		System.err.println(Arrays.toString(charArray1));
		System.err.println(Arrays.toString(charArray2));
		for (int i = 0; i < len1; i++) {
			if(charArray1[i] != charArray2[i])
				return false;
		}
		return true;
	}

	
	public static void isAnagram1(String s1, String s2)
	{
		//char k = 'a'; //65, 97
		
		char k = 'z'; //90, 122
		System.err.println((int)k);
		System.err.println(" ======================================== \n");
		char[] charArray1 = s1.toCharArray();
		char[] charArray2 = s2.toCharArray();
		
		int len1 = charArray1.length;
		int len2 = charArray2.length;
		
		int[] count1 = new int[NO_OF_CHARS];
		
		if(len1 != len2)
		{
			System.err.println("EXIT");
			System.exit(0);
		}
		
		for (int i = 0; i < len1; i++) 
		{
			count1[charArray1[i] - 'a']--;
			count1[charArray2[i] - 'a']++;
		}
		
		
		for (int i = 0; i < NO_OF_CHARS; i++) 
		{
			
			if(count1[i] != 0)
			{
				System.err.println("YES "+(i+1));
			}
			else
			{
				System.err.println("NOT "+(i+1));
			}
		}
	}
	
	/**
	 * @param str
	 */
	public static void countWords(String str)
	{
		int count = 0;
		for (int i = 0; i < str.length(); i++) 
		{
			if((i > 0) && ((str.charAt(i) != ' ') && str.charAt(i-1) == ' ') || (str.charAt(i) != ' ' && i == 0))
			{
				count++;
			}
		}
		
		System.err.println("no of words : "+count);
	}
	
	/**
	 * @param str
	 */
	public static void countRepeatedCharCount(String str)
	{
		int count = 0;
		String s = "su";
		
		String[] split = str.split(" ");
		for (String string : split) {
			if(string.equalsIgnoreCase(s))
			{
				count++;
			}
		}
		
		System.err.println("Repeated word count : "+count);
		
		
		char[] charArray = str.toCharArray();
		count = 0;
		for (char c : charArray) {
			if(c == 's')
			{
				count++;
			}
		}
		
		System.err.println("repeated char count : "+count);
		
		// Print all the repeated chars 
		
		String k = "suresh babu jjjjjj";
		
		int [] temp = new int[NO_OF_CHARS];
		
		for (char i : k.toCharArray()) {
			temp[i]++;
		}
		//System.err.println(Arrays.toString(temp));
		
		for (int i = 0; i < temp.length; i++) {
			if(temp[i] != 0)
			{
				System.err.println("Reapeted char "+(char)i+" count : "+temp[i]);
			}
		}
		
		//Count ....
		
		long count1 = k.chars().filter(ch -> ch == 'j').count();
		
		System.err.println("count : "+count1);
		
		
		HashMap<Character, Integer> hm = new HashMap<>();
		
		for (int i = 0; (i < k.length() ); i++) {
			
			if(hm.containsKey(k.charAt(i)))
			{
				System.err.println(hm.get(k.charAt(i)));
				hm.put(k.charAt(i), hm.get(k.charAt(i))+1);
			}
			else
			{
				if(k.charAt(i) != ' ')
				hm.put(k.charAt(i), 1);
			}
			
		}
		
		//char search = 'a';  
		//Integer result = hm.get(search);
	}

	public static int[] fibnaci()
	{
		int febCount = 5;

		if(febCount < 0){
			throw new IllegalArgumentException("n should be a postive number");
		}

		int[] feb = new int[febCount];
		feb[0] = 0;
		feb[1] = 1;

		for (int i = 2; i < febCount; i++)
		{
			feb[i] = feb[i-1]+feb[i-2];
		}
		return feb;

	}
}