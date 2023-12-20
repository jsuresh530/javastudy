package com.coreexamples.CoreJava; /**
 * 
 */
/**
 * @author sjonnalagadda
 *
 */
public class AsciiTOHex
{

	/**
	 * https://www.baeldung.com/java-convert-hex-to-ascii
	 * 
	 * @param args
	 */
	public static void main(String[] args)
	{
		asciiToHex("suresh babu");
		hexToAscii("525550415920494E5420504C4154494E554D2020202020202020 ");
	}

	/**
	 * @param string
	 */
	private static void hexToAscii(String string)
	{
		string = string.trim();
		StringBuilder output = new StringBuilder("");
		for (int i = 0; i < string.length(); i += 2)
		{
			String substring = string.substring(i, i + 2);
			//System.err.println(substring);
			output.append((char) Integer.parseInt(substring, 16));
		}
		System.err.println(output);
	}

	/**
	 * @param string
	 */
	private static void asciiToHex(String string)
	{
		char[] charArray = string.toCharArray();
		StringBuilder hex = new StringBuilder();
		for (char c : charArray)
		{
			hex.append(Integer.toHexString(c));
		}
		System.err.println(hex);
	}
}
