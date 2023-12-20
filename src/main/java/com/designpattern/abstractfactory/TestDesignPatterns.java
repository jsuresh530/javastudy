

package com.designpattern.abstractfactory;

/**
 * @author sjonnalagadda
 * Abstract Factory pattern is almost similar to Factory Pattern except the fact that its more like factory of factories.
 * factory class returns different subclasses based on the input provided and factory class uses if-else or switch statement to achieve this.
 * In Abstract Factory pattern, we get rid of if-else block and have a factory class for each sub-class. Then an Abstract Factory class that will return 
 * the sub-class based on the input factory class. 
 * Abstract Factory design pattern provides approach to code for interface rather than implementation.
 * Abstract Factory pattern is “factory of factories” and can be easily extended to accommodate more products, for example we can add another 
 * sub-class Laptop and a factory LaptopFactory. Abstract Factory pattern is robust and avoid conditional logic of Factory pattern.
 * Abstract Factory Design Pattern Examples in JDK

    javax.xml.parsers.DocumentBuilderFactory#newInstance()
    javax.xml.transform.TransformerFactory#newInstance()
    javax.xml.xpath.XPathFactory#newInstance()
 */
public class TestDesignPatterns
{

	public static void main(String[] args)
	{
		testAbstractFactory();
	}

	private static void testAbstractFactory()
	{
		Computer pc = ComputerFactory.getComputer(new PCFactory("2 GB","500 GB", "2.4 GHz"));
		Computer server = ComputerFactory.getComputer(new ServerFactory("16 GB", "1 TB", "2.9 GHz"));
		
		System.out.println("AbstractFactory PC Config::" + pc);
		System.out.println("AbstractFactory Server Config::" + server);
	}
}