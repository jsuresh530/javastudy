

package com.other.files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class RemoveFile
{

	public static void main(String[] args)
	{
		List<File> files = findDirectoriesWithSameName("a.txt", new File("/home/sjonnalagadda/Music/auru-payment-service/"));
	
		for (File file : files)
		{
			deleteDir(file);
		}
		
		System.out.println("deletion done ...............");
	}
	
	 public static boolean deleteDir(File dir) {
	      if (dir.isDirectory()) {
	         String[] children = dir.list();
	         for (int i = 0; i < children.length; i++) {
	            boolean success = deleteDir (new File(dir, children[i]));
	            
	            if (!success) {
	               return false;
	            }
	         }
	      }
	      return dir.delete();
	   }
	//List all the files with folder....
	public static List<File> findDirectoriesWithSameName(String name, File root) {
		  List<File> result = new ArrayList<File>();
		  int count = 0;
		  for (File file : root.listFiles()) {
			  
			  //System.err.println(file.isDirectory()+" \t "+file.isFile()+" \t "+count++);
		    if (file.isDirectory() && file.isFile()) {
		    	if(file.getName().endsWith(".txt"))
		    	{
		    		if (file.getName().equals(name)) {
				        result.add(file);
				      }
				      result.addAll(findDirectoriesWithSameName(name, file));
		    	}
		      
		    }
		  }
		  System.err.println(result.size());
		  return result;
		}
}
