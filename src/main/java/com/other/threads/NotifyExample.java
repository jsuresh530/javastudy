package com.other.threads;

import java.util.Set;


/**
 * @author SUresh babu j
 *
 */
public class NotifyExample
{
	/*The Object class in java contains three final methods that allows threads to communicate about the lock status of a resource.
	 *  These methods are wait(), notify() and notifyAll(). 
	 * The current thread which invokes these methods on any object should have the object monitor else it throws 
	 * java.lang.IllegalMonitorStateException exception. 
	 * 
	 * 1) Object wait methods has three variance, one which waits indefinitely for any other thread to call notify or notifyAll method on the object to 
	 * wake up the current thread.
	 *  Other two variances puts the current thread in wait for specific amount of time before they wake up
	 * 2) notify method wakes up only one thread waiting on the object and that thread starts execution. So if there are multiple threads waiting for an object
	 * , this method will wake up only one of them. The choice of the thread to wake depends on the OS implementation of thread management.
	 * 
	 * 3) notifyAll method wakes up all the threads waiting on the object, although which one will process first depends on the OS implementation.
	 * These methods can be used to implement producer consumer problem where consumer threads are waiting for the objects in Queue and producer threads 
	 * put object in queue and notify the waiting threads.
	 * 
	 * ************ THREAD STATES ****************************
	 * we can create a java thread class by implementing Runnable interface or by extending Thread class, but to start a java thread, we first have to 
	 * create the Thread object  and call it’s start() method to execute run() method as a thread.
	 * how the thread states change from Runnable to Running to Blocked depends on the OS implementation of thread scheduler and java doesn’t have 
	 * full control on that.
	 *  java programme --->new thread & start thread ....
	 *  Thread Scheduler : Runnable ---> Running  (Blocked/ waiting )---> Dead
	 *  
	 * 1) NEW: When we create a new Thread object using new operator, thread state is New Thread. At this point, thread is not alive and it’s a state internal
	 *  to Java programming.
	 *  
	 * 2) Runnable:  When we call start() function on Thread object, it’s state is changed to Runnable. The control is given to Thread scheduler to finish it’s execution. 
	 * Whether to run this thread instantly or keep it in runnable thread pool before running, depends on the OS implementation of thread scheduler.
	 * 
	 * 3) Running: When thread is executing, it’s state is changed to Running. Thread scheduler picks one of the thread from the runnable thread pool and 
	 * change it’s state to Running. Then CPU starts executing this thread. A thread can change state to Runnable, Dead or Blocked from running state 
	 * depends on time slicing, thread completion of run() method or waiting for some resources.
	 *  
	 *  4) Blocked/Waiting: A thread can be waiting for other thread to finish using thread join or it can be waiting for some resources to available.
	 *   For example producer consumer problem or waiter notifier implementation or IO resources, then it’s state is changed to Waiting. Once the thread 
	 *   wait state is over, it’s state is changed to Runnable and it’s moved back to runnable thread pool.
	 *   
	 *   5) Dead: Once the thread finished executing, it’s state is changed to Dead and it’s considered to be not alive.
	 *  
	 * 
	 */
	
	public static void main(String[] args)
	{
		
		Message1 msg =new Message1("Proceesing started....");
		
		WaiterThread wt =new WaiterThread(msg);
		Thread.currentThread().setName("waiter");
		new Thread(wt, "waiter").setPriority(Thread.MAX_PRIORITY);
		new Thread(wt, "waiter").start();
		
		
		
		WaiterThread wt1 =new WaiterThread(msg);
		Thread.currentThread().setName("waiter1");
		new Thread(wt, "waiter1").setPriority(Thread.MIN_PRIORITY);
		new Thread(wt1, "waiter1").start();
		
		Notifier n = new Notifier(msg);
		new Thread(n, "notifier").start();
		
		System.out.println("All is set......"+Thread.activeCount());
		
		  System.out.println("***********************************");
		  
		Set<Thread> threadSet = Thread.getAllStackTraces().keySet();
        for ( Thread t : threadSet){
            System.out.println("Thread :"+t.getName()+":"+"state:"+t.getState()+" .........."+t.getId());
        }
		
        System.out.println("***********************************");
	}
}

//A java bean class on which threads will work and call wait and notify methods.
class Message1
{
    private String msg1;
    
    public Message1(String s)
    {
    	this.msg1=s;
    }

	public String getMsg()
	{
		return msg1;
	}

	public void setMsg(String msg)
	{
		this.msg1 = msg;
	}
}
//A class that will wait for other threads to invoke notify methods to complete it’s processing. 
//Notice that Waiter thread is owning monitor on Message object using synchronized block.
class WaiterThread implements Runnable
{
	private Message1 msg;
	
	public WaiterThread(Message1 s)
	{
		this.msg =s;
	}

	@Override
	public void run()
	{
        String name = Thread.currentThread().getName();
        
        synchronized (msg)
		{
        	System.out.println(name+" waiting to get notified at time: "+System.currentTimeMillis());
			try
			{
				msg.wait();
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
			
			System.out.println(name+" waiter thread got notified after: "+System.currentTimeMillis());
            
            System.out.println(name+" processed **********: "+msg.getMsg());
		}
	}
}

// A class that will process on Message object and then invoke notify method to wake up threads waiting for Message object. 
// Notice that synchronized block is used to own the monitor of Message object.
class Notifier implements Runnable
{
	private Message1 msg;
    
    public Notifier(Message1 msg) {
        this.msg = msg;
    }
	@Override
	public void run()
	{
		String name = Thread.currentThread().getName();
        System.out.println(name+" started");
        
        try
		{
			Thread.sleep(10);
			
			synchronized (msg)
			{
				msg.setMsg(name+" NOtifier work has been done ..............");
				//Wakes up a single thread that is waiting on this object's monitor. If any threads are waiting on this object, one of them is chosen to be
				//awakened. The choice is arbitrary and occurs at the discretion of the implementation. A thread waits on an object's monitor by calling one 
				//of the wait methods.
				
				msg.notify(); 
				//msg.notifyAll();
			}
		}
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
	}
	
}

//Java Thread join method can be used to pause the current thread execution until unless the specified thread is dead. There are three overloaded join 
 //functions.


