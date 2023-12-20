package com.coreexamples.CoreJava;

class BA 
{
	BA()
	{
		System.err.println("1");
	}
	static
	{
		System.err.println("2");
	}
}
public class ClassA extends BA{

	public ClassA() {
		// TODO Auto-generated constructor stub
		System.err.println("3");
	}
	static
	{
		System.err.println("4");
	}
	public static void main(String[] args) {
		
		//ClassA a = (ClassA) new B();
		//B b = new ClassA();
		
		BA b1 =new BA();

	}

}
