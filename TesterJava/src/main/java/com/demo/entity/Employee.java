package com.demo.entity;

public class Employee {
	 
	private String firstName;
	private String lastName;
	private double salary;
	private int days;
	private String email;
	
	
	
	
	public Employee() {
		super();
	}

	public Employee(  String firstName, String lastName, double salary, int days) {
		 
		this.firstName = firstName;
		this.lastName = lastName;
		this.salary = salary;
		this.days = days;
	}
	 
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public int getDays() {
		return days;
	}
	public void setDays(int days) {
		this.days = days;
	}
	
	
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public double getSalaryEmp() {
		return salary* days;
	}
}
