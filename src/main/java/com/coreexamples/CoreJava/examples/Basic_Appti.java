package com.coreexamples.CoreJava.examples;
public class Basic_Appti {
	public static void main(String[] args) {
		int a = 8;
		int b = 10;
		System.out.println(a & b);
		System.out.println(a | b);
		System.out.println(a ^ b);
		System.out.println(~a);
		System.out.println(~b);
		
		/*
		 *  1  2  4  8  16  32
		 *  
		 *  0  0  0  1			->   8	- (a)
		 *  0  1  0  1			->   10	- (b)
		 * ------------
		 *  0  0  0  1			->   a & b
		 *  0  1  0  1			->   a | b
		 *  0  1  0  0			->   a ^ b
		 *  
		 *  -(8 + 1) = -9		->   ~a
		 *  -(10 + 1)= -10		->   ~b
		 * 
		 * */
		
	}
}
