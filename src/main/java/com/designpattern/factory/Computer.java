package com.designpattern.factory;


/**
 * @author sjonnalagadda
 * alt shift j Super class in factory design pattern can be an interface, abstract class or a normal java class.
 * We can keep Factory class Singleton or we can keep the method that returns the subclass as static.
 */
public abstract class Computer
{
	public abstract String getR();
	public abstract String getHD();
	public abstract String getC();
	
	public void concretw()
	{
		System.out.println("i am concrete ");
	}
	
	public Computer()
	{
		
	}
	@Override
	public String toString()
	{
		return "RAM= "+this.getR()+", HDD="+this.getHD()+", CPU="+this.getC();
	}
	
}
