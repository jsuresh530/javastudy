package com.other.threads;


public class ThreadJoinExample
{
/*
 * This java thread join method puts the current thread on wait until the thread on which it’s called is dead. 
 * If the thread is interrupted, it throws InterruptedException.
 * 
 * his java thread join method is used to wait for the thread on which it’s called to be dead or wait for specified milliseconds. 
 * Since thread execution depends on OS implementation,
 *  it doesn’t guarantee that the current thread will wait only for given time.
 *  
 *  Thread.sleep() method can be used to pause the execution of current thread for specified time in milliseconds. The argument value for 
 *  milliseconds can’t be negative, else it throws IllegalArgumentException.
 */
	public static void main(String[] args)
	{
		Thread t1 =new Thread(new MyRunnable(), "t1");
		Thread t2 =new Thread(new MyRunnable(), "t2");
		Thread t3 =new Thread(new MyRunnable(), "t3");
		
        //start second thread after waiting for 2 seconds or if it's dead
		
		try
		{
			t1.join(2000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		t2.start();
		
		try
		{
			t1.join();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
		t3.start();
		
		try
		{
			t1.join();
			t2.join();
			t3.join();
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
        System.out.println("All threads are dead, exiting main thread");
        
        
        long start = System.currentTimeMillis();
        
        try
		{
			Thread.sleep(2000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
        
        System.out.println("Sleep time in ms = "+(System.currentTimeMillis()-start));
        /*
		    It always pause the current thread execution.
		    The actual time thread sleeps before waking up and start execution depends on system timers and schedulers. For a quiet system, 
		    the actual time for sleep is near to the specified sleep time but for a busy system it will be little bit more.
		    Thread sleep doesn’t lose any monitors or locks current thread has acquired.
		    Any other thread can interrupt the current thread in sleep, in that case InterruptedException is thrown.
		    
		    How Thread Sleep Works : 
			Thread.sleep() interacts with the thread scheduler to put the current thread in wait state for specified period of time. 
			Once the wait time is over, thread state is changed to runnable state and wait for the CPU for further execution. So the actual time that 
			current thread sleep depends on the thread scheduler that is part of operating system.
			
			
         */
        
        
	}
}

class MyRunnable implements Runnable
{
	@Override
	public void run()
	{
		System.out.println("Thread started:::"+Thread.currentThread().getName());
		try
		{
			Thread.sleep(4000);
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		System.out.println("Thread ended:::"+Thread.currentThread().getName());
	}
	
}