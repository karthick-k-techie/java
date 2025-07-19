package com.kk.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ComparableBasic {
	public static void main(String[] args) {
		List<Member> member = new ArrayList<>();
		member.add(new Member("mikael", 182));
		member.add(new Member("matti", 187));
		member.add(new Member("ada", 184));

		// Java - 7 way

		System.out.println("List Before sorting=======");

		for (Member m : member) {
			System.out.println(m.getName());
			System.out.println(m.getHeight());
		}

		Collections.sort(member);
		System.out.println("!!!!!!!!List After sorting=======");

		for (Member m : member) {
			System.out.println(m.getName());
			System.out.println(m.getHeight());
		}

		// Java - 8 Way
		System.out.println("====Before Sorting...");
		member.stream().forEach(m -> System.out.println(m));
		System.out.println();
		// sorting the stream that is to be printed using the sorted method
		System.out.println("@@@@@sorting the stream that is to be printed using the sorted method@@@@@@@@@@@");
		member.stream().sorted().forEach(m -> System.out.println(m));
		System.out.println("...........Original without sorting............");
		member.stream().forEach(m -> System.out.println(m));
		// sorting a list with the sort-method of the Collections class
		System.out.println("=======sorting a list with the sort-method of the Collections class=========");
		Collections.sort(member);
		member.stream().forEach(m -> System.out.println(m));
	}
}

class Member implements Comparable<Member> {
	private String name;
	private int height;

	public Member(String name, int height) {
		this.name = name;
		this.height = height;
	}

	public String getName() {
		return this.name;
	}

	public int getHeight() {
		return this.height;
	}

	@Override
	public String toString() {
		return this.getName() + " (" + this.getHeight() + ")";
	}

	@Override
	public int compareTo(Member member) {
		/*
		 * if (this.height == member.getHeight()) { return 0; } else if (this.height >
		 * member.getHeight()) { return 1; } else { return -1; }
		 */
		// Sorting in Ascending order
		// return this.height-member.getHeight();
		// Sorting by Descending Order
		return member.getHeight() - this.height;
	}
}
