package com.designpattern.BObserverPattern;

public interface Observer {
	
	// method to update the observer, used by the subject
	public void update();
	
	//attach the subject to observe
	public void setSubject(Subject sub);
	

}
