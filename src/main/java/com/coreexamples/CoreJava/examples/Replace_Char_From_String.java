package com.coreexamples.CoreJava.examples;
import java.util.Scanner;

public class Replace_Char_From_String {
	public static void main(String[] args) {

		System.out.println("Enter a string...");
		String oldString = new Scanner(System.in).next();
		char[] ch = oldString.toCharArray();

		System.out.println("Enter character which you want to replace...");
		char oldChar = new Scanner(System.in).next().charAt(0);

		System.out.println("Enter new character...");
		char newChar = new Scanner(System.in).next().charAt(0);

		String newString = "";

		for (int i = 0; i < ch.length; i++) {
			if (ch[i] == oldChar) {
				ch[i] = newChar;
			}
			newString = newString + ch[i];
		}
		System.out.println(newString);
		/*
		 * for (int i = 65; i <= 90; i++) { System.out.println((char)i); }
		 */

	}
}
