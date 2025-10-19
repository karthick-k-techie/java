package com.stream.api.interview;

public class Employee {

	String empname;
	int empId;
	String city;
	int salary;
	public String getEmpname() {
		return empname;
	}

	public void setEmpname(String empname) {
		this.empname = empname;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	String department;

	public Employee(String empname, int empId, String city, int salary, String department) {
		this.empname = empname;
		this.empId = empId;
		this.city = city;
		this.salary = salary;
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [empname=" + empname + ", empId=" + empId + ", city=" + city + ", salary=" + salary
				+ ", department=" + department + "]";
	}

}
