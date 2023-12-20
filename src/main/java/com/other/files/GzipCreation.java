

package com.other.files;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipOutputStream;

public class GzipCreation
{

	public static void main(String[] args)
	{
		// compressGzipFile("/home/sjonnalagadda/Downloads/loadme-master/new file",
		// "/home/sjonnalagadda/Downloads/loadme-master/suresh");
		zipFolder(Paths.get("/home/sjonnalagadda/Desktop/AESDK/"), Paths.get("/home/sjonnalagadda/Desktop/untitled folder/test.zip"));
		
	}

	private static void compressGzipFile(String file, String gzipFile)
	{
		try
		{
			File f = new File(file);
			f.isDirectory();
			FileInputStream fis = new FileInputStream(f);
			FileOutputStream fos = new FileOutputStream(gzipFile);
			GZIPOutputStream gzipOS = new GZIPOutputStream(fos);
			byte[] buffer = new byte[1024];
			int len;
			while ((len = fis.read(buffer)) != -1)
			{
				gzipOS.write(buffer, 0, len);
			}
			// close resources
			gzipOS.finish();
			gzipOS.close();
			fos.close();
			fis.close();
			File fl = new File(file);
			fl.delete();
			System.out.println("Done.............");
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	private static void zipFolder(Path sourceFolderPath, Path zipPath)
	{
		try
		{
			ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(zipPath.toFile()));
			/*Files.walkFileTree(sourceFolderPath, new SimpleFileVisitor<Path>()
			{
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException
				{
					zos.putNextEntry(new ZipEntry(sourceFolderPath.relativize(file).toString()));
					Files.copy(file, zos);
					zos.closeEntry();
					return FileVisitResult.CONTINUE;
				}
			});*/
			
			Files.walkFileTree(sourceFolderPath, new SimpleFileVisitor<Path>() {
				
			});
			zos.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
