/**
 * 
 */
package com.other.algorithms;


/**
 * @author sjonnalagadda
 *
 */
public class PassBYValue
{
	
	// swap() doesn't swap i and j 
	   public static void swap(Integer i, Integer j) { 
	      Integer temp = new Integer(i); 
	      i = j; 
	      j = temp; 
	      //i =30;
	      //j=40;
	   } 
	   public static void main(String[] args) { 
	      Integer i = new Integer(10); 
	      Integer j = new Integer(20); 
	      swap(i, j); 
	      System.out.println("i = " + i + ", j = " + j); 
	   } 
}
