package com.coreexamples.CoreJava;

/**
 * @author sjonnalagadda
 *
 */
public class ReverseInteger {

	public static void main(String[] args) {
		reverseInteger(1236);
	}

	public static void reverseInteger(int a) {
		
		int revnumber = 0;
		while(a != 0)
		{
			int digit = a%10;
			revnumber = revnumber*10+digit;
			a /= 10;
		}
		
		System.err.println(" revnumber: "+revnumber);
		

	}
}
