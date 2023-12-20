/**
 * 
 */
package com.other.algorithms;

import org.apache.commons.lang3.SerializationUtils;

import java.io.Serializable;


/**
 * @author sjonnalagadda
 *
 */
public class ObjectToByte implements Serializable
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -7701652142291814401L;
	private String name;
	private String address;
	private byte[] byteData;
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		ObjectToByte ob =new ObjectToByte();
		ob.setName("Suresh");
		ob.setAddress("hyd");
		ob.setByteData(objectTOByte(ob));
		
		System.err.println(deserialObject(ob.getByteData()).toString());
		//serialObject(ob.getByteData());
	}
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("ObjectToByte [name=").append(name).append(", address=").append(address).append("]");
		return builder.toString();
	}
	/**
	 * @param objectTOByte
	 */
	private static ObjectToByte deserialObject(byte[] objectTOByte)
	{
		ObjectToByte deserialize = SerializationUtils.deserialize(objectTOByte);
		return deserialize;
	}
	/**
	 * @param ob 
	 * 
	 */
	private static byte[] objectTOByte(ObjectToByte ob)
	{
		byte[] serialize = SerializationUtils.serialize(ob);
		return serialize;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getAddress()
	{
		return address;
	}
	public void setAddress(String address)
	{
		this.address = address;
	}
	public byte[] getByteData()
	{
		ObjectToByte ob = new ObjectToByte();
		ob.setName("Suresh");
		ob.setAddress("hyd");
		byteData = objectTOByte(ob);
		
		return byteData;
	}
	
	public void setByteData(byte[] byteData)
	{
		this.byteData = byteData;
		
	}
}
