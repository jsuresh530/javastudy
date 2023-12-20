package com.stackIANDQueue;

import java.util.ArrayList;
import java.util.List;



/*Queue is Collection of entities or elements in which >
Addition of element is done at REAR.
Removal of element is done at FRONT.
Queue follows FIFO (First in first out) - means  the first element added to the queue will be the first one to be removed.
 Insert - O(1) [as we insert element at Rear of queue] in java
Remove - O(1) [as we remove element from front of queue] in java

Queues and stacks are containers whose main methods for access are push() and pop()


    A Stack is a first-in, last-out data structure that pops elements in the opposite order than they were pushed. By default,
     a Stack uses an Array for its internal storage, although this can easily be changed. 
     
     A Queue is a first-in, first-out data structure that pops elements in the same order than they were pushed.
      By default, a Queue uses an SList for its internal storage, although this can easily be changed. 
      
      
    A PriorityQueue is a form of queue that keeps its elements in a quasi-sorted state and pops them based on their sorted order rather than in 
    the order that they were pushed. A PriorityQueue uses an Array for its underlying storage. 
*
*/

public class CustomQueueImpl
{
	private int[] queueArr;
	private int size;
	
	private int rear;
	private int front;
	private int number;
	
	public CustomQueueImpl(int size)
	{
		this.size =size;
		rear =0; front =0;
		queueArr = new int[this.size];
					
	}
	public void insert(int value)
	{
		if(isFull())
		{
			throw new QueueFullException("Can not insert "+value+" Queue is full ");
		}
		//We are at last position
		if(rear == size) rear =0;
		// Insert element and increment rear
		queueArr[rear++] =value;
		number++; //increase number of elements in Queue
	}
	
	public int remove()
	{
		if(isEmpty())
		{
			throw new QueueEmptyException("Queue is empty");
		}
		//value at front and than increment front
		int deletedNo = queueArr[front++];
		//deal with wrapAround
		if(front == size) front =0;
		//reduce number of elements in Queue
		number--;
		return deletedNo;
	}
	public boolean isEmpty()
	{
		return (number == 0);
	}
	public boolean isFull()
	{
		return (number == size);
	}
	public static void main(String[] args)
	{
		CustomQueueImpl queue = new CustomQueueImpl(10); // queue holds 10 elements
        
        queue.insert(31);
        queue.insert(49);

        queue.remove();
        queue.remove();

        queue.insert(90);
        queue.insert(81);
        queue.insert(72);
        queue.insert(22); // At this point we got to deal with wrapAround, because rear must be pointing to last position.
        
        List<CustomQueueImpl> myList = new ArrayList<CustomQueueImpl>();
        
        System.out.print("Deleted elements from queue: ");
        System.out.println(myList.size());
        //System.out.print(queue.remove()+ " ");
       // System.out.print(queue.remove()+ " ");
        //System.out.print(queue.remove()+ " ");
        
	}
}

class  QueueFullException extends RuntimeException
{
	/**
	 * 
	 */
	private static final long	serialVersionUID	= -127458813659242799L;

	public QueueFullException()
	{
		super();
	}
	
	public QueueFullException(String msg)
	{
		super(msg);
	}
}

class QueueEmptyException extends RuntimeException {
    
    /**
	 * 
	 */
	private static final long	serialVersionUID	= 9057580489430891828L;

	public QueueEmptyException(){
        super();
    }
    
    public QueueEmptyException(String message){
        super(message);
    }
}