package com.coreexamples.CoreJava.examples;

public class ExamplePattenr {

	public static void main(String[] args) {

		/*
		 * for (int i = 1; i <= 5; i++) { for (int j = 1; j <= i; j++) {
		 * System.out.print(" *"); } System.out.println(); }
		 */

		/*
		 * for (int i = 1 ; i <= 5 ; i++) { for (int j = 5; j >=i; j--) {
		 * System.out.print(" *"); } System.out.println(); }
		 */

		for (int i = 1; i <= 5; i++) {

			for (int j = 1; j <= i; j++) {
				if (j % 2 == 0) { 
					System.out.print(" 1");
				} else {
					System.out.print(" 0");
				}
			}
			System.out.println();
		}

		/*
		 * for (int i = 1; i <= 5; i++) { for (int j = 1; j <= i; j++) {
		 * System.out.print(" "); } for (int j = 5; j >= i; j--) {
		 * System.out.print("*"); } System.out.println(); }
		 */
		/*
		 * for (int i = 1; i <= 5; i++) { for (int j = 5; j >= i; j--) {
		 * System.out.print(" "); } for (int j = 1; j <= i; j++) {
		 * System.out.print("*"); } for (int j = 2; j <= i; j++) {
		 * System.out.print("*"); } System.out.println(); }
		 */

		/*
		 * int noOfRows = new Scanner(System.in).nextInt(); int rowCount = 1;
		 * 
		 * for (int i = noOfRows; i >0; i--) { for (int j = 1; j <= i; j++) {
		 * System.out.print(" "); } for (int j = 1; j <= rowCount; j++) {
		 * System.out.print( " " +j); } System.out.println(); rowCount++; }
		 */

	}
}
