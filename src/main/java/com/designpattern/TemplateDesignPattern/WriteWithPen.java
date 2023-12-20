package com.designpattern.TemplateDesignPattern;


public class WriteWithPen extends WritingInstrument{

	
	public void openPen()
	{
		System.out.println("Open pen");
	}


	@Override
	public void startInstument() {
		
		openPen();
		
	}
	
	public static void main(String[] args)
	{
		WriteWithPen pen =new WriteWithPen();
		pen.start();
		
		WriteWithPencil pencil =new WriteWithPencil();
		pencil.start();
	}
}
