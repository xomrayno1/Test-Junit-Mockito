package com.demo.JUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.demo.entity.Employee;

public class AppTest {

	@Test
	public void testSalaryEmp() {
		Employee employee = new Employee("Nguyen", "Tam", 300, 30);
		double salaryEmp =  employee.getSalaryEmp();
		assertEquals(9000,salaryEmp);
	}
}
