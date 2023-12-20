package com.coreexamples.CoreJava.examples;
import java.util.Scanner;

public class String_In_PyramidShap {
public static void main(String[] args) {
	System.out.println("Enter String...");
	String s = new Scanner(System.in).nextLine();
	char[] ch = s.toCharArray();
	
	for (int i = 0; i < ch.length; i++) {
		for (int j = 0; j <= i; j++) {
			System.out.print(ch[j]);
		}
		System.out.println();
	}
	
	for (int i = 0; i < ch.length; i++) {
		for (int j = i; j < ch.length/2; j++) {
			System.out.print(" ");
		}
		for (int j = 0; j <= i; j++) {
			System.out.print(ch[j]);
		}
		for (int j = 0; j <= i; j++) {
			System.out.print(ch[j]);
		} 
		System.out.println();
	}
	
}
}
