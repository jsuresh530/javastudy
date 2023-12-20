package com.other.chat;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.net.SocketException;
import java.util.Scanner;

public class GroupChat
{
	private static final String TERMINATE = "Exit";
	static String name;
	static volatile boolean finished = false;
	static String message;

	public static void main(String[] args)
	{
		Scanner sc = null;
		if (args.length != 2)
		{
			System.out.println("Two arguments required...");
		}
		else
		{
			try
			{
				InetAddress group = InetAddress.getByName(args[0]);
				int port = Integer.parseInt(args[1]);
				 sc = new Scanner(System.in);
				System.out.println("Enter your name");

				name = sc.nextLine();

				MulticastSocket socket = new MulticastSocket(port);
				// since we are deploying...
				socket.setTimeToLive(0);
				socket.joinGroup(group);

				Thread t = new Thread(new ReadThread(socket, group, port));
				t.start();
				System.out.println("Start typing messages...\n");

				while (true)
				{
					message = sc.nextLine();
					if (message.equalsIgnoreCase(TERMINATE))
					{
						finished = true;
						socket.leaveGroup(group);
						socket.close();
						break;
					}
					message = name + " : " + message;
					byte[] bytes = message.getBytes();
					DatagramPacket dgp = new DatagramPacket(bytes, bytes.length, group, port);
					socket.send(dgp);
				}
			}
			catch (SocketException se)
			{
				System.out.println("Error creating socket");
				se.printStackTrace();
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
			
			finally{
				if(sc != null)
					sc.close();
			}
		}
	}

}

class ReadThread implements Runnable
{
	private MulticastSocket socket;
	private InetAddress group;
	private int port;
	
	private static final int MAX_LEN = 1000;
	
	public ReadThread(MulticastSocket socket, InetAddress group, int port)
	{
		this.socket =socket;
		this.group =group;
		this.port =port;
	}

	@Override
	public void run()
	{
		while(!GroupChat.finished)
		{
			byte[] buffer =new byte[MAX_LEN];
			DatagramPacket dgp = new DatagramPacket(buffer, buffer.length, group, port);
			String message;
			
			try
			{
				socket.receive(dgp);
				message =new String(buffer, 0, dgp.getLength(), "UTF-8");
				if (!message.startsWith(GroupChat.name))
				{
					System.out.println(message);
				}
			}
			catch (IOException e)
			{
				e.printStackTrace();
			}
		}
	}

}