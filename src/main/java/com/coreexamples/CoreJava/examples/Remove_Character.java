package com.coreexamples.CoreJava.examples;
import java.util.Scanner;

public class Remove_Character {
	public static void main(String[] args) {

		System.out.println("Enter String...");
		String oldString = new Scanner(System.in).next();
		char[] ch = oldString.toCharArray();

		System.out.println("Enter character which you want to remove...");
		char c = new Scanner(System.in).next().charAt(0);

		String newString = "";

		for (int i = 0; i < ch.length; i++) {
			if (ch[i] != c) {
				newString = newString + ch[i];
			}
		}
		System.out.println(newString);
	}
}
