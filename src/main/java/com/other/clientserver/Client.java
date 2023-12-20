package com.other.clientserver;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.Scanner;


public class Client
{

	public static void main(String[] args)
	{
		try
		{
			Scanner scn = new Scanner(System.in);
			Socket s = new Socket("localhost", 9999);
			
			// obtaining input and out streams
            DataInputStream dis = new DataInputStream(s.getInputStream());
            DataOutputStream dos = new DataOutputStream(s.getOutputStream());

            
            while (true)
			{
            	System.out.println(dis.readUTF());
                String tosend = scn.nextLine();
                
                dos.writeUTF(tosend);
                
                if(tosend.equals("Exit"))
                {
                    System.out.println("Closing this connection : " + s);
                    s.close();
                    System.out.println("Connection closed");
                    break;
                }
                 
                // printing date or time as requested by client
                String received = dis.readUTF();
                System.out.println("Received ---> "+received);
			}
            
          //  scn.close();
          //  dis.close();
          //  dos.close();
		}
		catch (Exception e)
		{
			System.err.println("Connect your server first ......."+e.getMessage());
			e.printStackTrace();
		}
	}
}