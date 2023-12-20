package com.other.arrays;

// Thread Safe Singleton:

// synchronized method to control simultaneous access
/*
 * synchronized public static GFG getInstance() { if (instance == null) { // if
 * instance is null, initialize instance = new GFG(); } return instance; }
 */

// Bill Pugh Singleton Implementation: Prior to Java5, memory model had a lot of
// issues and above methods caused failure in certain scenarios in multithreaded
// environment. So, Bill Pugh suggested a concept of inner static classes to use
// for singleton.

public class GFG
{
	private GFG()
	{
	}

	// Inner class to provide instance of class
	private static class BillPughSingleton
	{
		private static final GFG INSTANCE = new GFG();
	}

	public static GFG getInstance()
	{
		return BillPughSingleton.INSTANCE;
	}

	public static void main(String[] args)
	{
		GFG instance = getInstance();
		GFG instance1 = getInstance();

		System.out.println(instance.hashCode() + " " + instance1.hashCode());
	}
}

// When the singleton class is loaded, inner class is not loaded and hence
// doesn’t create object when loading the class.
// Inner class is created only when getInstance() method is called. So it may
// seem like eager initialization but it is lazy initialization.
// This is the most widely used approach as it doesn’t use synchronization.
