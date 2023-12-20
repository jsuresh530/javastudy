package com.stackIANDQueue;

import java.util.Enumeration;
import java.util.Stack;


public class Stacks1
{

	public static void main(String[] args)
	{
		 Stack<String> stack = new Stack<String>();
		    stack.push( "bat" );
		    stack.push( "cat" );
		    stack.push( "dog" );
		    System.out.println( "stack = " + stack );
		    System.out.println();
		    
		    
		    System.out.println( "Non-destructively enumerate the Stack." );
		    /*Enumeration e = stack.elements();
		    while ( e.hasMoreElements() )
		      System.out.println( e.nextElement() );
		    System.out.println();

		    System.out.println( "Pop and print each element." );
		    while ( !stack.isEmpty() )
		      System.out.println( stack.pop() );*/
		    
		    Enumeration<String> elements = stack.elements();
		    while (elements.hasMoreElements())
			{
				System.out.println(elements.nextElement());System.out.println();
			}
		    System.out.println( "Pop and print each element." );
		    
		    while(!stack.isEmpty())
		    {
		    	//Removes the object at the top of this stack and returns that object as the value of this function.
		    	System.out.println(stack.pop());
		    }
	
	// By default, a Stack uses an Array for its underlying storage. To change this to a different container, supply the container when the Stack is constructed.
	}
}
