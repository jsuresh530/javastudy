

package com.designpattern.singleton;

import java.io.Serializable;

/**
 * @author sjonnalagadda
 *Sometimes in distributed systems, we need to implement Serializable interface in Singleton class so that we can store it’s state in file system and retrieve 
 *it at later point of time. 
 *Here is a small singleton class that implements Serializable interface also.
 */
public class SerializedSingleton implements Serializable
{

	private static final long	serialVersionUID	= -4258255283044008573L;

	private SerializedSingleton()
	{
	}

	private static class SingletonHelper
	{
		private static final SerializedSingleton	INSTANCE	= new SerializedSingleton();
	}

	public static SerializedSingleton getInstance()
	{
		return SingletonHelper.INSTANCE;
	}
	
	//to get singleton pattern back 
	public Object readResolve() {
	    return getInstance();
	}
}
