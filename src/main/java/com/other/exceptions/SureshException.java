package com.other.exceptions;

import javax.management.RuntimeErrorException;


public class SureshException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -2962710878627177168L;

	public SureshException(String msg)
	{
	}

	public static void main(String[] args)
	{
		try{ 
            // Throw an object of user defined exception 
            throw new SureshException("This is custome x  "); 
        } 
        catch (SureshException ex) 
        { 
            System.out.println("Caught"); 
            System.out.println(ex.getMessage()); 
            throw new RuntimeErrorException(null, "other exception ");
        } 
	}
}
