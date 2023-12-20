package com.java8.strems.java8;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExamples {

	public static void main(String[] args) {
		
		String s = "suresh nitin suresh akash ";
		
		//s = s.join("-", "babu");
		
		long count = s.chars().filter(c -> c == ' ').count();
		System.err.println("count "+count);
		
		Stream<String> stream = Stream.of("one","two","three","four","one");
		
		Set<String> set = new HashSet<>();
		
		stream.filter(value -> !set.add(value)).collect(Collectors.toList()).forEach(System.out::println);
		
		// count the occurances
		
		List<Integer> list = Arrays.asList(9,2,2,3,6,5,7,7);
		
		Map<Integer, Integer> collect = list.stream().collect(Collectors.toMap(Function.identity(), value -> 1, Integer :: sum));
		
		System.err.println(collect);
		
		//Strream exmples
		
		Stream<Integer> of = Stream.of(1,3,4,5,6,7,8);
		System.err.println("Stream count : "+of.count());
		
		 of = Stream.of(1,3,4,5,6,7,8);
		long count2 = of.filter(i -> (i%2 == 0)).count();
		
		System.err.println("There are "+count2+" even nos in the list");
		
		of = Stream.of(1,3,4,5,6,7,8);
		Long collect2 = of.collect(Collectors.counting());
		
		System.err.println(collect2);
		
		
		List<String> streamList = Arrays.asList(null,"Banana","Banglore","pune","Hyd");
		
		streamList.stream().forEach(System.out::println);
		
		List<String> collect3 = streamList.stream().filter(str -> (Objects.nonNull(str) && str.startsWith("B"))).map(k -> k.concat("B")).collect(Collectors.toList());

		System.err.println(collect3);
		
		
		
		List<String> streamList2 = Arrays.asList(null,"Banana","Banglore","pune","Hyd");
		
		//Merge two list
		System.err.println("\n \n \n RED ------------------------------ \n\n\n ");
		Stream.concat(streamList.stream(), streamList2.stream()).collect(Collectors.toList()).forEach(System.out::println);
		
		
		
		
		
		
	}

}
