package com.multithreads;

public class ThreadExample {

	public static void main(String[] args) {
		
		//new Thread(new ThreadExample()).start();
		Runnable R = () ->
		{
			for (int i = 0; i < 10; i++) {
				System.err.println(" TEE "+(i+1));
			}
		};
		new Thread(R).start();;
	}

}
