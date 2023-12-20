package com.coreexamples.CoreJava.examples;

import java.util.Scanner;

public class Greatest_Smallest {
public static void main(String[] args) {
	System.out.print("Enter first number - ");
	int a = new Scanner(System.in).nextInt();
	System.out.print("Enter second number - ");
	int b = new Scanner(System.in).nextInt();
	System.out.print("Enter third number - ");
	int c = new Scanner(System.in).nextInt();
	
	if(a>b)
		if(a>c)
			System.out.println(a + " is greater...");
		else
			System.out.println(c + " is greater...");
	else if(b>c)
		System.out.println(b + " is greater...");
	else
		System.out.println(c + " is greater...");
	
	if(a<b)
		if(a<c)
			System.out.println(a + " is smallest...");
		else
			System.out.println(c + " is smallest...");
	else if(b<c)
		System.out.println(b + " is smallest...");
	else
		System.out.println(c + " is smallest...");
	
	
/*	if(a>b && a>c)
		System.out.println(a + " is greater...");
	else if(b>a && b>c)
		System.out.println(b + " is greater...");
	else if(c>a && c>b)
		System.out.println(c + " is greater...");
	
	if(a<b && a<c)
		System.out.println(a + " is smallest...");
	else if(b<a && b<c)
		System.out.println(b + " is smallest...");
	else if(c<a && c<b)
		System.out.println(c + " is smallest...");*/
	
	
}
}
