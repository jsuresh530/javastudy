package com.designpattern.TemplateDesignPattern;
public class WriteWithPencil extends WritingInstrument{

	public void openPenicil()
	{
		System.out.println("Sharpen pencil");
	}

	@Override
	public void startInstument() {
		openPenicil();
	}
	
}