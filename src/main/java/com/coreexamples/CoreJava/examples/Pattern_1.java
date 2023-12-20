package com.coreexamples.CoreJava.examples;
public class Pattern_1 {

	// --------- *
	// ------- * *
	// ----- * * *
	// --- * * * *
	// - * * * * *
	// * * * * * *

	public static void main(String[] args) {
		/******************  1  ******************/
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (j >= (6 - i)) {
					System.out.print(" * ");
				} else {
					System.out.print("   ");
				}
			}
			System.out.println();
		}
		/****************** 1 ******************/
		/****************** 2 ******************/
		for (int i = 1; i <= 5; i++) {
			for (int j = 5; j >= i; j--) {
				System.out.print("   ");
				// try System.out.print(" ");
			}
			for (int k = 1; k <= i; k++) {
				System.out.print(" " + k + " ");
			}
			System.out.println("");
		}
		/******************  2  ******************/
	}
}
