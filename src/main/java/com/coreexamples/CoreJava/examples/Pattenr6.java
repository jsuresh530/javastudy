package com.coreexamples.CoreJava.examples;

public class Pattenr6 {
public static void main(String[] args) {
	for (int i = 1; i <= 6; i++) {
		for (int j = i; j <= 6; j++) {
			System.out.print(" ");
		}
		for (int j = 1; j <= i; j++) {
			System.out.print("*");
		}
		for (int j = 2; j <=i; j++) {
			System.out.print("*");
		}
		System.out.println();
	}
}
}
