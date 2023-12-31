

package com.other.clientserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server
{

	public static void main(String[] args) throws IOException
	{
		Socket s =null;
		ServerSocket ss =null;
		try
		{
			 ss = new ServerSocket(5111);
			// running infinite loop for getting client request
			while(true)
			{
				System.out.println("Server is started ....");
				s = ss.accept();
				System.out.println("A new client is connected : " + s);
				
				DataInputStream dis =new DataInputStream(s.getInputStream());
				DataOutputStream dos =new DataOutputStream(s.getOutputStream());
				
				System.out.println("Assigning new thread for this client");
				
				 Thread t = new ClientHandler(s, dis, dos);
				 
				 t.start();
			}
		}
		catch (Exception e)
		{
			ss.close();
			s.close();
			 e.printStackTrace();
		}
	}
}
