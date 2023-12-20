package com.other.threads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Worker implements Runnable
{
	 public boolean running = false;  
	 
	 public Worker()
	 {
		 Thread t =new Thread(this);
		 t.start();
	 }

	public static void main(String[] args)
	{
		List<Worker> workers = new ArrayList<Worker>();  
		System.out.println("This is currently running on the main thread, the id is: " + Thread.currentThread().getId());
		
		Date start = new Date();
		
		for (int i = 0; i < 5; i++)
		{
			workers.add(new Worker());
		}
		
		for (Worker worker : workers)
		{
			while(worker.running)
			{
				try
				{
					Thread.sleep(100);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		Date end = new Date();  
		
		long difference = end.getTime() - start.getTime();  
	      
	    System.out.println ("This whole process took: " + difference/1000 + " seconds.");
	    
		//Worker worker = new Worker();
		//Thread thread = new Thread(worker);
		//thread.start();
	}

	@Override
	public void run()
	{
		this.running = true;
		System.out.println("This is currently running on a separate thread, the id is: " + Thread.currentThread().getId());
		
		try
		{
			Thread.sleep(5000);
		}
		catch (InterruptedException e)
		{
			//e.printStackTrace();
			Thread.currentThread().interrupt();  
		}
		
		this.running = false;
	}
}
