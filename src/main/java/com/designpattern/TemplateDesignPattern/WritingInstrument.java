

package com.designpattern.TemplateDesignPattern;

public abstract class WritingInstrument
{

	public WritingInstrument()
	{
		System.out.println("Test");
	}
	public void start()
	{
		takePaper();
		startInstument();
		write();
	}

	public void takePaper()
	{
		System.out.println("Take paper");
	}

	public void write()
	{
		System.out.println("Write");
	}

	public abstract void startInstument();

	public static void main(String[] args)
	{
		WriteWithPen pen = new WriteWithPen();
		pen.start();
		WriteWithPencil pencil = new WriteWithPencil();
		pencil.start();
	}
}
