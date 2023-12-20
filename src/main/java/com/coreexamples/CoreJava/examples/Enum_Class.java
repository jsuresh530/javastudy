package com.coreexamples.CoreJava.examples;
public class Enum_Class {
	public enum Day {sunday, monday, tuesday, wednesday, thrusday, friday, saturday, Today};

	public static void main(String[] args) {
		Day[] dayNow = Day.values();

		for (Day day : dayNow) {
			switch (day) {
			case sunday:
				System.out.println("1");
				break;
			case monday:
				System.out.println("2");
				break;
			case tuesday:
				System.out.println("3");
				break;
			case wednesday:
				System.out.println("4");
				break;
			case thrusday:
				System.out.println("2");
				break;
			case friday:
				System.out.println("5");
				break;
			case saturday:
				System.out.println("6");
				break;
			default:
				System.out.println("Default - Today");
				break;
			}
		}
	}
}
