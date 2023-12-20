

package com.other.threads;

import java.util.Vector;

public class ConsumerExample extends Thread
{

	Producer	producer;

	ConsumerExample(Producer p)
	{
		producer = p;
	}

	@Override
	public void run()
	{
		try
		{
			while (true)
			{
				String message = producer.getMessage();
				System.out.println("Got message: " + message);
				sleep(2000);
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}

	public static void main(String args[])
	{
		Producer producer = new Producer();
		producer.start();
		new ConsumerExample(producer).start();
	}
}

class Producer extends Thread
{

	static final int		MAXQUEUE	= 5;
	private Vector<String>	messages	= new Vector<String>();

	@Override
	public void run()
	{
		while (true)
		{
			try
			{
				putMessage();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
	}

	private synchronized void putMessage() throws InterruptedException
	{
		while (messages.size() == MAXQUEUE)
		{
			// Causes the current thread to wait until another thread invokes the java.lang.Object.notify() method or 
			// the java.lang.Object.notifyAll() method for this object. In other words, 
			// this method behaves exactly as if it simply performs the call wait(0).
			
			wait();
		}
		messages.addElement(new java.util.Date().toString());
		System.out.println("put message");
		notify();
		// Later, when the necessary event happens, the thread that is running it calls notify()
		// from a block synchronized on the same object.
	}

	// Called by Consumer
	public synchronized String getMessage() throws InterruptedException
	{
		//Wakes up a single thread that is waiting on this object's monitor. If any threads are waiting on this object, 
		// one of them is chosen to be awakened. The choice is arbitrary and occurs at 
		// the discretion of the implementation. A thread waits on an object's monitor by calling one of the wait methods.


		notify();
		while (messages.size() == 0)
		{
			wait();// By executing wait() from a synchronized block, a thread gives up its hold on
					// the lock and goes to sleep.
		}
		String message = (String) messages.firstElement();
		messages.removeElement(message);
		return message;
	}
}