

package com.designpattern.abstractfactory;

/**
 * @author sjonnalagadda
 * Notice that createComputer() method is returning an instance of super class Computer. Now our factory classes will implement this interface 
 * and return their respective sub-class.
 */
public interface ComputerAbstractFactory
{
	public Computer createComputer();
}