/**
 * 
 */
package com.other.algorithms.asymetric;


/**
 * @author sjonnalagadda
 *
 */
public class DeadLock
{
	private static final String r1 ="suresh";
	
	private static final String r2 ="babu";
	
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Thread t1 = new Thread (() -> {

			synchronized (r1)
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

			synchronized (r2)
			{
				System.out.println("Thread 1: locked resource 2");
			}
		});
	
	
		Thread t2 = new Thread (() -> {

			synchronized (r2)
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

			synchronized (r1)
			{
	            System.out.println("Thread 2: locked resource 1");
			}
		});
	
	t1.start();
	t2.start();

	
	}
}
	
	

