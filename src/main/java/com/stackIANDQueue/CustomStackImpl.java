

package com.stackIANDQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class CustomStackImpl<T>
{

	private int			currentElementPosition	= 0;
	private Object[]	elements;
	private int			SIZE					= 10;

	public CustomStackImpl()
	{
		elements = new Object[SIZE];
	}

	// to retrive top most elemnt from stack..
	@SuppressWarnings("unchecked")
	public T pop()
	{
		// // retrieve top most element
		T t = (T) elements[--currentElementPosition];
		// empty its position
		elements[currentElementPosition] = null;
		return t;
	}

	public void push(T elementToPush)
	{
		// check if array is full
		if (currentElementPosition == elements.length)
		{
			expandSize();
		}
		elements[currentElementPosition++] = elementToPush;
	}

	public int size()
	{
		return currentElementPosition;
	}

	private void expandSize()
	{
		int increasedSize = elements.length * 2;
		elements = Arrays.copyOf(elements, increasedSize);
	}
	
	
	@Override
	public String toString()
	{
		StringBuilder builder = new StringBuilder();
		builder.append("CustomStackImpl [currentElementPosition=")
				.append(currentElementPosition).append(", elements=")
				.append(Arrays.toString(elements)).append(", SIZE=")
				.append(SIZE).append("]");
		return builder.toString();
	}

	public static void main(String[] args)
	{
		CustomStackImpl<Integer> cs = new CustomStackImpl<Integer>();
		cs.push(11);
		cs.push(177);
		cs.push(14);
		cs.push(12);
		
		cs.pop();
		cs.pop();
		cs.pop();
		cs.pop();
		
		cs.push(1111111);
		System.out.println(cs);
		
		StackUsingArrayList<Integer> sa = new StackUsingArrayList<Integer>();
		sa.push(44);
		sa.push(445);
		sa.push(55);
		
		System.out.println(sa.toString());
		
		sa.pop();
		
		System.out.println(sa.toString());
		
		
		findCounts();
	}
	
	
	public static void findCounts()
	{
		String s = "ss";
		
		Map<Character, Integer> map =new HashMap<Character, Integer>();
		char[] charArray = s.toCharArray();
		for (char c : charArray)
		{
			map.put(c, map.containsKey(c) ? map.get(c)+1 : 1);
		}
		
		System.out.print(map);
	}
}


class StackUsingArrayList<T> extends ArrayList<T> {

	/**
	 * 
	 */
	private static final long	serialVersionUID	= -2882937177189656013L;
	
	
	public void push(T t)
	{
		add(t);
	}
	
	public T pop()
	{
		int currentSize = size();
		T t = get(currentSize-1);
		remove(currentSize-1);
		return t;
	}
}
