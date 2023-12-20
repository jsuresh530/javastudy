

package com.other.algorithms;

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

class Practice
{

	public static void main(String[] args) throws IOException
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of lines ....");
		int t = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < t; i++)
		{
			System.out.println("Enter string ...");
			String s = sc.next();
			int n = sc.nextInt();
			int m = sc.nextInt();
			char og[] = s.toCharArray();
			String dup = s.substring(n, m + 1);
			char c[] = dup.toCharArray();
			Arrays.sort(c);
			for (int j = 0; j < s.length(); j++)
			{
				if ((j >= n) && (j <= m))
				{
					og[j] = c[m - j];
				}
			}
			System.out.println(og);
		}
	}
}