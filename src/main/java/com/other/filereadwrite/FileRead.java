package com.other.filereadwrite;

import java.io.*;


public class FileRead
{

	public static void main(String[] args)
	{
		writeToFile();
		readFromFile();
		
		
		fileCopyUsingFileStreams();
	}

	private static void fileCopyUsingFileStreams()
	{
		try
		{
			File fileToCopy = new File("src/fileWrite.txt");
	        FileInputStream input = new FileInputStream(fileToCopy);
	 
	        File newFile = new File("src/fileWrite2.txt");
	        FileOutputStream output = new FileOutputStream(newFile);
	        
	        byte[] buf = new byte[1024];
	        int bytesRead = 0;
	        
	        while ((bytesRead = input.read(buf)) > 0)
			{
	        	output.write(buf, 0, bytesRead);
			}
	        
	        output.close();
	        input.close();
	        
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}

	private static void readFromFile()
	{
		File file = new File("src/fileWrite.txt");
		try
		{
			FileInputStream fin = new FileInputStream(file);
			byte[] fileContent = new byte[(int)file.length()];
			
			fin.read(fileContent);
			
			//String str =new String(fileContent);
			
			//System.out.println(str);
			
			for (int i = 0; i < fileContent.length; i++)
			{
				System.out.print((char)fileContent[i]);
			}
			
			fin.close();
			
			//Using buffered reader............
			System.out.println("\n Using buffered reader \n");
			String line =null;
			BufferedReader br =new BufferedReader(new FileReader("src/fileWrite.txt"));
			
			while ( (line = br.readLine()) != null)
			{
				System.out.println(line);
			}
			
			br.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void writeToFile()
	{
		try
		{
			BufferedWriter bw =new BufferedWriter(new FileWriter(new File("src/fileWrite.txt")));
			
			bw.write("hello My name is suresh...........\n");
			
			bw.append("i am from Ongole");
			
			bw.close();
			
			System.out.println("filw write succesfull........");
		}
		catch (Exception e)
		{
		}
	}
}
