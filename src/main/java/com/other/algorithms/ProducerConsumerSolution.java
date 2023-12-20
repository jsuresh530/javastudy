/**
 * 
 */


package com.other.algorithms;

import java.util.Vector;

/**
 * @author sjonnalagadda
 *
 */
public class ProducerConsumerSolution
{

	/**
	 * @param args
	 */
	public static void main(String[] args)
	{
		Vector v =new Vector();
		int size =4;
		
		Thread producer =new Thread(new Producer1(v, size), "Producer");
		Thread consumer =new Thread(new Consumer1(v, size), "Consumer");
		
		producer.start();
		consumer.start();
	}
}

class Producer1 implements Runnable
{

	private Vector	queue	= null;
	private int		size	= 0;

	public Producer1(Vector v, int n)
	{
		this.queue = v;
		this.size = n;
	}

	@Override
	public void run()
	{
		for (int i = 0; i < 7; i++)
		{
			System.err.println("Produced ..." + i);
			produce(i);
		}
	}

	/**
	 * @param i
	 */
	private void produce(int i)
	{
		while (queue.size() == size)
		{
			synchronized (queue)
			{
				System.out.println("Queue is full " + Thread.currentThread().getName() + " is waiting , size: " + queue.size());
				try
				{
					queue.wait();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		synchronized (queue)
		{
			queue.add(i);
			queue.notifyAll();
		}
	}
}

class Consumer1 implements Runnable
{

	private Vector	queue;
	private int		no;

	public Consumer1(Vector v, int n)
	{
		this.queue = v;
		this.no = n;
	}

	@Override
	public void run()
	{
		while (true)
		{
			System.err.println("Consumed ..."+consume());
		}
	}

	/**
	 * @return
	 */
	private int consume()
	{
		while (queue.isEmpty())
		{
			synchronized (queue)
			{
				System.err.println("Queue is empty ... "+Thread.currentThread().getName()+" Is waiting size "+queue.size());
				try
				{
					queue.wait();
				}
				catch (InterruptedException e)
				{
					e.printStackTrace();
				}
			}
		}
		synchronized (queue)
		{
			queue.notifyAll();
			return (int) queue.remove(0);
		}
	}
}
