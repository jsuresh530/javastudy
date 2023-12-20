/**
 * 
 */
package com.other.threads.feb13;


/**
 * @author sjonnalagadda
 * thread creating happens in 2 ways. extends thread, implements runnable.
 * A new thread starts(with new callstack).
 * The thread moves from New state to the Runnable state.
 * Thread scheduler in java is the part of the JVM that decides which thread should run.
 * There is no guarantee that which runnable thread will be chosen to run by the thread scheduler.
   Only one thread at a time can run in a single process.
   
   Under preemptive scheduling, the highest priority task executes until it enters the waiting or dead states or a higher priority task comes into existence.
    Under time slicing, a task executes for a predefined slice of time and then reenters the pool of ready tasks. The scheduler then determines which task 
    should execute next, based on priority and other factors. 
 */  
public class ThreadCreate extends Thread
{

	public void run(){
		System.err.println(" I am from Thread METHOD  NAME: "+Thread.currentThread().getName());
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Thread r =new Thread(new RunnableClass());
		
		r.start();
		
		ThreadCreate t = new ThreadCreate();
		t.currentThread().setName("suresh");
		t.run();
	}
}


class RunnableClass implements Runnable{

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run()
	{
		System.err.println("I am from runnable ");
	}
	
	public static void main(String[] args)
	{
		Thread t =new Thread(new RunnableClass());
		
		t.start();
	}
	
}
