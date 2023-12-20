package com.other.threads;

import java.util.*;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;


/**
 * @author suresh babu J ---> Date 13 Aug 2018
 *
 */
public class QueueExample
{
	/*
	 * Queue is a special type of collection designed to hold elements before processing and order elements in a FIFO (first-in-first-out) manner. 
	 * It’s part of java collections framework.
	 * Java Queue is an interface available in java.util package and extends java.util.Collection interface.
		Just like Java List, Java Queue is a collection of ordered elements (Or objects) but it performs insert and remove operations differently. 
		We can use Queue to store elements before processing those elements.
		
		
    java.util.Queue interface is a subtype of java.util.Collection interface.
    Just like a real-world queue (for instance, in a bank or at ATM), Queue inserts elements at the end of the queue and removes from the beginning
     of the queue.
    Java Queue represents an ordered list of elements.
    Java Queue follows FIFO order to insert and remove it’s elements. FIFO stands for First In First Out.
    Java Queue supports all methods of Collection interface.
    Most frequently used Queue implementations are LinkedList, ArrayBlockingQueue and PriorityQueue.
    BlockingQueues do not accept null elements. If we perform any null related operation, it throws NullPointerException.
    BlockingQueues are used to implement Producer/Consumer based applications.
    BlockingQueues are thread-safe.
    All Queues which are available in java.util package are Unbounded Queues and Queues which are available in java.util.concurrent package are Bounded
     Queues.
    All Deques are not thread-safe.
    ConcurrentLinkedQueue is an unbounded thread-safe Queue based on linked nodes.
    All Queues supports insertion at the tail of the queue and removal at the head of the queue, except Deques.
    Deques are queues but they support element insertion and removal at both ends.

	
    int size(): to get the number of elements in the Set.
    boolean isEmpty(): to check if Set is empty or not.
    boolean contains(Object o): Returns true if this Set contains the specified element.
    Iterator iterator(): Returns an iterator over the elements in this set. The elements are returned in no particular order.
    boolean removeAll(Collection c): Removes from this set all of its elements that are contained in the specified collection (optional operation).
    boolean retainAll(Collection c): Retains only the elements in this set that are contained in the specified collection (optional operation).
    void clear(): Removes all the elements from the set.
    E remove(): Retrieves and removes the head of this queue.
    E poll(): Retrieves and removes the head of this queue, or returns null if this queue is empty.
    E peek(): Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
    boolean offer(E e): Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions.
    E element(): Retrieves, but does not remove, the head of this queue.
    boolean add(E e): Inserts the specified element into this queue if it is possible to do so immediately without violating capacity restrictions, 
    returning true upon success and throwing an IllegalStateException if no space is currently available.
    Object[] toArray(): Returns an array containing all of the elements in this set. If this set makes any guarantees as to what order its elements are
     returned by its iterator, this method must return the elements in the same order.
	
	 */

	public int queue[];
	public int front, rear, size,len;
	
	public QueueExample(int n)
	{
		size = n;
		len =0;
		queue = new int[size];
		front = -1; rear = -1;
	}
	
	public boolean isEmpty()
	{
		return front == -1;
	}
	
	public boolean isFull()
	{
		return front == 0 && rear == size - 1;
	}
	
	public int getSize()
	{
		return len;
	}
	//checck front element of the queue ...
	public int peek()
	{
		if(isEmpty())
			throw new NoSuchElementException("Underflow Exception ....");
		return queue[front];
	}
	
	public void insert(int i)
	{
		if(rear == -1)
		{
			front =0; rear =0;
			queue[rear] = i;
		}else if(rear +1 >= size)
			throw new NoSuchElementException("overflow Exception ....");
		else if(rear+1 < size)
			queue[++rear] = i;
			len++;
	}
	//remove front element from the queu
	public int remove()
	{
		if(isEmpty())
	           throw new NoSuchElementException("Underflow Exception");
		else{
			len--;
			int element =queue[front];
			if(front == rear)
			{
				front =-1; rear =-1;
			}
			else
				front++;
			return element;
		}
	}
	
	public void display()
	{
		System.out.println("\n Queue ---");
		if(len == 0){
			System.out.println("EMpty .........");
			return;
		}
		
		for(int i = front; i <= rear;i++)
			System.out.print(queue[i]+" ");
		System.out.println();
	}
	
