package com.java8.strems.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

@FunctionalInterface
interface MyInterface {
	int add(int a, int b);

	static String sub(){
		return "sub";
	}
}

public class BasicStream {

	public static void main(String[] args) {
		/* TODO Auto-generated method stub */

		MyInterface addTwo = (a, b) -> {
			return a+b;
		};

		System.err.println(addTwo.add(10, 20));


		// Uses a lambda expression
		BiFunction<Integer, Integer, Integer> func1 = (x, y) -> Integer.sum(x, y);
		System.out.println(func1.apply(2, 3));

		// Uses a method reference
		BiFunction<Integer, Integer, Integer> func2 = Integer::sum;
		System.out.println(func2.apply(2, 3));


		List<String> list= Arrays.asList("Babu","Buresh","Test","Yuzur");
		
		// filter and forEach flow

		for (String q : list) {
			if (q.startsWith("B")) {
				System.out.println(q);
			}
		}

		//filter and count
		
		long count = list.stream().filter( p -> p.startsWith("B")).count();
		
		System.err.println(count);
		
		//Intermediate operation

		//list.sort((a1,a2) -> a1.compareTo(a2));

		list.sort(Comparator.naturalOrder());
		
		//Terminal Operation
		
		list.forEach(a -> System.out.println("Teminal Opr : "+a));
		
		//Predicate
		
		List<Integer> listIntegers = new ArrayList<>();
		
		listIntegers.add(12);
		listIntegers.add(20);

		listIntegers.forEach (l -> System.err.println (l));

		Predicate<Integer>  predicate = i -> i > 5;
		
		listIntegers.stream().filter(predicate).forEach(i -> System.out.print(i+" "));
		
		//Function 
		
		Function<Integer, Integer> fun = i -> i/2;
		
		listIntegers.stream().map(fun).forEach(System.out::println);
		
		
		//System.exit(0);
		//Source -> Intermediate -> Terminal operations
		
		List<String> collect = list.stream().filter(p -> p.startsWith("B")).collect(Collectors.toList());
		
		System.err.println(collect);
		
		
		int sum = IntStream.range(1, 5).sum();
		
		System.err.println(sum);
		
		//reduce example
		
		Integer reduce = Stream.of(0,50,50).reduce(100, Integer::sum);
		
		System.err.println(reduce);
		
		
		
		List<String> list1 =new ArrayList<>();
			list1.add("suresh");
			list1.add("hareesh");
			list1.add("test");
			
		List<String> list2 = new ArrayList<>();
		
		list2.add("cucu");
		list2.add("dummy");
		
		
		List<String> collect2 = Stream.of(list1, list2).flatMap(l -> l.stream()).collect(Collectors.toList());
		
		System.err.println("collect2 "+collect2);
		
		//Intermediate operation
		
		List<Integer> collect3 = list1.stream().map(s -> s.length()).collect(Collectors.toList());
		
		System.err.println("MAP example : "+collect3);
		
		List<List<Integer>> listInt = new ArrayList<>();
		
			listInt.add(Arrays.asList(1,99,88));
			listInt.add(Arrays.asList(17,29,38));

		List<Integer> collect4 = listInt.stream().flatMap(listk -> listk.stream()).collect(Collectors.toList());
		System.err.println("collect4 "+collect4);
		
		
		List<String> strList = Arrays.asList("suresh","babu","Jonnalagadda");
		
		strList.stream().flatMap(Str -> Stream.of(Str.charAt(2))).forEach(System.out::println);
		
		strList.stream().flatMap(Str -> Stream.of(Str.charAt (1))).forEach(System.out::println);

		

	}

}


