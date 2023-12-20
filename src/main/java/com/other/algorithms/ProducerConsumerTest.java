/**
 * 
 */


package com.other.algorithms;


/**
 * @author sjonnalagadda
 * Producer Consumer Problem is a classical concurrency problem and in fact it is one of the concurrency design pattern
 * 
 */
public class ProducerConsumerTest
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Bottole b =new Bottole();
		Producer p =new Producer(b, 1);
		Consumer c =new Consumer(b, 1);
		
		p.start();
		c.start();
	}
}

class Bottole
{

	private int		contents;
	private boolean	available	= false;

	public synchronized int get()
	{
		while (!available)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		available = false;
		notifyAll();
		return contents;
	}

	public synchronized void put(int value)
	{
		while (available)
		{
			try
			{
				wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		contents = value;
		available = true;
		notifyAll();
	}
}

class Producer extends Thread
{
	private Bottole bottole;
	private int number1;
	
	public Producer(Bottole c, int number) {
		  bottole = c;
	      this.number1 = number;
	   }
	
	public void run(){
		for (int i = 0; i <10; i++)
		{
			bottole.put(i);
	         System.out.println("Producer #" + this.number1 + " put: " + i);
	         
	         try
			{
				sleep((int)Math.random()*100);
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}
}

class Consumer extends Thread
{
	private Bottole b1;
	private int number;
	
	Consumer(Bottole b, int no){
		this.b1 =b;
		number = no;
	}
	
	public void run(){
		int value = 0;
		for (int i = 0; i < 10; i++)
		{
			value = b1.get();
	         System.out.println("Consumer #" + this.number + " got: " + value);
		}
	}
}