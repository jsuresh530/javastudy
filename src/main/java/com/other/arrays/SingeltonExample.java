package com.other.arrays;

public class SingeltonExample
{
	//Lazy initialization with Double check locking
	private static SingeltonExample instance = null;
	
	private SingeltonExample()
	{
		
	}

	public static SingeltonExample getInstance()
	{
		if(instance == null)
		{
			synchronized (SingeltonExample.class)
			{
				instance = new SingeltonExample();
			}
		}
		return instance;
	}
	public static void main(String[] args) throws SecurityException, ClassNotFoundException
	{
		Class.forName("").getConstructors();
		
		SingeltonExample instance2 = getInstance();
		SingeltonExample instance3 = getInstance();
		
		System.out.println(instance3.hashCode());
		System.out.println(instance2.hashCode());
	}
}