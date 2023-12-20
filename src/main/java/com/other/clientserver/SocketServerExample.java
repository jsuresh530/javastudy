package com.other.clientserver;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;


public class SocketServerExample
{
	private static ServerSocket serverSocket;
	
	private static int port =9876;

	public static void main(String[] args)
	{
		try
		{
			serverSocket = new ServerSocket(port);
			while(true)
			{
				System.out.println("Waiting for client request");
				Socket socket = serverSocket.accept();
				
				ObjectInputStream ois =new ObjectInputStream(socket.getInputStream());
				
				String message = (String) ois.readObject();
				System.out.println("Message Received: " + message);
				
				ObjectOutputStream oos =new ObjectOutputStream(socket.getOutputStream());
				
				oos.writeObject("Hi "+message);
				
				ois.close();
				oos.close();
				socket.close();
				
				if(message.equalsIgnoreCase("exit"))
					break;
			}
			
			System.out.println("Shutting down Socket server!!");
			serverSocket.close();
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
}
