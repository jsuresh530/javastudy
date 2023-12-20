package com.other.algorithms;

import java.io.File;
import java.util.Scanner;


public class BasicAlgs
{

	public static void main(String[] args)
	{
		String configFilepath = "/home/suresh";
		System.out.println(configFilepath+File.separator);
		
		isArmStrongNumber();
		isPalindrome();
		//printPrimes();
		//System.out.println("\n "+findGCD(54,24));
		//System.out.println(countWords("Count of words is my"));
		
		System.out.print("Factorial is: "+fact(5));
		
		System.out.print("\n Factorial is: "+fact2(5));
	}

	private static int fact(int i)
	{
		if(i == 0)
		{
			return 1;
		}
		return i*fact(i-1);
	}

	private static int fact2(int i)
	{
		int result =1;
		while( i != 0)
		{
			result *= i;
			i--;
		}
		return result;
	}

	private static int countWords(String string)
	{
		if(string == null || string.isEmpty())
		{
			return 0;
		}
		String[] split = string.split("\\s+");
		return split.length;
	}

	private static int findGCD(int i, int j)
	{
		if(j == 0)
		{
			return i;
		}
		return findGCD(j, i%j);
	}

	private static void printPrimes()
	{
		System.out.println("Enter the number till which prime number to be printed: ");
	    @SuppressWarnings("resource")
		int limit = new Scanner(System.in).nextInt();
	    System.out.println("Printing prime number from 1 to " + limit);
	    
	    for (int number = 2; number <=limit; number++)
		{
	    	if(isPrime(number)){
	              System.out.println(number);
	          }
		}
	}

	private static boolean isPrime(int number)
	{
		for (int i = 2; i < number; i++)
		{
			if(number %i == 0)
			{
				return false; //number is divisible so its not prime
			}
		}
		return true;
	}

	private static void isPalindrome()
	{
		int number =121;
		int palindrome = number;
		int reverse =0;
		while(number != 0)
		{
			int remainder = number%10;
			reverse = reverse*10+remainder;
			number /= 10;
		}
		
		if (palindrome == reverse) {
			System.out.println("Number is a isPalindrome number....");
        }
	}

	private static void isArmStrongNumber()
	{
		int number =153;
		
		int result =0;
		int orignal = number;
		
		while(number != 0)
		{
			int remainder =number%10;
			result = result + (remainder*remainder*remainder);
			number /= 10;
		}
		if(orignal == result)
		{
			System.out.println("Number is a ArmStrong number...."+result+" "+orignal);
		}else
		{
			System.out.println("not an arm strong no ..."+orignal);
		}
	}
	
	
}
