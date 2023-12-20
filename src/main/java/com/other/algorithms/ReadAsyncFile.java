/**
 * 
 */
package com.other.algorithms;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 * @author sjonnalagadda
 *
 */
public class ReadAsyncFile
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		//readasyncFile("src/readAsyncfile.txt");
		
		//reading file line by line in Java using BufferedReader      
        FileInputStream fis = null;
        BufferedReader reader = null;
     
        try {
            fis = new FileInputStream("src/readAsyncfile.txt");
            reader = new BufferedReader(new InputStreamReader(fis));
         
            System.out.println("Reading File line by line using BufferedReader");
         
            String line = reader.readLine();
            int count =1;
            while(line != null){
            	if(line.startsWith("1"))
            		System.out.println(line +" "+count);
            	else if(line.startsWith("2"))
            		System.out.println(line +" "+count);
            	//else if(line.startsWith("3"))
            	//	System.out.println(line +" "+count);	
            			
               // Thread.sleep(3000);
                line = reader.readLine();
                //count++;
            }          
         
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ReadAsyncFile.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(ReadAsyncFile.class.getName()).log(Level.SEVERE, null, ex);
         
        }
		/*catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/ finally {
            try {
                reader.close();
                fis.close();
            } catch (IOException ex) {
                Logger.getLogger(ReadAsyncFile.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
	}

	/**
	 * @param string
	 */
	private static void readasyncFile(String pathname)
	{
		try
		{
			FileInputStream fin = new FileInputStream(new File(pathname));
			
			int i=0;    
            while((i = fin.read()) != -1){    
             System.out.print((char)i);    
             
             Thread.sleep(4000);
            }    
            fin.close();    
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		
	}
}
