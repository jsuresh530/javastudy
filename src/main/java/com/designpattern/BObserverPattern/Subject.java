package com.designpattern.BObserverPattern;

public interface Subject {

	//methods to register and un register observers
	public void register(Observer obj);
	public void unRegister(Observer obj);
	
	//notify observers if there is any change
	public void notifyObservers();
	
	//update 
	public Object getUpdate(Observer obj);
	
}
 