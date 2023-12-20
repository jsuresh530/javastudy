package com.coreexamples.CoreJava.examples;

import java.util.Scanner;

public class Positive_Negative {
	public static void main(String[] args) {

		System.out.print("Enter number - ");
		int num = new Scanner(System.in).nextInt();

		if (num >= 0)
			System.out.println(num + " is positive...");
		else if (num < 0)
			System.out.println(num + " is negative...");
	}
}
