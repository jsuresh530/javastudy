package com.designpattern.singleton;

import java.io.*;


/**
 * @author sjonnalagadda
 * So it destroys the singleton pattern, to overcome this scenario all we need to do it provide the implementation of readResolve() method.
 */
public class SingletonSerializedTest
{
	
	
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
        File f = new File("src/filename.ser"); if(!f.exists()) f.createNewFile();
		SerializedSingleton instance1 = SerializedSingleton.getInstance();
		
		ObjectOutputStream oos =new ObjectOutputStream(new FileOutputStream(f));
		oos.writeObject(instance1);
		oos.close();
		
		ObjectInputStream ois =new ObjectInputStream(new FileInputStream(f));
		SerializedSingleton instance2 = (SerializedSingleton) ois.readObject();
		ois.close();
		
		System.out.println("instanceOne hashCode = "+instance1.hashCode());
        System.out.println("instanceTwo hashCode = "+instance2.hashCode());
    }
}
