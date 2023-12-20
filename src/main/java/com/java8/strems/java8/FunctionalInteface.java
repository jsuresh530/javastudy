package com.java8.strems.java8;

@FunctionalInterface
interface SquareExample
{
	int Calculate(int x);
	
	default void otherTest() {
		
		System.err.println("i am from functioan inteface");
	}
	
	default void otherTest2() {
		
		System.err.println("i am from functioan inteface");
	}
	static void othermethid()
	{
		System.err.println("i am from functioan inteface");
	}
}

@FunctionalInterface
interface Sample{
	//abstract method
	int sum(int a, int b);
}

@FunctionalInterface
interface PersonalGreet {
	//Abstract method
	String personalGreet(String msg);
}
public class FunctionalInteface {

	public static void main(String[] args) {

		PersonalGreet personalGreet = (String msg) -> "Hello, "+msg;

		System.err.println (personalGreet.personalGreet ("Namaste"));

		System.exit (0);

		// implementing the abstract method of the interface
		Sample sample = (a,b) -> a+b;
		System.err.println ("testing : "+sample.sum (5,10));
		int a = 5;
		
		SquareExample s = (x) -> x*x;
		
		int ans = s.Calculate(a);
		
		System.err.println(ans);
		
		s.otherTest();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for (int i = 0; i < 10; i++) {
					System.err.println((5*(i+1)));
				}
			}
		}).start();
		
		new Thread (() -> {
				System.err.println ("Hell o Thread ...");
		}).start ();
		new Thread(() -> {
			for (int i = 1; i < 10; i++) {
				System.err.println("runnable : "+i);
			}
		}).start();
	}

}
