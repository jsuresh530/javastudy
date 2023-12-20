package com.other.arrays;

import java.io.*;
import java.lang.reflect.InvocationTargetException;

class Singleton implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -3001587878608583912L;
	public static Singleton instance = new Singleton();
	
	private Singleton()
	{
		
	}
	
	// implement readResolve method
	// put back to singleton
    /*protected Object readResolve()
    {
        return instance;
    }*/
}

public class RemoveSingelton 
{

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException
	{
		/*Singleton instance1 = Singleton.instance;
	    Singleton instance2 = null;
	    
	    Constructor<?>[] declaredConstructors = Singleton.class.getDeclaredConstructors();
	    for (Constructor<?> constructor : declaredConstructors)
		{
	    	constructor.setAccessible(true);
	    	instance2 = (Singleton) constructor.newInstance();
	    	
	    	break;
		}
	    
	    System.out.println(instance1.hashCode()+" "+instance2.hashCode());*/
		
		//Using Serialization
		//Serialization can also cause breakage of singleton property of singleton classes. Serialization is used to convert an object of byte stream and 
		//save in a file or send over a network. Suppose you serialize an object of a singleton class. Then if you de-serialize that object 
		//it will create a new instance and hence break the singleton pattern. 
		
		
		try
		{
			Singleton instance1 = Singleton.instance;
			ObjectOutput out = new ObjectOutputStream(new FileOutputStream(new File("src/tes.txt")));
	        out.writeObject(instance1);
	        out.close();
 
        // deserailize from file to object
	        ObjectInput in = new ObjectInputStream(new FileInputStream(new File("src/tes.txt")));
	        Singleton instance2 = (Singleton) in.readObject();
	        in.close();
 
	        System.out.println("instance1 hashCode:- "+ instance1.hashCode());
	        System.out.println("instance2 hashCode:- " + instance2.hashCode());
		}catch(Exception e)
		{
			
		}
	}

}

