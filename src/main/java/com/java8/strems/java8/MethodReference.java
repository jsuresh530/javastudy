package com.java8.strems.java8;

public class MethodReference {
	
	private String test;
	private int id;

	public static void main(String[] args) {
		
		
		
		MethodReference mr =new MethodReference();
		
		System.err.println(mr.toString());

		/*
		 * Method reference is shorthand for lambda expression here we can also write
		 * lambda expression like ()->process()
		 */

		Thread t = new Thread(MethodReference::process1);
		//t.start();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		result = prime * result + ((test == null) ? 0 : test.hashCode());
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
		MethodReference other = (MethodReference) obj;
		if (id != other.id)
			return false;
		if (test == null) {
			if (other.test != null)
				return false;
		} else if (!test.equals(other.test))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MethodReference [getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}

	public static void process1() {
		System.err.println("This is a mehod ref example");
	}

	public String getTest() {
		return test;
	}

	public void setTest(String test) {
		this.test = test;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
