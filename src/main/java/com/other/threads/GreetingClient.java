

package com.other.threads;

import java.io.*;
import java.net.Socket;

public class GreetingClient
{
	/*Connecting to localhost on port 8777
	Just connected to localhost/127.0.0.1:8777
	Server says Thank you for connecting to /127.0.0.1:8777
	Goodbye!*/
	public static void main(String[] args)
	{
		//String serverName = args[0];
		//int port = Integer.parseInt(args[1]);
		try
		{
			String serverName = "localhost";
			int port = 8777;
			System.out.println("Connecting to " + serverName + " on port " + port);
			Socket client = new Socket(serverName, port);
			System.out.println("Just connected to " + client.getRemoteSocketAddress());
			OutputStream outToServer = client.getOutputStream();
			DataOutputStream out = new DataOutputStream(outToServer);
			out.writeUTF("Hello from " + client.getLocalSocketAddress());
			InputStream inFromServer = client.getInputStream();
			DataInputStream in = new DataInputStream(inFromServer);
			System.out.println("Server says " + in.readUTF());
			//client.close();
		}
		catch (IOException e)
		{
			System.err.println("Start SERVER FIRST : "+e.getMessage());
			e.printStackTrace();
		}
	}
}