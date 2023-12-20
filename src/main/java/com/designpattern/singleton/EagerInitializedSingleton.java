

package com.designpattern.singleton;

/**
 * @author sjonnalagadda
 * Private constructor to restrict instantiation of the class from other classes. 
 * Private static variable of the same class that is the only instance of the class.
 * Public static method that returns the instance of the class, this is the global access point 
 * for outer world to get the instance of the singleton class.
 */
public class EagerInitializedSingleton
{
	private static final EagerInitializedSingleton instance =new EagerInitializedSingleton();
	//    //private constructor to avoid client applications to use constructor
	private EagerInitializedSingleton()
	{
		
	}
	
	public static EagerInitializedSingleton getInstance()
	{
		return instance;
	}
}
