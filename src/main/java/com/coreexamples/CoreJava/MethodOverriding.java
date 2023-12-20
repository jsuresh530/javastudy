package com.coreexamples.CoreJava;

import java.util.HashSet;
import java.util.Set;

class X {
	
	public void test1(int a)
	{
		System.err.println("from A");
	}
	
	public void test1(Integer a)
	{
		System.err.println("from Integer A");
	}
	
	public void test1(int... a)
	{
		System.err.println("from Integer AA");
	}
	
}

class B extends X 
{
	public void test1(int a)
	{
		System.err.println("from B");
	}
	
	public void test1(Integer a)
	{
		System.err.println("from Integer B");
	}
	
	public void test1(int... a)
	{
		System.err.println("from Integer BB");
	}
	
}

class Test 
{
	private int id;
	private String name;
	
	public Test() {
		
	}
	
public Test(int i, String s) {
		this.setName(s);
		this.setId(i);
		
	}

@Override
public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + getId();
	result = prime * result + ((getName() == null) ? 0 : getName().hashCode());
	return result;
}

@Override
public boolean equals(Object obj) {
	if (this == obj)
		return true;
	if (obj == null)
		return false;
	if (getClass() != obj.getClass())
		return false;
	Test other = (Test) obj;
	if (getId() != other.getId())
		return false;
	if (getName() == null) {
		if (other.getName() != null)
			return false;
	} else if (!getName().equals(other.getName()))
		return false;
	return true;
}

@Override
public String toString() {
	return "Test [id=" + getId() + ", name=" + getName() + "]";
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public int getId() {
	return id;
}

public void setId(int id) {
	this.id = id;
}


}
public class MethodOverriding {

	public static void main(String[] args) {
		X a =new B();
		a.test1(0);
		
		Set<Test> set = new HashSet<>();
		Test t1 = new Test(1, "suresh");
		Test t2 = new Test(1, "suresh");
		set.add(t1);
		set.add(t2);
		
		System.err.println((t1 == t2)+" hascode : "+t1.hashCode()+" "+t2.hashCode());
		System.err.println(t1.equals(t2));
		
		System.err.println(set.toString());

	}

}
