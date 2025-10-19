package com.stream.api.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//Top Coding Interview Questions in Streams API | Using a list of Strings - Part I
//https://www.youtube.com/watch?v=3IHYVYtMcNo&list=PLJ-lrQx0LAbzeDHMZ9iUKDdcQkIe9li7v&index=10

public class Part1 {

	public static void main(String[] args) {
		// Part1.basics();
		// Part1.intermediate();
		Part1.advanced();
	}

	public static void advanced() {
		System.out.println(
				"======14. Given a list of Strings, group a list of Strings by the first letter of each string using streams.=====");
		List<String> fruits = Arrays.asList("apple", "sky", "orange", "bannana", "pineapple", "berry", "strawberry",
				"kiwi", "berry", "kiwi");
		Map<Character, List<String>> collect = fruits.stream().collect(Collectors.groupingBy(str -> str.charAt(0)));
//		collect.forEach((t, u) -> System.out.println(t +"\t"+u));

		System.out
				.println("=======15. given a list of strings, group a list of strings by the length of the string.\r\n"
						+ "======");
		// fruits.stream().collect(Collectors.groupingBy(String::length)).forEach(
		// (x,y)->{System.out.println(x+"\t"+y);});
		System.out.println(
				"=======16. Given a list of strings, create a map where the key is the last letter of the string, and the value is a list of strings that end with that letter using streams.=======");
		Map<Character, List<String>> collect2 = fruits.stream()
				.collect(Collectors.groupingBy(str -> str.charAt(str.length() - 1)));
		// collect2.forEach((a,b)-> System.out.println(a +"\t"+b));
		System.out.println(
				"======17. Given a list of strings, group the list of strings with vowels and no vowels into two lists.=========");
		Map<Boolean, List<String>> collect3 = fruits.stream()
				.collect(Collectors.partitioningBy(str -> str.matches(".*[aeiou].*")));
		collect3.forEach((key, value) -> System.out.println(key + "\t" + value));
		
		System.out.println("=======18. Given a list of strings print only the string elements excluding the digits using streams.=======");

		List<String> words = Arrays.asList("karthi","kk100","1234","1234567890");
		//words.stream().filter(str->!str.matches(".*[0-9].*")).forEach(System.out::println);
		
		System.out.println("=======19. Given a list of strings find the first element having the length as 10 if not handle exception.=======");
		String val = words.stream().filter(str->str.length()==10).findAny().orElseThrow();	
		//System.out.println(val);
		
		System.out.println("=====20. Reverse the list of string using stream API.=====");
		
		IntStream.range(0, fruits.size())
		.mapToObj(i->fruits.get(fruits.size()-1-i)).forEach(System.out::println);
		
		
		
		
	}

	public static void intermediate() {
		System.out.println(
				"========8. Sort the list of strings  based on their lengths in assending/desending order.==========");
		List<String> fruits = Arrays.asList("apple", "sky", "orange", "bannana", "pineapple", "berry", "strawberry",
				"kiwi", "berry", "kiwi");
		// fruits.stream().sorted((o1,o2)->((Integer)o1.length()).compareTo(o2.length())).forEach(System.out::println);
		fruits.stream().sorted(Comparator.comparing(String::length)).forEach(System.out::println);

		System.out.println("======9. Find the longest word in the list.===");
		Optional<String> longestWord = fruits.stream().max(Comparator.comparing(String::length));
		longestWord.ifPresent(str -> System.out.println(str.toUpperCase()));

		System.out.println("=====10. Get the list of Strings having vowels=======");

		fruits.stream().filter(str -> str.matches(".*[aeiou].*")).forEach(System.out::println);

		System.out.println(
				"=======11. Convert a list of Strings into a single string, seprated by commas, using streams===========");
		String combinedword = fruits.stream().collect(Collectors.joining(","));
		System.out.println(combinedword);
		System.out.println(
				"======12. Write a java program to create a new list of strings, where each string is reversed from the original list, using java streams.========");

		fruits.stream().map(str -> new StringBuffer(str).reverse()).forEach(System.out::println);

		System.out.println(
				"=====13. Write a java program to remove all strings from the list that are empty or null using streams=====");

		List<String> fruits1 = Arrays.asList("apple", "", "sky", "orange", "bannana", "pineapple", "berry",
				"strawberry", "kiwi", "berry", "kiwi", null);
		fruits1.stream().filter(str -> str != "" && str != null).forEach(System.out::println);
	}

	public static void basics() {

		List<String> fruits = Arrays.asList("apple", "orange", "bannana", "pineapple", "berry", "strawberry", "kiwi",
				"berry", "kiwi");

		// 1. Convert a list of Strings to upperCase, sort them and print
		System.out.println("=======1. Convert a list of Strings to upperCase, sort them and print==========");
		fruits.stream()
				// .map(f->f.toUpperCase())
				.map(String::toUpperCase).sorted().forEach(System.out::println);

		// 2. Get the list of Strings where the length of each element is > 5 and get
		// the count
		System.out.println(
				"=====2. Get the list of Strings where the length of each element is > 5 and get the count====");
		long count = fruits.stream().filter(s -> s.length() > 5).count();
		System.out.println(count);

		// 3. Remove duplicates from a list
		System.out.println("===3. Remove duplicates from a list====");
		fruits.stream().distinct().forEach(System.out::println);

		// 4. Get the list of strings having a particular word
		System.out.println("====4. Get the list of strings having a particular word====");
		fruits.stream().filter(s -> s.contains("berry")).forEach(System.out::println);

		// 5. Write a Java Program to remove strings that start with a specific word
		// from a list using streams.
		System.out.println(
				"======5. Write a Java Program to remove strings that start with a specific word from a list using streams.========");
		fruits.stream().filter(s -> !s.startsWith("b")).forEach(System.out::println);

		// 6. Find the first element in a list that starts with a particular letter.
		System.out.println("=====6. Find the first element in a list that starts with a particular letter.=======");
		Optional<String> element = fruits.stream().filter(s -> s.startsWith("b")).findFirst();
		if (element.isPresent())
			System.out.println(element.get());
		else
			System.err.println("Not found..");

		// 7. Get the length of each name in a list
		System.out.println("======7. Get the length of each name in a list====");
		fruits.stream().map(String::length).forEach(System.out::println);
	}

}
