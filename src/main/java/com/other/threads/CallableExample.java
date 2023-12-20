package com.other.threads;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.*;


/**
 * @author Suresh Babu J
 * sometimes we wish that a thread could return some value that we can use. Java 5 introduced java.util.concurrent.Callable interface in concurrency package
 * that is similar to Runnable interface but it can return any Object and able to throw Exception. 
 * ava Callable interface use Generic to define the return type of Object. Executors class provide useful methods to execute Java Callable in a thread pool. 
 * Since callable tasks run in parallel, we have to wait for the returned Object
 * 
 * Java Callable tasks return java.util.concurrent.Future object. Using Java Future object, we can find out the status of the Callable task and get the
 *  returned Object. It provides get() method that can wait for the Callable to finish and then return the result.

	Java Future provides cancel() method to cancel the associated Callable task. There is an overloaded version of get() method where we can specify the time 
	to wait for the result, it’s useful to avoid current thread getting blocked for longer time. There are isDone() and isCancelled() methods to find out 
	the current status of associated Callable task.
	
	Here is a simple example of Java Callable task that returns the name of thread executing the task after one second. We are using Executor framework to
	 execute 100 tasks in parallel and use Java Future to get the result of the submitted tasks.
 * 
 */
public class CallableExample implements Callable<String>
{

	public static void main(String[] args)
	{
		ExecutorService executor = Executors.newFixedThreadPool(10);
		List<Future<String>> list =new ArrayList<Future<String>>();
		
		Callable<String> callableExample = new CallableExample();
		for (int i = 0; i < 10; i++)
		{
			// to be executd by thread pool ......
			Future<String> submit = executor.submit(callableExample);
			list.add(submit);
		}
		
		for (Future<String> future : list)
		{
			try
			{
				System.out.println(new Date()+" *****************"+future.get());
				Thread.sleep(3000);
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (ExecutionException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		// shutting doen ..........you will notice the delay in output because java Future get() method waits for the java callable task to complete. 
		// Also notice that there are only 10 threads executing these tasks.
		executor.shutdown();
	}

	@Override
	public String call() throws Exception
	{
		String name = Thread.currentThread().getName();
		return name;
	}
}
