package com.java8.strems.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee
{
	private String name1;
	private int id;
	private int salary;
	
	public Employee(int id, String name, int salary) {
		this.setId(id);
		this.setName1(name);
		this.setSalary(salary);
	}

	public String getName1() {
		return name1;
	}

	public void setName1(String name1) {
		this.name1 = name1;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}
}
public class ParallelStreamExample {

	public static void main(String[] args) {
		List<Employee> empList = new ArrayList<>();
		
		for (int i = 0; i < 100; i++) {
			empList.add(new Employee(1, "suresh", 1000));
			empList.add(new Employee(99, "babu", 15000));
			empList.add(new Employee(55, "krish", 12000));
		}
		
		
		long t1 = System.currentTimeMillis();
		
		System.err.println(empList.stream().filter(emp -> emp.getSalary() > 10000).count());
		
		long t2 = System.currentTimeMillis();
		
		System.err.println("Total time taken for stream in ms : "+(t2-t1));
		
		
		t1 = System.currentTimeMillis();
		
		System.err.println(empList.parallelStream().filter(emp -> emp.getSalary() > 10000).count());
		
		t2 = System.currentTimeMillis();
				
		System.err.println("Total time taken for stream in ms : "+(t2-t1));
		
		
		Stream<Integer> of = Stream.of(1,94,5,9,44,88);
		
		System.err.println(of.count());
		
		//Only once you can manipulate the stream
		of = Stream.of(1,94,5,9,44,88);
		
		long count = of.filter(i -> (i%2) == 0).count();
		
		System.err.println(count);
		
		//Other use here
		
		of = Stream.of(1,94,5,9,44,88);
		
		Long collect = of.collect(Collectors.counting());
		
		System.err.println("final count : "+collect);
		
		
 
	}

}
