package com.stream.api.interview;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.stream.Collectors;

public class Part3 {

	public static void main(String[] args) {
		List<Employee> employees = Arrays.asList(new Employee("Raja", 1, "Bengaluru", 9000, "HR"),
				new Employee("Nandu", 2, "Chennai", 3000, "Testing"),
				new Employee("Helen", 3, "Bengaluru", 18000, "Accounts"),
				new Employee("Rohini", 4, "Chennai", 8000, "Accounts"),
				new Employee("Rakesh", 5, "Cochin", 18000, "HR"),
				new Employee("Harini", 6, "Cochin", 12000, "Accounts"),
				new Employee("Susheela", 7, "Bengaluru", 22000, "Testing"),
				new Employee("Nimisha", 8, "Chennai", 22000, "Accounts"));
		// basic(employees);
//		intermediate(employees);
		advanced(employees);
	}
	
	public static void advanced(List<Employee> e) {
		
		System.out.println("=======14. List all employees by department=======");
		e.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach((k,v)->System.out.println("Departnemt "+k +"Value "+v));
		
		System.out.println("===========15. Get the count of employees by department===============");
		e.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting())).forEach((k,v)->System.out.println("Department "+k+ " === EMployee Count "+v));
		
		System.out.println("=========16. Get the sum of salaries of all employees by department=========");
		e.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.summingInt(Employee::getSalary))).forEach((dept,sal)->System.out.println("Department "+dept +" --- Sum of Salaries of all emp "+sal));
		
		System.out.println("========17. Get the avarage salaries of all employees per department=========");
		e.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingInt(Employee::getSalary))).forEach((dep,avg)-> System.out.println("department "+ dep+" - "+avg));
		
		System.out.println("======18. Check if all employees belong to a specific department=======");
		
		// reverse all match & Any match concepts.
		
		boolean allMatch = e.stream().allMatch(emp->emp.getDepartment().equals("HR"));
		System.out.println(allMatch);
		
		System.out.println("========19. List all employees grouping by cities but belong to the same department.======");
		e.stream().collect(Collectors.groupingBy(Employee::getDepartment)).forEach(
				(dept,citiy)-> { System.out.println("Department "+dept+
				citiy.stream().collect(Collectors.groupingBy(Employee::getCity)));				
				});	
		System.out.println("======20. Find the department with the highest average salary======");
		
		Map<String,Double> d = e.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
		
		//need to check & fix below error.
//		String key = d.keySet().stream().max(Comparator.comparing(dept->d.get(d))).get();
	//	double  highest = d.get(key);
		
	//	System.out.println(highest);
		
	}

	public static void intermediate(List<Employee> e) {
		System.out.println("=========6. Check if all employees have a salary greater than a specific Value=========");
		boolean allMatch = e.stream().allMatch(emp -> emp.salary > 2000);
		System.out.println(allMatch);
		System.out.println(
				"=============7. Get the sum of salaries of all employees and the average salary===================");
		int sum = e.stream().mapToInt(emp -> emp.salary).sum();
		System.out.println("Sum is " + sum);
		sum = e.stream().collect(Collectors.summingInt(emp -> emp.salary));
		System.out.println("Sum is " + sum);
		OptionalDouble average = e.stream().mapToInt(emp -> emp.salary).average();
		if (average.isPresent()) {
			System.out.println("Average " + average.getAsDouble());
		}
		Double average1 = e.stream().collect(Collectors.averagingDouble(emp -> emp.salary));
		System.out.println(average1);

		System.out.println("==========8. Get a Map of employee Names and their salaries.==========");
		Map<String, Integer> collect = e.stream().collect(Collectors.toMap(emp -> emp.empname, emp -> emp.salary));
		collect.forEach((k, v) -> System.out.println(k + " = " + v));

		System.out.println("==========9. Print the employee deatils from highest to lowest salary===========");
		e.stream().sorted((e1, e2) -> ((Integer) e2.salary).compareTo(e1.salary)).forEach(System.out::println);
		System.out.println();
		e.stream().sorted(Comparator.comparing(Employee::getSalary).reversed()).forEach(System.out::println);

		System.out.println("======10. Get the employees with the highest salary======");

		Optional<Employee> max = e.stream().max(Comparator.comparing(Employee::getSalary));
		if (max.isPresent())
			System.out.println(max.get());
		System.out.println();
		double asDouble = e.stream().mapToDouble(Employee::getSalary).max().getAsDouble();
		e.stream().filter(emp -> emp.salary == asDouble).forEach(System.out::println);

		System.out.println("==========11. Get the employees with the second highest salary.============");
		Optional<Integer> first = e.stream().map(Employee::getSalary).distinct().sorted(Comparator.reverseOrder())
				.skip(1).findFirst();
		e.stream().filter(emp -> emp.getSalary() == first.get()).forEach(System.out::println);

		System.out.println("======12. Get the employees who are earning above the average salary=======");
		OptionalDouble average2 = e.stream().mapToInt(Employee::getSalary).average();
		System.out.println("Average Salary " + average2.getAsDouble());
		e.stream().filter(emp -> emp.salary > average2.getAsDouble()).forEach(System.out::println);

		System.out.println("====13. Get the employee with the longest name.====");

		Employee employee = e.stream().max(Comparator.comparing(Employee::getEmpname)).get();
		System.out.println(employee);
	}

	public static void basic(List<Employee> e) {
		System.out.println("=========1. Find all employees from a specific city and get the count.============");
		e.stream().filter(emp -> emp.city == "Chennai").map(emp -> emp.empname).forEach(System.out::println);
		System.out.println(e.stream().filter(emp -> emp.city.equals("Chennai")).map(emp -> emp.empname).count());

		System.out.println("=========2. Find all employees where salary is greater than a particular value.==========");
		e.stream().filter(emp -> emp.salary > 10000).forEach(System.out::println);

		System.out.println(
				"==========3. Print all the employee names only in upper case and alphabetical order==========");
		e.stream().map(emp -> emp.empname.toUpperCase()).sorted().forEach(System.out::println);

		System.out.println(
				"=========4. Get the first employee where dept is \"HR\" and if not available throw exception.==========");
		Optional<Employee> first = Optional.ofNullable(e.stream().filter(emp -> emp.department.equals("HR")).findFirst()
				.orElseThrow(() -> new EmployeeNotFoundException()));
		if (first.isPresent()) {
			System.out.println(first.get());
		}

		System.out.println("=======5. Get the total salary of all employees in a specific department.=======");
		Integer collect = e.stream().filter(emp -> emp.department.equals("Accounts")).mapToInt(emp -> emp.salary).sum();
		System.out.println(collect);
		Integer collect1 = e.stream().filter(emp -> emp.department.equals("Testing"))
				.collect(Collectors.summingInt(emp -> emp.salary));
		System.out.println(collect1);
	}

}
