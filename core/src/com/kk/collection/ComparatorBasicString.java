package com.kk.collection;

import java.util.Arrays;
import java.util.Comparator;

// https://www.geeksforgeeks.org/java-comparator-interface/
public class ComparatorBasicString {

	public static void main(String[] args) {
		System.out.println("default natural sorting...");
		String[] names = { "Karthick", "Aarthi", "Ramesh", "Grey Joy" };
		Arrays.sort(names);
		for (String name : names)
			System.out.println(name);
		System.out.println("======== Custom sorting-1 Ascending Order =========");
		Arrays.sort(names, new ComparatorDemo());
		for (String name : names)
			System.out.println(name);
		System.out.println("======== Custom sorting-1 Desending Order =========");
		Arrays.sort(names, new ComparatorDemo() {
			@Override
			public int compare(Object o1, Object o2) {
				String s1 = (String) o1;
				String s2 = (String) o2;
				int result = s1.compareTo(s2);
				if (result > 0)
					return -1;
				else if (result < 0)
					return 1;
				else
					return 0;
			}
		});
		for (String name : names)
			System.out.println(name);
		System.out.println("======== Custom sorting-1 length wise Order =========");
		Arrays.sort(names, new ComparatorDemo() {
			@Override
			public int compare(Object o1, Object o2) {
				String s1 = (String) o1;
				String s2 = (String) o2;
				if (s1.length() > s2.length())
					return 1;
				else if (s1.length() < s2.length())
					return -1;
				else
					return 0;
			}
		});
		for (String name : names)
			System.out.println(name);
		System.out.println("======== Custom sorting-1 length wise reverse Order =========");
		Arrays.sort(names, new ComparatorDemo() {
			@Override
			public int compare(Object o1, Object o2) {
				String s1 = (String) o1;
				String s2 = (String) o2;
				if (s1.length() > s2.length())
					return -1;
				else if (s1.length() < s2.length())
					return 1;
				else
					return 0;
			}
		});
		for (String name : names)
			System.out.println(name);

		System.out.println(
				"======== Custom sorting-1 length wise reverse Order using java 8 Lambda way Try... =========");
		Arrays.sort(names, (o1, o2) -> {
			if (o1.length() > o2.length())
				return -1;
			else if (o1.length() < o2.length())
				return 1;
			else
				return 0;
		});
		for (String name : names)
			System.out.println(name);
	}

}

class ComparatorDemo implements Comparator<Object> {

	@Override
	public int compare(Object o1, Object o2) {
		String s1 = (String) o1;
		String s2 = (String) o2;
		int result = s1.compareTo(s2);
		if (result > 0)
			return 1;
		else if (result < 0)
			return -1;
		else
			return 0;
	}

}