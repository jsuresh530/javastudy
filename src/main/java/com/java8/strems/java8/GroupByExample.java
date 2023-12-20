package com.java8.strems.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GroupByExample {
	
	static class Employee

	{
		
		private int id;
		private String dep;
		private String name;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getDep() {
			return dep;
		}
		public void setDep(String dep) {
			this.dep = dep;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		public Employee(int id, String dep, String name)
		{
			super();
			this.id =id;
			this.name=name;
			this.dep =dep;
			
		}
		
	}
	

	public static void main(String[] args) {
		
		List<Employee> asList = Arrays.asList(new Employee(4, "IT", "suresh"), new Employee(1, "Sales", "see"), new Employee(551,"QA", "Mahesh"));

		Map<String, List<Employee>> collect = asList.stream().collect(Collectors.groupingBy(Employee :: getDep));
		
		collect.forEach((k,v) -> System.err.println("Key is : "+k+" : "+((List<Employee>) v).stream().map(m -> m.getName())
				
				.collect(Collectors.joining(","))));
		
		// 
		
		removeDuplicateListElements();
		
		mergeStreams();
	}
	
	
	
	public static void removeDuplicateListElements()
	{
		
		List<Integer> duplist = new ArrayList<Integer>(Arrays.asList(5,5,7,88,-9,-8,99));
		
		System.err.println("List with duplicates : "+duplist);
		
		List<Integer> collect = duplist.stream().distinct().collect(Collectors.toList());
		
		System.err.println("After duplicates : "+collect);
		
		
		List<String> asList = Arrays.asList("A","A","A","B","C");
		
		System.err.println("After duplicates : "+asList.stream().distinct().collect(Collectors.toList()));
		
		
		
		// filter list add element
		
		asList = Arrays.asList(null,"A","AB","AB","B","C");
		
		List<String> collect2 = asList.stream().filter(s -> Objects.nonNull(s) && s.startsWith("A")).map(s -> s.concat("B")).collect(Collectors.toList());
	
		System.err.println("Append chars: "+collect2);
	}
	
	
	public static void mergeStreams()
	{
		Stream<String> one = Stream.of("A","B");
		Stream<String> two = Stream.of("C","B");
		
		Stream<String> concat = Stream.concat(one, two);
		System.err.println("Concat streams : "+concat.distinct().collect(Collectors.toList()));
		
	}

}
