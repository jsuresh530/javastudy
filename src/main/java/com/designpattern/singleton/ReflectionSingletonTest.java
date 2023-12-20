package com.designpattern.singleton;

import java.lang.reflect.Constructor;


/**
 * @author sjonnalagadda
 *Using Reflection to destroy Singleton Pattern
 *When you run the above test class, you will notice that hashCode of both the instances are not same that destroys the singleton pattern. 
 *Reflection is very powerful and used in a lot of frameworks like Spring and Hibernate, 
 */
public class ReflectionSingletonTest
{
	public static void main(String[] args)
	{
		EagerInitializedSingleton instanceOne = EagerInitializedSingleton.getInstance();
		EagerInitializedSingleton instanceOne1 = EagerInitializedSingleton.getInstance();
		EagerInitializedSingleton instanceTwo = null;
		
		try
		{
			Constructor<?>[] constructors = EagerInitializedSingleton.class.getDeclaredConstructors();
			for (Constructor<?> constructor : constructors)
			{
				//Below code will destroy the singleton pattern
				constructor.setAccessible(true);
				instanceTwo = (EagerInitializedSingleton) constructor.newInstance();
				break;
			}
			
			System.out.println("1: "+instanceOne.hashCode()+" ----> 2: "+instanceOne1.hashCode()+" 3 ----> "+instanceTwo.hashCode());
		}
		catch (Exception e)
		{
		}
	}
}
