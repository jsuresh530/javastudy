package com.coreexamples.CoreJava.examples;
import java.util.Scanner;

public class Days_in_Month {
public static void main(String[] args) {
	
	int TotalDays = 365;
	int Months = 12;
	int MonthDays = TotalDays / Months;
	int RemainDays = TotalDays % Months;
	
	System.out.println("Average Days in a month - " + MonthDays);
	System.out.println("Extra days - " + RemainDays);
	
	System.out.println("Enter name of Month from below - \n"
			+ "1.Jan   "
			+ "2.Feb   "
			+ "3.March  "
			+ "4.Apr   "
			+ "5.May   "
			+ "6.June   "
			+ "7.July   "
			+ "8.Aug   "
			+ "9.Sep   "
			+ "10.Oct   "
			+ "11.Nov   "
			+ "12.Dec");

	String month = new Scanner(System.in).next();
	
	switch(month){
	case "Jan":
		System.out.println("31 - Days in - " + month);
		break;	
	case "Feb":
		System.out.println("28 or 29 - Days in - " + month );
		break;
	case "March":
		System.out.println("31 - Days in - " + month );
		break;
	case "Apr":
		System.out.println("30 - Days in - "  + month );
		break;
	case "May":
		System.out.println("31 - Days in - "  + month );
		break;
	case "June":
		System.out.println("30 - Days in - "  + month );
		break;
	case "July":
		System.out.println("31 - Days in - " + month );
		break;
	case "Aug":
		System.out.println("31 - Days in - "  + month );
		break;
	case "Sep":
		System.out.println("30 - Days in - "  + month );
		break;
	case "Oct":
		System.out.println("31 - Days in - "  + month );
		break;
	case "Nov":
		System.out.println("30 - Days in - " + month );
		break;
	case "Dec":
		System.out.println("31 - Days in - " + month );
		break;
		default: 
			System.out.println("Enter valid Name of Month From List...");
	}

	}
}
