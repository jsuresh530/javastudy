package com.coreexamples.CoreJava.examples;
public class Pattern_2 {
	public static void main(String[] args) {

		/************** 1 **************/
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= 5; j++) {
				if (j >= i)
					System.out.print("1");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		/************** 1 **************/

		/************** 2 **************/
		for (int i = 1; i <= 5; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			for (int j = 5; j >= i; j--) {
				System.out.print("2");
			}
			System.out.println();
		}
		/************** 2 **************/
	}
}
