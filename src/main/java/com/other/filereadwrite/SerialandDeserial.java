package com.other.filereadwrite;

import java.io.*;


public class SerialandDeserial implements Serializable
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -7955400926141238313L;
	private static String fileName ="src/serial.ser";
	
	private transient int number;
	private volatile transient String name;
	private String city;
    private String city2;
    private String city3;
 
    // Default constructor
    public SerialandDeserial(int a, String b, String c, String d, String e)
    {
        this.number = a;
        this.name = b;
        this.city= c;
        this.city2 =d;
        this.city3 =e;
        
    }
 
	public static void main(String[] args)
	{
		serializeFileds();
		
		deSerializeFileds();
		
	}

	private static void deSerializeFileds()
	{
		try
		{
			// Reading the object from a file
			FileInputStream fis = new FileInputStream(fileName);
			ObjectInputStream ois =new ObjectInputStream(fis);
			
			SerialandDeserial readObject = (SerialandDeserial) ois.readObject();
			
			ois.close();
			fis.close();
			
			System.out.println(readObject.city+" "+readObject.name+" "+readObject.number+" "+readObject.city2+" \n"+readObject.city3);
		}
		catch (Exception e)
		{
		}
	}

	private static void serializeFileds()
	{
		try
		{
			File f = new File(fileName);
			//if(!f.exists())
				//f.createNewFile();
			SerialandDeserial obj = new SerialandDeserial(12, "suresh", "hyder","Pune","The Serialization runtime associates a version number with each Serializable class called a SerialVersionUID, which is used during Deserialization to verify that sender and reciever of a serialized object have loaded classes for that object which are compatible with respect to serialization.");
			//Saving of object in a file
			FileOutputStream fos =new FileOutputStream(fileName);
			ObjectOutputStream oos =new ObjectOutputStream(fos);
			
			// Method for serialization of object
			oos.writeObject(obj);
			
			oos.close();
			fos.close();
			
			System.out.println("serialized scuusfully...........");
			
		}
		catch (Exception e)
		{
		}
		
	}
}
