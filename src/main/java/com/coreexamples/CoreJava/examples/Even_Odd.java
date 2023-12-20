
package com.coreexamples.CoreJava.examples;
import java.util.Scanner;

public class Even_Odd {
	public static void main(String[] args) {
		System.out.print("Enter number - ");
		int num = new Scanner(System.in).nextInt();
		if (num % 2 == 0)
			System.out.println(num + " is Even...");
		else
			System.out.println(num + " is Odd...");
	}
}
