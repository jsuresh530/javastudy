package com.designpattern.BObserverPattern;

import java.util.ArrayList;
import java.util.List;

public class MyTopic implements Subject {

	private List<Observer> obList;
	private String message;
	private boolean ischanged;
	private final Object mutex = new Object();
	
	public MyTopic()
	{
		this.obList = new ArrayList<Observer>();
	}

	@Override
	public void register(Observer obj) {
		if(obj == null) throw new IllegalArgumentException("Null pointer");
		synchronized (mutex) {
			if(!obList.contains(obj)){
				obList.add(obj);
			}
		}
	}

	@Override 
	public void unRegister(Observer obj) {
		synchronized (mutex) {
			obList.remove(obj);
		}
	}

	@Override
	public void notifyObservers() {
		List<Observer> local = null;
		synchronized (mutex) {
			if(!ischanged)
				return;
				local =new ArrayList<Observer>(this.obList);
				this.ischanged =false;
		}
		
		for (Observer obj : local) {
			obj.update();
		}
	}

	@Override
	public Object getUpdate(Observer obj) {
		return this.message;
	}
	
	//method to post message to the topic
		public void postMessage(String msg){
			System.out.println("Message Posted to Topic:"+msg);
			this.message=msg;
			this.ischanged=true;
			notifyObservers();
		}

}
