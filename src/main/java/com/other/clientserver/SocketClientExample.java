

package com.other.clientserver;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class SocketClientExample
{

	public static void main(String[] args)
	{
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		try
		{
			InetAddress localHost = InetAddress.getLocalHost();
			for (int i = 0; i < 5; i++)
			{
				socket = new Socket(localHost.getHostName(), 9876);
				oos = new ObjectOutputStream(socket.getOutputStream());
				System.out.println("Sending request to Socket Server");
				if (i == 4)
					oos.writeObject("EXIT");
				else
					oos.writeObject("" + i);
				ois = new ObjectInputStream(socket.getInputStream());
				String message = (String) ois.readObject();
				System.out.println("Message: " + message);
				
				ois.close();
				oos.close();
				
				Thread.sleep(10000);
			}
		}
		catch (Exception e)
		{
			System.err.println("Please run server first ----> "+e.getMessage());
		}
	}
}
