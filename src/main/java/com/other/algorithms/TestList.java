package com.other.algorithms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


public class TestList
{

	public static void main(String[] args)
	{
		listTesting();
	}

	private static void listTesting()
	{
		List<Employee> list = new ArrayList<Employee>();
		Employee emp =new Employee();
		
		emp.setId(1);
		emp.setName("suresh");
		
		list.add(emp);
		
		emp = new Employee();
		
		emp.setId(3);
		emp.setName("babu");
		
		list.add(emp);
		
		emp = new Employee(1);
		
		
		for (Iterator<Employee> iter = list.listIterator(); iter.hasNext(); ) {
		    Employee a = iter.next();
		    if (a.getId() == emp.getId()) {
		        iter.remove();
		    }
		}
		for (Employee employee : list)
		{
			System.out.println(employee);
		}
	}
}
