/**
 * 
 */
package com.other.algorithms;


/**
 * @author sjonnalagadda
 *
 */
public class TestHashEquals
{
	private String name;
	
	private int number;
	
	
	/**
	 * 
	 */
	public TestHashEquals(String name)
	{
		this.name =name;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		TestHashEquals th =new TestHashEquals("babu");
		TestHashEquals th2 =new TestHashEquals("babu");
		System.err.println(" the "+th.hashCode()+" "+th2.hashCode());
		System.err.println(th.equals(th2));
	}
	
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + number;
		return result;
	}

	@Override
	public boolean equals(Object obj)
	{
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TestHashEquals other = (TestHashEquals) obj;
		if (name == null)
		{
			if (other.name != null)
				return false;
		}
		else if (!name.equals(other.name))
			return false;
		if (number != other.number)
			return false;
		return true;
	}



	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public int getNumber()
	{
		return number;
	}
	public void setNumber(int number)
	{
		this.number = number;
	}
}
