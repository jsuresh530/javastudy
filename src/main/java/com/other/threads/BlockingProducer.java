package com.other.threads;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


public class BlockingProducer implements Runnable
{
	private BlockingQueue<Message> queue;
	
	public BlockingProducer(BlockingQueue<Message> q)
	{
		this.queue = q;
	}

	@Override
	public void run()
	{
		//Produce messages 
		for (int i = 0; i < 11; i++)
		{
			Message msg =new Message(""+i);
			
			try
			{
				Thread.sleep(i);
				queue.put(msg);
				System.out.println("Produced ... "+msg.getMsg());
			}
			catch (InterruptedException e)
			{
				e.printStackTrace();
			}
		}
		
		//adding exit message
        Message msg = new Message("exit");
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
	}
	
	 public static void main(String[] args)
		{
	    	//Creating BlockingQueue of size 10
	        BlockingQueue<Message> queue = new ArrayBlockingQueue<>(10);
	        BlockingProducer producer = new BlockingProducer(queue);
	        BlockingConsumer consumer = new BlockingConsumer(queue);
	        //starting producer to produce messages in queue
	        new Thread(producer).start();
	        //starting consumer to consume messages from queue
	        new Thread(consumer).start();
	        
	        System.out.println("Producer and Consumer has been started");
		}
}

class Message
{
private String msg;

public Message(String string)
{
	this.msg = string;
}

public String getMsg()
{
	return msg;
}

public void setMsg(String msg)
{
	this.msg = msg;
}
    
}

class BlockingConsumer implements Runnable
{
	private BlockingQueue<Message> queue;
    
    public BlockingConsumer(BlockingQueue<Message> q){
        this.queue = q;
    }
	@Override
	public void run()
	{
		Message msg;
		try
		{
			while((msg = queue.take()).getMsg() != "exit")
			{
				Thread.sleep(10);
	            System.out.println("Consumed **** "+msg.getMsg());
			}
			
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
