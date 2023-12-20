

package com.designpattern.abstractfactory;

/**
 * @author sjonnalagadda
 *
 */
public class ComputerFactory
{

	public static Computer getComputer(ComputerAbstractFactory factory)
	{
		return factory.createComputer();
	}
}