/**
 * 
 */
package com.other.algorithms;

import java.util.Map;
import java.util.TreeMap;


/**
 * @author sjonnalagadda
 *
 */
public class EcomTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Ecomm e =new Ecomm();
		e.setKey("122"); e.setName("hello");
		
		Map<String, String> map =new TreeMap<String, String>();
		map.put("primary-url", "sgnd.auruspay.com");
		
		
		System.err.println(map.get("primary-url"));
		
		System.err.println(getValue("secondary"));
	}
	
	public static String getValue(String value){
		String sendVal = "";
		
		switch (value)
		{
			case "primary":
				sendVal = "UAT42";
				break;
			case "secondary":
				sendVal = "fff43";
				break;
			default:
				break;
		}
		return sendVal;
		
	}
}
