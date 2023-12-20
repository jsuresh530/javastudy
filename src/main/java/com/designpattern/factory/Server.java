package com.designpattern.factory;


/**
 * @author sjonnalagadda
 * We can keep Factory class Singleton or we can keep the method that returns the subclass as static.
 */
public class Server extends Computer
{
	private String ram;
	private String hdd;
	private String cpu;
	
	public Server(String ram, String hdd, String cpu)
	{
		super();
		this.ram = ram;
		this.hdd = hdd;
		this.cpu = cpu;
	}

	@Override
	public String getR()
	{
		return ram;
	}

	@Override
	public String getHD()
	{
		return hdd;
	}

	@Override
	public String getC()
	{
		return cpu;
	}
}
