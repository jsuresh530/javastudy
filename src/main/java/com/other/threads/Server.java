

package com.other.threads;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server
{

	public static void main(String args[]) throws IOException
	{
		ServerSocket ss = new ServerSocket(4444);
		//ss.setSoTimeout(1000);
		System.out.println("server started");
		while (true)
		{
			System.out.println("waiting for client");
			Socket s = ss.accept();
			System.out.println("connected to client");
			BufferedReader in = new BufferedReader(new InputStreamReader(s.getInputStream()));
			DataOutputStream out = new DataOutputStream(s.getOutputStream());
			
			while(true)
			{
				System.out.println("recieved: " + in.readLine());
				out.writeBytes("200\n");
			}
			
			//out.flush();
		}
		
		/*
		 * ServerSocket ss = new ServerSocket(81);
          while(true){
            Socket s = ss.accept();
            BufferedReader in = new BufferedReader( new InputStreamReader( s.getInputStream() ) );
            DataOutputStream out = new DataOutputStream( s.getOutputStream() );
            while (true) {
                System.out.println( "recieved: "+ in.readLine()  );
                out.writeBytes( "200\n" );
                out.flush();
            }
        }
		 */
	}
}
