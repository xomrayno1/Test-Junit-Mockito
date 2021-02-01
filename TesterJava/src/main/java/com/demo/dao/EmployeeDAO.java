package com.demo.dao;

import com.demo.entity.Employee;

public interface EmployeeDAO {
	
	boolean createEmployee(String email);
	
	boolean createEmp(Employee employee);

}
