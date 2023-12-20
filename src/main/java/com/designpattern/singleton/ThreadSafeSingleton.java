

package com.designpattern.singleton;

/**
 * @author sjonnalagadda Above implementation works fine and provides thread-safety but it reduces
 *         the performance because of cost associated with the synchronized method, although we need
 *         it only for the first few threads who might create the separate instances (Read: Java
 *         Synchronization). To avoid this extra overhead every time, double checked locking
 *         principle is used.
 */
public class ThreadSafeSingleton
{

	private static ThreadSafeSingleton	instance;

	private ThreadSafeSingleton()
	{
	}

	public static synchronized ThreadSafeSingleton getInstance()
	{
		if (instance == null)
		{
			instance = new ThreadSafeSingleton();
		}
		return instance;
	}
	
	public static  ThreadSafeSingleton getInstance1()
	{
		if (instance == null)
		{
			synchronized (ThreadSafeSingleton.class)
			{
				if (instance == null)
				{
					instance = new ThreadSafeSingleton();
				}
			}
		}
		return instance;
	}
}