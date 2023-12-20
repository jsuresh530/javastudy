package com.other.threads;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


/**
 * @author Suresh babu j
 *
 */
public class ThreadPoolExample implements Runnable
{
	/*
	 * Java thread pool manages the collection of Runnable threads and worker threads execute Runnable from the queue. java.util.concurrent.
	 * Executors provide implementation of java.util.concurrent.Executor interface to create the thread pool in java. 
	 * 
	 * 
	 */
	private String commond;
	
	public ThreadPoolExample(String s)
	{
		this.commond =s;
	}
	public static void main(String[] args)
	{
		ExecutorService es = Executors.newFixedThreadPool(5);
		for (int i = 0; i < 10; i++)
		{
			Runnable r =new ThreadPoolExample(""+i);
			es.execute(r);
		}
		es.shutdown();
		while(!es.isTerminated())
		{
			
		}
        System.out.println("Finished all threads");
	}

	@Override
	public void run()
	{
		String name = Thread.currentThread().getName();
		System.out.println("Started ...."+name);
			ProcessThisLogic();
        System.out.println(Thread.currentThread().getName()+" End.");
	}
	private void ProcessThisLogic()
	{
		/*
		 * we are creating fixed size thread pool of 5 worker threads. Then we are submitting 10 jobs to this pool, since the pool size is 5, 
		 * it will start working on 5 jobs and other jobs will be in wait state, as soon as one of the job is finished, another job from the
		 *  wait queue will be picked up by worker thread and get’s executed.
		 */
		try
		{
			Thread.sleep(5000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public String toString()
	{
		return this.commond;
	}
}
