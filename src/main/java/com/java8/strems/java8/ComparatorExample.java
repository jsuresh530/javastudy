package com.java8.strems.java8;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

class Student 
{
	private int id;
	private String name;
	private String City;
	
	
	public Student(int id, String name, String city){
		this.id=id;
		this.name=name;
		this.City = city;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return City;
	}

	public void setCity(String city) {
		City = city;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", City=" + City + "]";
	}
	
	
	
}
public class ComparatorExample {

	public static void main(String[] args) {
		
		List<Student> s =new ArrayList<Student>();
		s.add(new Student(1, "Kibo", "mexico"));
		s.add(new Student(2, "Gubar", "Banglore"));
		s.add(new Student(11, "Bio", "Mumbai"));
		
		
		List<Student> collect = s.stream().sorted((i,j) -> i.getId()-(j.getId())).sorted((i,j) -> i.getName().compareTo(j.getName())).collect(Collectors.toList());
		
		System.err.println(collect);
		
		
		Comparator<Student> groupByComparator = Comparator.comparing(Student::getName).thenComparing(Student::getCity);
			
		s.sort(groupByComparator);
		System.err.println(s.toString());
		
		
		Comparator<Student> comp  = (o1,o2) -> o1.getCity().compareTo(o2.getCity());
		
		List<Student> collect2 = s.stream().sorted(comp).collect(Collectors.toList());
		

	}

}
