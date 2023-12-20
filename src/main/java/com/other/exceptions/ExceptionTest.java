package com.other.exceptions;


/**
 * @author sjonnalagadda
 * java.lang ---> Object ---> Throwable --- 1) Exception   2) Error
 * 
 * Errors and RuntimeExceptions (and their subclasses– marked in red in Figure 1) are what are called unchecked exceptions: 
 * Runtime ---> Numberformat, nullpointer,classcast, indexoutofbound, illegalargument, arthemetic  are unchecked or runtime
 * Erro ---> ThreadDeath, IOError, virtualmacineerror --> outofmemory,stackoverflow error 
 * 
 * checked or compile time ---> io,sql malformed url exception.
 *   
 */
class test{
	
	public void m1() throws NullPointerException
	{
		System.err.println("i am from parent ...");
	}
}
public class ExceptionTest extends test
{
	public void m1() throws RuntimeException
	{
		System.err.println("i am from child ...");
	}

	public static void main(String[] args)
	{
		test t = new ExceptionTest();
		t.m1();
	}
}
