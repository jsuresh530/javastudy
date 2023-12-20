package com.other.algorithms;

import java.util.Arrays;

public class StringReverse {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s = "suresh";
		usingCharArray(s);
	}

	public static void usingCharArray(String input) {
		char[] charArray = input.toCharArray();

		char[] result = new char[charArray.length];
		int len = charArray.length;
		for (char c : charArray) {
			result[len - 1] = c;
			len--;
		}
		System.out.println(Arrays.toString(result)+"  "+new String(result));

	}
	
	public static void usingByteArray(String input) {
		byte[] charArray = input.getBytes();

		byte[] result = new byte[charArray.length];
		int len = charArray.length;
		for (byte c : charArray) {
			result[len - 1] = c;
			len--;
			//System.out.println(len+"count "+count);
		}
		System.out.println(Arrays.toString(result)+""+new String(result));

	}
	
	public static void usingStringBuilder(String input)
	{
		String[] split = input.trim().split("");
		StringBuilder sb = new StringBuilder();
		
		for(int i = split.length - 1; i >= 0;i--)
		{
			sb.append(split[i]).append("");
		}
		System.out.println(sb.toString());
		
	}

}
