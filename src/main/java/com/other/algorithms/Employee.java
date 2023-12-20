package com.other.algorithms;


public class Employee
{
	private int id;
	
	private String name;
	public Employee()
	{
		
	}
	public Employee(Integer id)
	{
		this.id = id;
	}

	
	public String getName()
	{
		return name;
	}

	
	public void setName(String name)
	{
		this.name = name;
	}


	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [id=").append(getId()).append(", name=").append(name).append("]");
		return builder.toString();
	}
	public int getId()
	{
		return id;
	}
	public void setId(int id)
	{
		this.id = id;
	}
	
	
	
}
