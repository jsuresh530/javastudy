package com.designpattern.abstractfactory;


/**
 * @author sjonnalagadda
 * Abstract Factory pattern is almost similar to Factory Pattern except the fact that its more like factory of factories.
 * factory class returns different subclasses based on the input provided and factory class uses if-else or switch statement to achieve this.
 * In Abstract Factory pattern, we get rid of if-else block and have a factory class for each sub-class. Then an Abstract Factory class that will return 
 * the sub-class based on the input factory class. 
 * Abstract Factory design pattern provides approach to code for interface rather than implementation.
 */
public abstract class Computer
{
	public abstract String getRAM();
    public abstract String getHDD();
    public abstract String getCPU();
     
    @Override
    public String toString(){
        return "RAM= "+this.getRAM()+", HDD="+this.getHDD()+", CPU="+this.getCPU();
    }
}
