

package com.other.threads;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Client1
{

	public static void main(String[] args)
	{
		try
		{
			Socket clientSocket = new Socket("127.0.0.1", 4444);
			DataOutputStream out = new DataOutputStream(clientSocket.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
			System.out.println("connected to server i am from CLIENT 1");
			while (true)
			{
				System.out.println("enter data to send");
				Scanner sc = new Scanner(System.in);
				String msg = sc.nextLine();
				out.writeBytes(msg + "\n");
				System.out.println("response from server : " + in.readLine());
			}
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
}
