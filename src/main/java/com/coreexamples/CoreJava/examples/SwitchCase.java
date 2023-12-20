package com.coreexamples.CoreJava.examples;
public class SwitchCase {


		public static void main(String[] args) {
			String s = "a";
			switch (s) {
			case "a":
				int i = 10;
				switch (i) {
				case 1:
					System.out.println("1");
					break;
				case 3:
					System.out.println("3");
					break;
				case 7:
					System.out.println("7");
					break;
				case 10:
					System.out.println("10");
					break;

				default:
					break;
				}
				System.out.println("a");
			case "b":
				System.out.println("b");
			case "c":
				System.out.println("c");
			case "d":
				System.out.println("d");
			case "e":
				System.out.println("e");
			default:
				System.out.println("Default");
			}

		}
}
