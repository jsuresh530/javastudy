/**
 * 
 */
package com.other.files;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author sjonnalagadda
 *
 */
public class FileTOByte
{

	/**
	 * Stream – A sequence of data.
		Input Stream: reads data from source.
		Output Stream: writes data to destination.
		
		When to use Character Stream over Byte Stream? 

    	In Java, characters are stored using Unicode conventions. Character stream is useful when we want to process text files. 
    	These text files can be processed character by character. A character size is typically 16 bits.

     When to use Byte Stream over  Character Stream? 

    Byte oriented reads byte by byte.  A byte stream is suitable for processing raw data like binary files.

	 */
	public static void main(String[] args)
	{
		String file = "/home/sjonnalagadda/Downloads/SURESH WORKSPACE/eclipse/java.pdf";
		//convertFIleTOByte(file);
		//readFile();
		readPattern();
	}

	/**
	 * @param file
	 */
	private static void convertFIleTOByte(String file)
	{
		
		try
		{
			File f =new File(file);
			ByteArrayOutputStream bos =new ByteArrayOutputStream();
			FileInputStream fis =new FileInputStream(f);
			
			byte[] buf =new byte[1024];
			FileOutputStream fos =new FileOutputStream("/home/sjonnalagadda/Downloads/SURESH WORKSPACE/eclipse/java2.pdf");
			for (int readNum ; (readNum = fis.read(buf)) != -1;)
			{
				
				bos.write(buf, 0, readNum);
				System.err.println("-------> read "+readNum+" Bytes");
				fos.write(buf, 0, readNum);
				
				//Thread.sleep(1000);
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		
	}
	
	/**
	 * readFile using java
	 */
	public static void readFile(){
		FileReader fr = null;
		try
		{
			 fr =new FileReader("/home/sjonnalagadda/Downloads/SURESH WORKSPACE/eclipse/notice.html");
			int temp =0;
			while ((temp = fr.read()) > 0)
			{
				System.err.print((char)(temp));
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}finally
		{
			if(fr !=null)
				try
				{
					fr.close();
				}
				catch (IOException e)
				{
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		}
	}
	
	public static void readPattern(){
		File f =new File("");
		try
		{
			PrintWriter pw =new PrintWriter("/home/sjonnalagadda/Downloads/SURESH WORKSPACE/eclipse/output.txt");
			Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");
			BufferedReader br =new BufferedReader(new FileReader("/home/sjonnalagadda/Desktop/Thoshibha-Onejar/Utils.java"));
			String line = br.readLine();
			while (line != null)
			{
				Matcher matcher = p.matcher(line);
				while (matcher.find())
				{
					pw.println(matcher.group());
				}
				line =br.readLine();
			}
			pw.flush(); 
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
}
