package com.coreexamples.CoreJava.examples;
public class pATTERN_3 {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (j >= (6 - i)) {
					System.out.print("*");
				} 
				if (j >(4 + i)) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}

			System.out.println();
		}
	}
}
