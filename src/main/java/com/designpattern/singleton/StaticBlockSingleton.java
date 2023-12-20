package com.designpattern.singleton;


/**
 * @author sjonnalagadda
 *Private constructor to restrict instantiation of the class from other classes.
 *Private static variable of the same class that is the only instance of the class.
 *Public static method that returns the instance of the class, this is the global access point for outer world to get the instance of the singleton class.
 *Static block initialization implementation is similar to eager initialization, except that instance of class is created in the static block that 
 *provides option for exception handling.
 *Both eager initialization and static block initialization creates the instance even before it’s being used and that is not the best practice to use. 
 */
public class StaticBlockSingleton
{
    private static StaticBlockSingleton instance;
    private StaticBlockSingleton(){}
    
    static
    {
    	 try{
             instance = new StaticBlockSingleton();
         }catch(Exception e){
             throw new RuntimeException("Exception occured in creating singleton instance");
         }
    }
    public static StaticBlockSingleton getInstance(){
        return instance;
    }
}
