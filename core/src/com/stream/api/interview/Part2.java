package com.stream.api.interview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Part2 {

	public static void main(String[] args) {
//		basic();
//		intermediate();
		advanced();
	}

	public static void advanced() {
		System.out.println(
				"==========11. Get a sum of numbers of a two dimensional array and list of list of integers===========");
		int[][] twoDim = new int[][] { { 1, 2 }, { 3, 4 }, { 5, 6 },{7,8} };
		int sum = Arrays.stream(twoDim).flatMapToInt(nums -> Arrays.stream(nums)).sum();
		System.out.println(sum);

		List<List<Integer>> sums = Arrays.asList(Arrays.asList(1, 2, 3, 4), Arrays.asList(5, 6, 7, 8));
		//int sum2 = sums.stream().flatMap(nums->nums.stream()).mapToInt(num->num).sum();
//		Alternative
		int sum2 = sums.stream().flatMap(nums->nums.stream()).reduce((x,y)->x+y).get();
		System.out.println(sum2);
		
		System.out.println("======12. Convert an array of integers into a map where the key is the number and the value is its square=====");
		
		List<Integer> nums = Arrays.asList(1,2,3,4,5,6);
		nums.stream().collect(Collectors.toMap(num->num, num->num*num)).forEach((a,b)-> System.out.println(a +" "+b));
		System.out.println();
		int[] number = new int[] {1,2,3,4,5,6};
		Arrays.stream(number).mapToObj(Integer::valueOf).collect(Collectors.toMap(num->num, num->num*num)).forEach((a,b)-> System.out.println(a +" "+b));

		System.out.println("======13. Partition an array of integers into two groups: even and odd using Streams.======");
		nums.stream().collect(Collectors.partitioningBy(num->num%2==0)).forEach((a,b)->System.out.println(a + " " + b));
		System.out.println();
		Arrays.stream(number).mapToObj(Integer::valueOf).collect(Collectors.partitioningBy(num->num%2==0)).forEach((a,b)->System.out.println(a + " " + b));
		
		System.out.println("=====14. Calculate the product of all numbers in the array using reduce.=====");
		int asInt = Arrays.stream(number).reduce((a,b)-> a*b).getAsInt();
		System.out.println(asInt);
		
		System.out.println("====15. Implement a parallel stream that computes the sum of squares of numbers in an array.===");
		Integer integer = nums.parallelStream().map(num->num*num).reduce((x,y)-> x+y).get();
		System.out.println(integer);
		
		int reduce = Arrays.stream(number).map(num->num*num).sum();
		System.out.println(reduce);
		
	}

	public static void intermediate() {
		List<Integer> nums = Arrays.asList(66, 11, 22, 88, 33, 44, 99, 77, 55, 77);
		int[] numsArr = new int[] { 45, 23, 95, 13, 52, 27, 47, 81, 10, 38, 38 };

		System.out.println("=========6. Remove duplicate ellemnts from an array/list of integers.=========");
		nums.stream().distinct().forEach(System.out::println);
		Arrays.stream(numsArr).distinct().forEach(System.out::println);

		List<Integer> nums1 = Arrays.asList(1, 2, 3, 4, 5);
		int[] numsArr1 = new int[] { 1, 2, 3, 4, 5 };

		System.out
				.println("=======7. Convert a list/array of integers to a list of their squares and print them=======");
		nums1.stream().map(num -> num * num).forEach(System.out::println);
		// Alternative
		nums1.stream().map(num -> Math.pow(num, 2)).forEach(System.out::println);

		System.out.println("=======8. Find the sum of squares of all the numbers in the array / list.=======");
		int sum = nums1.stream().mapToInt(num -> num * num).sum();
		System.out.println(sum);
		// Alternative
		int sum1 = nums1.stream().map(num -> num * num).reduce(0, (x, y) -> x + y);
		System.out.println(sum1);
		double sum2 = Arrays.stream(numsArr1).mapToDouble(num -> num * num).sum();
		System.out.println(sum2);

		System.out.println("=====9. Get the second largest number and second smallest number in a list/array======");
		Optional<Integer> secondsamllest = nums.stream().sorted().skip(1).findFirst();
		if (secondsamllest.isPresent())
			System.out.println(secondsamllest.get());
		Optional<Integer> secondLargest = nums.stream().sorted(Comparator.reverseOrder()).skip(1).findFirst();
		if (secondLargest.isPresent())
			System.out.println(secondLargest.get());
		OptionalInt first = Arrays.stream(numsArr).sorted().skip(1).findFirst();
		if (first.isPresent())
			System.out.println(first.getAsInt());
		Optional<Integer> second = Arrays.stream(numsArr).mapToObj(Integer::valueOf).sorted(Comparator.reverseOrder())
				.skip(1).findFirst();
		if (second.isPresent())
			System.out.println(second.get());
		System.out.println("========10. Get the first number greater than 50 in a list/array=======");
		Optional<Integer> first2 = nums.stream().filter(a -> a > 50).findFirst();
		if (first2.isPresent())
			System.out.println(first2.get());
		OptionalInt first3 = Arrays.stream(numsArr).filter(a -> a > 50).findFirst();
		if (first3.isPresent())
			System.out.println(first3.getAsInt());

	}

	public static void basic() {

		List<Integer> nums = Arrays.asList(66, 11, 22, 88, 33, 44, 99, 77, 55);
		int[] numsArr = new int[] { 45, 23, 95, 13, 52, 27, 47, 81, 10, 38 };

		System.out.println("=====1. Get the even/odd numbers from an array of numbers and list of numbers======");
		System.out.println("---------Even--------");
		nums.stream().filter(num -> num % 2 == 0).forEach(System.out::println);
		System.out.println("-------Odd-----");
		Arrays.stream(numsArr).filter(num -> num % 2 != 0).forEach(System.out::println);

		System.out.println("======2. Get the even/odd numbers between a range======");

		IntStream.range(50, 70).filter(num -> num % 2 == 0).forEach(System.out::println);

		System.out.println("===========3. Sort a list of integers in desending / ascending order===========");
		System.out.println("Ascending Order");
		nums.stream().sorted().forEach(System.out::println);

		System.out.println("Descending Order");
		nums.stream().sorted((a, b) -> b - a).forEach(System.out::println);
		// Alternative way
		nums.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).forEach(System.out::println);
		System.out.println("----------Array--------------");
		Arrays.stream(numsArr).boxed().sorted((a, b) -> b - a).forEach(System.out::println);
		// Alternative
		Arrays.stream(numsArr)
				// .boxed()
				.mapToObj(Integer::valueOf).sorted(Comparator.comparing(Integer::intValue).reversed())
				.forEach(System.out::println);

		System.out.println(
				"===========4. Calculate the sum and average of numbers in an array and list of numbers ===========");
		int sum = Arrays.stream(numsArr).sum();
		System.out.println(sum);
		OptionalDouble average = Arrays.stream(numsArr).average();
		if (average.isPresent())
			System.out.println(average.getAsDouble());

		int sum2 = nums.stream().mapToInt(a -> a.intValue()).sum();
		sum2 = nums.stream().mapToInt(a -> a.intValue()).sum();
		System.out.println(sum2);
		OptionalDouble average2 = nums.stream().mapToInt(a -> a.intValue()).average();
		if (average2.isPresent())
			System.out.println(average2.getAsDouble());

		// Alternate

		Optional<Integer> reduce = nums.stream().reduce((x, y) -> x + y);
		if (reduce.isPresent())
			System.out.println(reduce.get());

		System.out.println("=======5. Find the maximum/Minimum number in an array/list of numbers========");
		OptionalInt min = Arrays.stream(numsArr).min();
		if (min.isPresent())
			System.out.println(min.getAsInt());
		OptionalInt max = Arrays.stream(numsArr).max();
		if (max.isPresent())
			System.out.println(max.getAsInt());

		OptionalInt min2 = nums.stream().mapToInt(Integer::valueOf).min();
		if (min2.isPresent())
			System.out.println(min2.getAsInt());
		OptionalInt max2 = nums.stream().mapToInt(a -> a.intValue()).max();
		if (max2.isPresent())
			System.out.println(max2.getAsInt());

	}

}
