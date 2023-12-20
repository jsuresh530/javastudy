package com.other.algorithms;

import java.net.HttpURLConnection;
import java.net.URL;


public class URLread
{
	
	public static void main(String[] args)
	{
		System.err.println(isNetworkUP());
	}
	
	
	public static boolean isNetworkUP() {
	   // String strUrl = "https://uat42.auruspay.com";
	    String strUrl = "https://sgnd42.auruspay.com/";
	    HttpURLConnection urlConn = null;
	    boolean isNetwork = false;
	    try {
	        URL url = new URL(strUrl);
	        urlConn = (HttpURLConnection) url.openConnection();
	        
	        urlConn.setRequestMethod("GET");
	        urlConn.setConnectTimeout(3000);
	        urlConn.connect();
	        isNetwork = true;
	       // System.err.println("YES");
 	       // System.err.println("STATUS "+urlConn.getResponseCode());
 	        
	       /* for (int i = 0; i < 10; i++)
			{
	        	urlConn.connect();
	 	        System.err.println("urlConn.HTTP_OK "+urlConn.getResponseCode()+" times "+i);
	 	        Thread.sleep(1000);
			}*/

	    } catch (Exception e) {
	    	System.err.println("Error creating HTTP connection "+e.getLocalizedMessage());
	    	return isNetwork;
	    }
		return isNetwork;
	}
}
