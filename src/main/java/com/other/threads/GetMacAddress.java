

package com.other.threads;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.InetAddress;

public class GetMacAddress
{
	private String userName;

	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	public static void main(String[] args)
	{
		//getIpAddress();
		
		//executeCommand();
		
		ReadObjectFromFile();
	}

	private static void getIpAddress()
	{
		InetAddress inetAddress = null;
		try
		{
			inetAddress = InetAddress.getLocalHost();
			System.out.println("Current IP : " + inetAddress.getHostAddress());
		}
		catch (Exception e)
		{
		}
	}
	
	
	private static String executeCommand() {
		String domainName = "google.com";
		String command = " ping -c 4" + domainName;
		StringBuffer sb =new StringBuffer();
		Process p = null; 
		
		String line = "";
		try{
			p = Runtime.getRuntime().exec(command);
			//p.waitFor();
			System.out.println(p.getInputStream());
			BufferedReader br =new BufferedReader(new InputStreamReader(p.getInputStream()));
			while(( line =br.readLine() ) != null)
			{
				sb.append(line+" \n");
			}
		}catch(Exception e){
			
		}
		System.out.println(sb.toString());
		return sb.toString();
	}
	
	public static Object ReadObjectFromFile() {

		try {

			FileInputStream fileIn = new FileInputStream("/home/sjonnalagadda/Downloads/SURESH BACKUP/SURESH WORKSPACE/apache-tomcat-8.0.45/work/Catalina/localhost/SpringMVCHibernateCRUD/SESSIONS.ser");
			ObjectInputStream objectIn = new ObjectInputStream(fileIn);

			Integer obj = (Integer) objectIn.readObject();

			//System.out.println("The Object has been read from the file");
			//objectIn.close();
			
			System.out.println(obj);
			return obj;

		} catch (Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
}
