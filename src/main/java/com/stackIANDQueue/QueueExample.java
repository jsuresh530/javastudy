package com.stackIANDQueue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class QueueExample
{
//poll ---> remove first element , peek ---> first element retrieve
	public static void main(String[] args)
	{
		//normalQueue();
		
		blockingQueue();
		
		
	}

	private static void blockingQueue()
	{
		BlockingQueue<String> bq = new ArrayBlockingQueue<String>(4);
		
		bq.add("suresh");
		bq.add("suresh1");
		bq.add("suresh1");
		bq.add("suresh3");
		
		System.out.println(bq.poll());
		
		
		System.out.println(bq);
		//System.out.println(bq.offer("three"));
	}

	private static void normalQueue()
	{
		Queue<String> queue = new LinkedList<String>();
		queue.add("suresh");
		queue.add("suresh1");
		queue.add("suresh1");
		queue.add("suresh3");
		
		System.out.println(queue.poll());
		
		String[] array = queue.toArray(new String[queue.size()]);
		
		System.out.println(queue.peek());
		
		System.out.println(Arrays.toString(array));
	}
}
