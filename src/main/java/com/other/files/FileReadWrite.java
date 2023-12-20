package com.other.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;


public class FileReadWrite
{

	public static void main(String[] args)
	{
		readWrite();
	}

	private static void readWrite()
	{
		File f1 =new File("src/fileWrite.txt");
		File f2 =new File("src/fileWrite2.txt");
		
		try
		{
			FileInputStream fis =new FileInputStream(f1);
			FileOutputStream fos =new FileOutputStream(f2);
			
			int count =0;
			
			while ((count = fis.read()) != -1)
			{
				fos.write(count);
			}
			fis.close();
            fos.close();
            
            System.out.println("done ........");
		}
		catch (Exception e)
		{
		}
	}
}
