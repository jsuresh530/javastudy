package com.coreexamples.CoreJava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileRead {
	
	public void test()
	{
		System.err.println("testing happend");
	}

	public static void main(String args[]) {
		
		

		int l =0, h =20;
		boolean flag =false;
		while (l < h){
			for (int i = 2; i <= l/2; i++)
			{
				if(l%i == 0){
					flag = true;
					break;
				}
			}
			
			if (!flag)
                System.out.print(l+ " ");

            l++;
		}
		
		//isPrime(4);
		
		System.exit(0);
	
		

		String fileName = "D:\\Clients\\DG\\GiftTransRequest.txt";
		try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {

			String line;
				int count =0;
					while ((line = br.readLine()) != null) {
						count++;
						//for (int i = 1; i <=10; i++) {
						if(count >=37 && count <= 82)
						{
							System.out.println(line);
						}
					
						//}
				
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		

	}

}
