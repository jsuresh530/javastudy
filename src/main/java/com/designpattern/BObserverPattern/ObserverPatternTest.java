package com.designpattern.BObserverPattern;

public class ObserverPatternTest {
	public static void main(String[] args) {

		
		MyTopic mt =new MyTopic();
		
		Observer  obs1 = new MyTopicSubscriber("Obj1");
		Observer  obs2 = new MyTopicSubscriber("Obj2");
		Observer  obs3 = new MyTopicSubscriber("Obj3");
		
		//register observers to the subject
		mt.register(obs1);
		mt.register(obs2);
		mt.register(obs3);
		
		//attach observer to subject
		obs1.setSubject(mt);
		obs2.setSubject(mt);
		obs3.setSubject(mt);
		
		//check if any update is available
		obs1.update();
		
		//now send message to subject
		mt.postMessage("New Msg....");
		
		
		
		
	}
}

