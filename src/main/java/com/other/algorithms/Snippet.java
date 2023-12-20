package com.other.algorithms;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Snippet {
	
	
	public static void main(String[] args) {
		deSerializeObject("/home/sjonnalagadda/Desktop/Vishal/Vaibhav/");
	}
	public static boolean deSerializeObject(String filePath) {
			boolean status = false;
			GetInstallationDetailsTemplateBO responseBo = null;
			ObjectInputStream in = null;
			try {
				File serFile = new File((filePath+"configuration.ser"));
				if(serFile != null && serFile.isFile()){
					in = new ObjectInputStream(new FileInputStream(serFile));
					responseBo = (GetInstallationDetailsTemplateBO)in.readObject();
					System.err.println("99999999999999");
					System.err.println(responseBo.getDebitSaleCount()+" "+responseBo.getDebitSaleAmount());
					System.err.println(responseBo.getCreditSaleCount()+" "+responseBo.getCreditSaleAmount());
				}
			}catch (Exception e) {
			}
			return status;
		}
}

