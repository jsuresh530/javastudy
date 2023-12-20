package com.other.algorithms;

import org.apache.commons.codec.binary.Hex;

import javax.xml.bind.DatatypeConverter;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.HashMap;


public class ArrayCopies
{
	private final static char[] hexArray = "0123456789ABCDEF".toCharArray();
	public static void main(String[] args)
	{
		
		String kk = "30010506";
		
		System.err.println(kk.substring(0, kk.length()-2));
		
		byte [] cctResponse = null;

		byte[] arr ={0x46, 0x31, 0x2e, 0x00, 0x02, 0x05, 0x00 }; 
		//[70, 49, 46, 0, 2, 5, 0] 
		//arr[arr.length-1] = 0x31;
		//[70, 49, 46, 0, 2, 5, 49] 
		System.err.println(Arrays.toString(arr)+" ;;;;;;;;"+arr[arr.length-7]+" ---> length ---> "+arr[0]);
		
		
		//tcpxCCTSerialManager.writeSerial(arr);
		
		String s = "2530010010000";
		
		System.err.println(s);
		printPrimes(10);
		
		for (int i = 2; i <10; i++) {
			printPrimes(i);
			System.out.print(i+" ");
		}
	    HashMap hMap = new HashMap();
	    hMap.put("jj", "kk");
	    
	    System.err.println("\n"+hMap);

		if(args.length > 0)
		{
			System.out.println("args not empty ...");
		}else
		{
			System.out.println("args  empty ...");
		}
		
		//copyArrayFromTo();
		
		//stringToHexadecimal(s);
		
		//stringToByte(s);
		
	}
	

	public static String bytesToHex(byte[] bytes) {
	    char[] hexChars = new char[bytes.length * 2];
	    for (int j = 0; j < bytes.length; j++ ) {
	        int v = bytes[j] & 0xFF;
	        hexChars[j * 2] = hexArray[v >>> 4];
	        hexChars[j * 2 + 1] = hexArray[v & 0x0F];
	    }
	    return new String(hexChars);
	}
	
	public static byte[] hexStringToByteArray(String s) {
	    int len = s.length();
	    byte[] data = new byte[len / 2];
	    for (int i = 0; i < len; i += 2) {
	      data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4)
	        + Character.digit(s.charAt(i+1), 16));
	    }
	   // System.err.println("data "+data);
	  return data;
	  } 
	
	public static void stringToByte(String str) {
		  byte[] b = str.getBytes();
		  System.out.println("Array " + b);
		  System.out.println("Array as String" + Arrays.toString(b));
		  
		  //hexadecimal
		  String foo = "I am a string";
		  byte[] bytes = foo.getBytes();
		  System.out.println( Hex.encodeHexString( bytes ) );
	}
	
	public static String stringToHexadecimal(String text)
	{
	    byte[] myBytes;
	    String printHexBinary = null;
		try
		{
			myBytes = text.getBytes("UTF-8");
			 printHexBinary = DatatypeConverter.printHexBinary(myBytes);
		    System.err.println(" printHexBinary ::: "+printHexBinary);
		    // printHexBinary ::: 32353330303130303130303030

		}
		catch (UnsupportedEncodingException e)
		{
			e.printStackTrace();
		}
	    return printHexBinary;
	}
	
	
	private static boolean printPrimes(int n)
	{
		boolean isPrime = true;
		for (int i = 2; i < n; i++) {
			if(n%i == 0)
				return false;
		}
		return isPrime;
	}

	private static void copyArrayFromTo()
	{
		int [] src = {10, 20,30,40,50,60};
		int [] desc = {70,80,90,100,110,120};
		
		System.out.println("src array printing, index start from zero ::  "+src[0]);
		for (int i = 0; i < src.length; i++)
		{
			System.out.print(" "+src[i]);
		}
		System.out.println("\n desc array printing index start from zero :: "+desc[0]);
		for (int i = 0; i < desc.length; i++)
		{
			System.out.print(" "+desc[i]);
		}
		
		int source_arr[], sourcePos, dest_arr[], destPos, len;
		
		source_arr = src;
		sourcePos = 2;
		dest_arr = desc;
		destPos = 2;
		len = 4;
		
		System.arraycopy(source_arr, sourcePos, dest_arr, destPos, len);
		
		
		System.out.println("\n desc array printing ");
		for (int i = 0; i < desc.length; i++)
		{
			System.out.print(" "+desc[i]);
		}
		
	}
}
