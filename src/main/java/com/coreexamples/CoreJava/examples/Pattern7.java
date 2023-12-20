package com.coreexamples.CoreJava.examples;
public class Pattern7 {
	public static void main(String[] args) {

		for (char i = 65; i < 70; i++) {
			for (char j = i; j < 70; j++) {
				System.out.print(" " + j);
			}
			System.out.println();
		}
	}
}