	public static void main(String[] args)
	{
		linkedListQueue();
		
		System.exit(0);
        Scanner scan = new Scanner(System.in);
        System.out.println("Array Queue Test\n");
        System.out.println("Enter Size of Integer Queue ");
        int n = scan.nextInt();
        
        QueueExample qe =new QueueExample(n);
        
        char ch = 0;
        
        do
		{
            System.out.println("\nQueue Operations");

            System.out.println("1. insert");

            System.out.println("2. remove");

            System.out.println("3. peek");

            System.out.println("4. check empty");

            System.out.println("5. check full");

            System.out.println("6. size");

            int choice = scan.nextInt();
            
            switch (choice)
			{
				case 1:
	                System.out.println("Enter integer element to insert");
	                qe.insert(scan.nextInt());
					break;
					
				case 2:
                    System.out.println("Removed Element = "+qe.remove());
					break;
					
				case 3:
					System.out.println("Peek Element = "+qe.peek());
					break;
	            case 4 : 

	                System.out.println("Empty status = "+qe.isEmpty());

	                break;                

	            case 5 : 

	                System.out.println("Full status = "+qe.isFull());

	                break;                          

	            case 6 : 

	                System.out.println("Size = "+ qe.getSize());

	                break;                         
				default:
					break;
			}
            
            qe.display();            

            System.out.println("\nDo you want to continue (Type y or n) \n");

            ch = scan.next().charAt(0);
		}
		while (ch =='Y' || ch == 'y');
        
	}

	private static void linkedListQueue()
	{
		Queue<String> javaQueue =new LinkedList<String>();
		
		javaQueue.add("one");
		javaQueue.add("two");
		javaQueue.add("three");
		javaQueue.add("four");
		
		javaQueue.peek();
		//Retrieves, but does not remove, the head of this queue, or returns null if this queue is empty.
		System.out.println(javaQueue+" \n PEEK USE: "+javaQueue.peek());
		
		//Retrieves and removes the head of this queue, or returns null if this queue is empty.
		javaQueue.poll();
		
		System.out.println(javaQueue);
		
		//javaQueue.remove("one");
		
		//System.out.println(javaQueue+" QUEUE SIZE: "+javaQueue.size());
		
		//javaQueue.clear();
		
		//System.out.println("Afeter clear "+javaQueue+" contains ;;; "+javaQueue.contains("three"));
		
		// ***************** conver array to queue  ************************
		
		javaQueue =new LinkedList<String>();
		String name [] = {"suresh", "babu", "jay", "cccc"};
		Collections.addAll(javaQueue, name);
		
		System.out.println(javaQueue);
		
		// ************** Queue To java Array *********************
		javaQueue =new LinkedList<String>();
		
		javaQueue.add("f1");
		javaQueue.add("f2");
		javaQueue.add("f3");
		javaQueue.add("f4");
		
		String[] array = javaQueue.toArray(new String[javaQueue.size()]);
		
		System.err.println(Arrays.toString(array));
		
		
		//Insert 	add(e) 	offer(e)
		//Remove 	remove() 	poll()
		//Examine 	element() 	peek()
		System.out.println("ArrayBlockingQueue");
		BlockingQueue<String> queue = new ArrayBlockingQueue<>(3);

		System.out.println(queue.add("one"));
		System.out.println(queue.add("two"));
		System.out.println(queue);
		//The offer() operation is used to insert new element into the queue. If it performs insert operation successfully, 
		// it returns “true” value. Otherwise it returns “false” value.
		//System.out.println(queue.add("three"));
		System.out.println(queue.offer("three"));
		System.out.println(queue);
		
		System.out.println("QUEUE DELETE OPERTATIONAS ");
		
		Queue<String> queue1 = new LinkedList<>();
		queue1.offer("one");
		queue1.offer("two");		
		System.out.println(queue1);		
		System.out.println(queue1.remove());
		System.out.println(queue1.remove());		
		//System.out.println(queue1.remove());	
		
		//The poll() operation is used to delete an element from the head of the queue. If it performs delete operation successfully, it returns the 
		//head element of the queue. Otherwise it returns “null” value.
		System.out.println(" queue1.poll() operation ");
		queue1 = new LinkedList<>();
		queue1.offer("one");
		queue1.offer("two");		
		System.out.println(queue1);		
		System.out.println(queue1.poll());
		System.out.println(queue1.poll());		
		System.out.println(queue1.size());
		//System.out.println(queue1.poll());	
		
		//The element() operation is used to retrieve an element from the head of the queue, without removing it. If it performs examine operation 
		//successfully, it returns 
		//the head element of the queue. Otherwise it throws java.util.NoSuchElementException.
		//Bounded Queues are queues which are bounded by capacity that means we need to provide the max size of the queue at the time of creation. 
		// For example ArrayBlockingQueue 
		// Unbounded Queues are queues which are NOT bounded by capacity that means we should not provide the size of the queue. For example LinkedList
		//All Queues which are available in java.util package are Unbounded Queues and Queues which are available in java.util.concurrent package are 
		// Bounded Queues.
		
		//In other ways, W can broadly categorize them into the following two types:
		   // Blocking Queues && Non-Blocking Queues
		// All Queues which implement BlockingQueue interface are BlockingQueues and rest are Non-Blocking Queues.
		// BlockingQueues blocks until it finishes it’s job or time out, but Non-BlockingQueues do not.
		//Some operations are blocked until it finishes it’s job and other are blocked until time out.
		
		System.exit(0);
		
        BlockingQueue<String> bq = new ArrayBlockingQueue<>(10);
        
        bq.add("null");
        
        System.out.println(bq);
		
	}
}
