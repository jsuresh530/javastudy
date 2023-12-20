package com.other.threads;
public class ThreadA {
	public static void main(String[] args) {
		ThreadB b = new ThreadB();
		b.start();
 
		System.out.println("Total is: " + b.total);
 
	}
}
 
class ThreadB extends Thread {
	int total =0;
	
	@Override
	public void run()
	{
		for (int i = 0; i < 100; i++)
		{
			total += i;
		}
	}
}