package com.java8.strems.java8;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class User
{
	private int id;
	
	private String name;
	
	private int age;
	
	public User()
	{
		
	}
	
	public User(int id, String name, int age)
	{
		this.setId(id);
		this.setName(name);
		this.setAge(age);
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", age=" + age + "]";
	}
	
	
	
}
public class SortList {

	public static void main(String[] args) {
		
		List<String> list = Arrays.asList("suresh","babu","navya","yasw");
		
		List<String> collect = list.stream().sorted(Collections.reverseOrder()).collect(Collectors.toList());
		
		System.err.println("before sort : "+list);
		System.err.println("After sorting : "+collect);

		
		//Map and flatmap associated with optional class 
		
		List<String> of = Stream.of("suresh","babu").map(String::toUpperCase).collect(Collectors.toList());
		
		System.err.println(of);
		
		Stream<String> stream1 = Stream.of("Hello","one");
		Stream<String> stream2 = Stream.of("babu","Jai");
		
		Stream<Stream<String>> streamOf = Stream.of(stream1, stream2);
		
		List<String> result = streamOf.flatMap(s -> s).collect(Collectors.toList());
		
		System.err.println(result);
		
		
		List<User> userList = new ArrayList<>();
		userList.add(new User(1, "yash",1));
		userList.add(new User(99, "suresh",31));
		userList.add(new User(32, "navya",27));
		
		List<User> user = userList.stream().sorted(Comparator.comparingInt(User::getAge).reversed()).collect(Collectors.toList());
		
		
		List<User> user1 = userList.stream().sorted((a1,a2) -> a1.getAge() - (a2.getAge())).collect(Collectors.toList());

		
		user1.forEach(System.out::println);
		
		String s = "suresh nitin suresh akash ";
		
		int countValue = (int) s.chars().filter(c -> c == ' ').count();
		System.err.println("count "+countValue);
		//System.err.println(user.toString());
	}

}
