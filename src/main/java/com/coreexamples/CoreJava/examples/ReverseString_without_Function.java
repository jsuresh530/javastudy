package com.coreexamples.CoreJava.examples;
import java.util.Scanner;

public class ReverseString_without_Function {
	public static void main(String[] args) {
		System.out.println("Enter a string to reverse...");
		String s = new Scanner(System.in).next();
		char[] ch = s.toCharArray();
		String rev ="";
		for (int i = ch.length-1; i >= 0; i--) {
			rev = rev + ch[i];
		}
		System.out.println(rev);

	}
}
