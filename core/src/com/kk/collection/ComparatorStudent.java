package com.kk.collection;

//Using Comparator Interface
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorStudent {

	public static void main(String[] args) {
		// List of Students
		List<Student> students = new ArrayList<>();

		// Add Elements in List
		students.add(new Student(111, "Mayank", 50));
		students.add(new Student(131, "Anshul", 40));
		students.add(new Student(121, "Solanki", 20));
		students.add(new Student(101, "Aggarwal", 55));

		// Sort students by roll number
		// using SortbyRoll comparator
		Collections.sort(students, new SortbyRoll());

		System.out.println("*****Sorted by Roll Number ********");

		// Iterating over entries to print them
		for (int i = 0; i < students.size(); i++)
			System.out.println(students.get(i));

		// Sort students by name, then by age
		System.out.println("=====Sort students by name, then by age=====");
		// using the CustomerSortingComparator
		Collections.sort(students, new CustomSortingComparator());

		// Display message only
		System.out.println("After Sorting ");

		// Iterating using enhanced for-loop
		// after Sorting ArrayList
		for (Student it : students) {
			System.out.println(it);
		}

		// Java 8 way of sorting using Lambda.
		System.out.println("------Java 8 way of sorting using Lambda.-------");
		students.sort(Comparator.comparing(Student::getName).thenComparing(Student::getAge));

		// Display message after sorting
		System.out.println("After Sorting:");

		// Iterating using enhanced for-loop after sorting ArrayList
		for (Student it : students) {
			System.out.println(it);
		}

	}

}

//Define the Student class
class Student {
	int rollno;
	String name;
	Integer age;

	public Integer getAge() {
		return age;
	}

	// Constructor
	Student(int rollno, String name, Integer age) {
		this.rollno = rollno;
		this.name = name;
		this.age = age;
	}

	public int getRollno() {
		return rollno;
	}

	public String getName() {
		return name;
	}

	// Method to print Student
	// details in main()
	@Override
	public String toString() {
		return rollno + ": " + name + " : " + age;
	}
}

//Helper class implementing Comparator interface
class SortbyRoll implements Comparator<Student> {
	// Compare by roll number in ascending order
	public int compare(Student a, Student b) {
		return a.rollno - b.rollno;
	}
}

//Comparator in a Helper Class
class CustomSortingComparator implements Comparator<Student> {

	// Compare first by name, then by age
	public int compare(Student customer1, Student customer2) {

		// Compare by name first
		int NameCompare = customer1.getName().compareTo(customer2.getName());

		// If names are the same, compare by age
		int AgeCompare = customer1.getAge().compareTo(customer2.getAge());

		// Return the result: first by name, second by age
		return (NameCompare == 0) ? AgeCompare : NameCompare;
	}
}
