

package com.other.algorithms.asymetric;

public class DosEquis
{

	public static void main(String[] args)
	{
		char x = 'X'; int i =0;
		System.err.println(true ? x :0 );
		System.err.println(false ? i : x);
		
		System.err.println("H" + "Y");
		System.err.println('X'+ 'X'); // ASCII 2 text X = 88
		
		StringBuffer sb =new StringBuffer();
		sb.append('X'); sb.append('X');
		System.err.println("1 "+sb);
		
		sb =new StringBuffer();
		sb.append("H"); sb.append("Y");
		System.err.println("2 "+sb);
		

	}
}
