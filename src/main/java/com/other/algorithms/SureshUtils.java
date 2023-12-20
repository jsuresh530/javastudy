package com.other.algorithms;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Stack;


public class SureshUtils
{

	public static void main(String[] args)
	{
		//stringToBinary();
		//binaryToDecimal(10001110); //254          128 64 32 16 8 4 2 1
		//System.out.println(Math.pow(2, 7));
		// Divisor 5,Dividend 10, Quotient 2, Remainder 0
	//	System.out.println((10/5)+" ---> "+(10%5));
		
		decimalToBinary(8);
	}
	
	public static void stringToBinary()
	{
		// A 65, Z 90 a 97 z 122
		String s = "8";
		String s2 = "suresh";
		
		String s3 = new String("hello");
		String s4= new String("hello");
		
		System.out.println(s == s2);
		System.out.println(s.equals(s2));
		
		System.out.println(s3 == s4);
		System.out.println(s3.equals(s4));
		
		
		byte[] bytes = s.getBytes();
		  StringBuilder binary = new StringBuilder();
		for (byte b : bytes)
		{
			int val =b;
			for (int i = 0; i < 8; i++)
			{
				//System.out.println(val & 128);
				binary.append((val & 128) == 0 ? 0 : 1);
				val <<= 1;
			}
			binary.append(" ");
		}
		System.out.println("'"+s+"' to binary : "+binary.toString());
		System.out.println("To String : "+Arrays.toString(bytes)+" String : "+new String(bytes));
		
		BigInteger bi = new BigInteger(bytes);
		String sf = bi.toString(); 
		
		System.out.println(sf);
	}
	
	public static void binaryToDecimal(int n)
	{
		int decimal = 0, power =0;
		while(n != 0)
		{
			decimal += ((n%10)*Math.pow(2, power));
			n=n/10;
			power++;
		}
		System.out.println("Decimal "+decimal);
	}
	
	public static void decimalToBinary(int n)
	{
		int k = 8; //0000 1000          --->                 128 64 32 16 8 4 2 1 [255 bits]
		//left shift shifts a bit left side , right shift right [ without shifting ]
		System.out.println((k<<2)+" "+(k>>2)+" "+(k>>>2));
		System.out.println("\n");
		Stack<Integer> stack = new Stack<Integer>();
		int result =0;
		while(n!=0)
		{
			System.out.println(" n is : "+n);
			result = n%2;
			stack.push(result);
			n /= 2;
		}
		System.out.print("\nBinary representation is:");
	    while (!(stack.isEmpty()))
	    {
	      System.out.print(stack.pop());
	    }
	    //System.out.println();
	  }
	
}
