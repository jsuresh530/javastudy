package com.other.files;


public class LRCExample
{

	public static void main(String[] args)
	{
		System.out.println(lrc2hex("SURESH ABABU  J"));
	}
	
	public static String lrc2hex (String str) 
	{
	    byte[] bytes = str.getBytes ();
	    int lrc = 0;
	    for (int i = 0; i < str.length (); i++) 
	    {
	        lrc ^= (bytes[i] & 0xFF);
	    }
	    return String.format ("%02X ", lrc);
	}
	
}
