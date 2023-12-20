/**
 * 
 */
package com.other.algorithms;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * @author sjonnalagadda
 *
 */
public class ZipFOlder
{
static List<String> filesListInDir = new ArrayList<String>();
	
	public static void main(String[] args) {
		File f = new File("/home/sjonnalagadda/Aesdklogs");
		
		zipDirectory(f, "/home/sjonnalagadda/Aesdklogs/suresh.zip");
	}

	public static void getFiles(File dir){
		File[] listFiles = dir.listFiles();
		for (File file : listFiles) {
			if(file.getName().endsWith("gz")){
				filesListInDir.add(file.getAbsolutePath());
			}
		}
	}
	
	public static void zipDirectory(File dir, String zipDirName){
		
		getFiles(dir);
		
		System.err.println(filesListInDir.toString());
		
		try {
			
			FileOutputStream fos =new FileOutputStream(zipDirName);
			ZipOutputStream zos =new ZipOutputStream(fos);
			FileInputStream fis =null;
			ZipEntry zip = null;
			
			for (String filePath : filesListInDir) {
				System.err.println("Zipping --->  "+dir.getAbsolutePath()+" ---> "+filePath);
				 zip =new ZipEntry(filePath.substring(dir.getAbsolutePath().length()+1, filePath.length()));
				 
				 System.err.println("####### "+zip);
				zos.putNextEntry(zip);
				System.err.println(filePath);
				fis =new FileInputStream(filePath);
				byte[] buffer =new byte[1024];
				int len;
				while ((len = fis.read(buffer)) > 0) {
					zos.write(buffer, 0, len);
				}
				zos.closeEntry();
				fis.close();
			}
			zos.close();
			fos.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	private static void zipSingleFile(File file, String zipFileName) {

		System.err.println(file);
		try {
			// create ZipOutputStream to write to the zip file
			FileOutputStream fos = new FileOutputStream(zipFileName);
			ZipOutputStream zos = new ZipOutputStream(fos);
			// add a new Zip Entry to the ZipOutputStream
			ZipEntry ze = new ZipEntry(file.getName());
			zos.putNextEntry(ze);
			// read the file and write to ZipOutputStream
			FileInputStream fis = new FileInputStream(file);
			byte[] buffer = new byte[1024];
			int len;
			while ((len = fis.read(buffer)) > 0) {
				zos.write(buffer, 0, len);
			}

			// Close the zip entry to write to zip file
			zos.closeEntry();
			// Close resources
			zos.close();
			fis.close();
			fos.close();
			System.out.println(file.getCanonicalPath() + " is zipped to "
					+ zipFileName);

		} catch (IOException e) {
			e.printStackTrace();
		}

	}
}
