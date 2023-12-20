package com.other.threads;

import java.util.concurrent.atomic.AtomicInteger;


/**
 * @author sjonnalagadda
 * A monitor can be considered as a building which contains a special room. The special room can be occupied by only one customer(thread) at a time. 
 * The room usually contains some data and code. 
 * 
 * If a customer wants to occupy the special room, he has to enter the Hallway(Entry Set) to wait first. Scheduler will pick one based on 
 * some criteria(e.g. FIFO). If he is suspended for some reason, he will be sent to the wait room, and be scheduled to reenter the special room 
 * later. As it is shown in the diagram above, there are 3 rooms in this building. 
 * 
 * In brief, a monitor is a facility which monitors the threads' access to the special room. It ensures that only one thread can access the
 *  protected data or code. 
 *  
 * How is it implemented in Java?
 * In the Java virtual machine, every object and class is logically associated with a monitor. To implement the mutual exclusion capability of 
 * monitors, a lock (sometimes called a mutex) is associated with each object and class. This is called a semaphore in operating systems books,
 *  mutex is a binary semaphore.

If one thread owns a lock on some data, then no others can obtain that lock until the thread that owns the lock releases it. It would be not 
convenient if we need to write a semaphore all the time when we do multi-threading programming. Luckily, we don't need to since JVM does that
 for us automatically.

To claim a monitor region which means data not accessible by more than one thread, Java provide synchronized statements and synchronized methods. 
Once the code is embedded with synchronized keyword, it is a monitor region. The locks are implemented in the background automatically by JVM. 
 * 
 * 
 * 3. In Java synchronization code, which part is monitor?
 * 
 * We know that each object/class is associated with a Monitor. I think it is good to say that each object has a monitor, since each object 
 * could have its own critical section, and capable of monitoring the thread sequence.

To enable collaboration of different threads, Java provide wait() and notify() to suspend a thread and to wake up another thread that are waiting
 on the object respectively. In addition, there are 3 other versions:

wait(long timeout, int nanos)
wait(long timeout) notified by other threads or notified by timeout. 
notify(all)

Those methods can only be invoked within a synchronized statement or synchronized method. The reason is that if a method does not require mutual
 exclusion, there is no need to monitor or collaborate between threads, every thread can access that method freely. 
 * 
 *
 */
public class ThreadExam extends Thread
{
 private static AtomicInteger atomicInteger = new AtomicInteger();
	public static void main(String[] args)
	{
		/*System.err.println(getCount());
		
		System.err.println(getCount1());
		
		System.err.println(getCoun());
		
		System.err.println(getCoun2());
		
		When method is static: class level lock i.e. both instances of Thread3 are locked by first obj and then obj2. 
		They execute the method in sequence.
       When method is non-static: Both instances execute the method independently in their instances.

	    In fact, in non-static mode they do not share any shared resource/method. So if you drop the synchronized keyword itself, 
	    it doesn’t make any difference.
		synchronized keyword should be used to protect some shared resource which will be accesses simultaneously by multiple threads.
		Here testSync() method does not do anything like that.
	 
		*
		*/
		
		ThreadExam t =new ThreadExam();
		ThreadExam t2 =new ThreadExam();
		
		
		t.start();
		t2.start();
	}
	
	public void run()
	{
		testSync();
	}
	private Object obj =new Object();
	//public synchronized static  void  testSync()
	public void  testSync()
	{
		synchronized (obj)
		{
			for (int i = 0; i < 5; i++)
			{
				System.out.println("i is  ::: "+i+" **** "+Thread.currentThread().getName());
				try
				{
					Thread.sleep(1000);
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
	}
	
	public static int getCount() {
		return atomicInteger.getAndIncrement();
	}
	
	public static int getCount1() {
		return atomicInteger.getAndIncrement();
	}
	
	
	private static int counter = 0;
	 
	public static synchronized int getCoun() {
		return counter++;
	}
	
	public static synchronized int getCoun2() {
		return counter++;
	}
	
	
}
