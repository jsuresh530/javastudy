package com.other.algorithms;

import org.apache.commons.lang3.StringUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;

public class Test {

	/*public static void main(String[] args) {
		
		//String s = "2130010010120";
		
		//System.err.println(s.substring(9,12));
		
		getFormatedSeqNumber(4);

	}*/
	
	
	public static void main(String[] args) {
		deSerializeObject("/home/sjonnalagadda/Desktop/Vishal/Vaibhav/");
	}
	@SuppressWarnings("resource")
	public static boolean deSerializeObject(String filePath) {
			boolean status = false;
			GetInstallationDetailsTemplateBO responseBo = null;
			ObjectInputStream in = null;
			try {
				File serFile = new File((filePath+"configuration.ser"));
				System.err.println(serFile);
				if(serFile != null && serFile.isFile()){
					in = new ObjectInputStream(new FileInputStream(serFile));
					responseBo = (GetInstallationDetailsTemplateBO)in.readObject();
					System.err.println("99999999999999 "+responseBo.getAccountType());
					System.err.println(responseBo.getDebitSaleCount()+" "+responseBo.getDebitSaleAmount());
					System.err.println(responseBo.getCreditSaleCount()+" "+responseBo.getCreditSaleAmount());
				}
			}catch (Exception e) {
			}
			return status;
		}
	
	private static String  getFormatedSeqNumber(int inputparam) {
		String formatedresponse = "";
		try {
			formatedresponse = StringUtils.leftPad(inputparam+"",3,"0");
			System.err.println("formatedresponse "+formatedresponse);
			return formatedresponse;
		}catch (Exception e) {
			return null;
		}
	}
	
	

}
