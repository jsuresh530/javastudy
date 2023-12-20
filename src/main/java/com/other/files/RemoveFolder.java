package com.other.files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;


public class RemoveFolder
{
	public static void main(String[] args)
	{
		List<File> files = findDirectoriesWithSameName("CVS", new File("/home/sjonnalagadda/Desktop/AESDK/Serial/aurus-aesdk-service-enterprise_ms/"));
	
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

		  for (File file : root.listFiles()) {
		    if (file.isDirectory()) {
		      if (file.getName().equals(name)) {
		        result.add(file);
		      }
		      result.addAll(findDirectoriesWithSameName(name, file));
		    }
		  }

		  return result;
		}
   
}
