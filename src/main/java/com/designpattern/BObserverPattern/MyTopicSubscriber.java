package com.designpattern.BObserverPattern;

public class MyTopicSubscriber implements Observer{
	
	private String name;
	// Car has a Engine and Car is a Automobile
	
	/*
	 * class Engine {} // The Engine class.

		class Automobile {} // Automobile class which is parent to Car class.

	class Car extends Automobile { // Car is an Automobile, so Car class extends Automobile class.
  		private Engine engine; // Car has an Engine so, Car class has an instance of Engine class as its member.
	}
	if I wanted to say that a car "has-a" gas tank, I would use composition,
	public class Car {
		private GasTank myCarsGasTank;
		}
	 */
	private Subject topic;
	
	public MyTopicSubscriber(String msg)
	{
		this.name =msg;
	}

	@Override
	public void update() {
		String msg = (String) topic.getUpdate(this);
		if(msg == null)
		{
			System.out.println(name+" No new msg...");
		}else
		{
			System.out.println(name+" Consuming msg "+msg);
		}
	}

	@Override
	public void setSubject(Subject sub) {
		this.topic = sub;
	}

}
