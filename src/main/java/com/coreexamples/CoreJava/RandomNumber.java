package com.coreexamples.CoreJava;

import java.util.Random;

public class RandomNumber {

	public static void main(String[] args) {
		
		System.err.println(generateOTP(4));
	}

	public static String generateOTP(int len)
	{
		System.err.println((int)(Math.random()*9000)+1000);

		Random r =new Random();
		String s= "0123456789";
		char[] har =new char[9];
		for (int i = 0; i < len; i++) {
			har[i]= s.charAt(r.nextInt(s.length()));
		}
		
		return new String(har);
	}
}
