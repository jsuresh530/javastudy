

package com.coreexamples.CoreJava.examples;

import java.util.Scanner;

public class Alphabate_Consonant
{

	public static void main(String[] args)
	{
		String s = "ab";
		// hashcode = s[0]*31^(n-1) + s[1]*31^(n-2) + ... + s[n-1]
		/*
		 * s[0]*31^(2) + s[1]*31^1 + s[0] = G*31^2 + F*31 + G = (as ASCII value of G = 71 and F = 70) 71*31 [power] 2 + 70*3 [power ]1 + 71 = 68231 + 2170 + 71 = 70472
		 */
		System.err.println(" --- " + s.hashCode() + " \n ");
		char ch = 0;
		do
		{
			System.out.println("Enter a character from [a to z] or [A to Z]...");
			String str = new Scanner(System.in).next();
			int len = str.length();
			if (len > 1)
			{
				System.out.println("Enter a character only...");
			}
			else
			{
				ch = str.charAt(0);
				if (ch >= 'a' && ch <= 'z' || ch >= 'A' && ch <= 'Z') // a-z -> 65-90 A-Z -> 97-122
				{
					if (ch == 'a' || ch == 'A')
						System.out.println("Vowel");
					else if (ch == 'e' || ch == 'E')
						System.out.println("Vowel");
					else if (ch == 'i' || ch == 'I')
						System.out.println("Vowel");
					else if (ch == 'o' || ch == 'O')
						System.out.println("Vowel");
					else if (ch == 'u' || ch == 'U')
						System.out.println("Vowel");
					else
						System.out.println("Consonant...");
				}
			}
		}
		while (ch != 'q');
	}
}
/*
 * 65 - 90 97 - 122
 */