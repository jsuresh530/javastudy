package com.coreexamples.CoreJava.examples;
public class Pattern_4 {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (j >= (6 - i) || j >= (4 + i)) {
					System.out.print(" ");
				} else {
					System.out.print("*");
				}
			}

			System.out.println();
		}
		/*************************************************/

		for (int i = 1; i <= 5; i++) {
			for (int j = 5; j >= i; j--) {
				System.out.print("*");
			}
			for (int j = 2; j <= i; j++) {
				System.out.print(j);
			}
			for (int j = 1; j <= i; j++) {
				System.out.print(j);
			}
			for (int j = 5; j >= i; j--) {
				System.out.print("*");
			}
			System.out.println();
		}
		
		System.out.println("\n");
		/************************************************/
		for (int i = 1; i <= 5; i++) {
			for (int j = 5; j >= i; j--) {
				System.out.print(" *");
			}
			for (int j = 2; j <= i; j++) {
				System.out.print("  ");
			}
			for (int j = 1; j <= i; j++) {
				System.out.print("  ");
			}
			for (int j = 5; j >= i; j--) {
				System.out.print(" *");
			}
			System.out.println();
		}
	}
}
