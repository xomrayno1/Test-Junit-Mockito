package com.demo.service.impl;

import org.springframework.stereotype.Service;

import com.demo.dao.EmployeeDAO;
import com.demo.entity.Employee;
import com.demo.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{
	private EmployeeDAO employeeDAO;
	public EmployeeServiceImpl(EmployeeDAO employeeDAO) {
		
		this.employeeDAO = employeeDAO;
	}
	@Override
	public String createEmployee(String email) {
		// TODO Auto-generated method stub
		boolean result = employeeDAO.createEmployee(email);
		if(result) {
			return "success";
		}
		return "failed";
	}
	@Override
	public String createEmp(Employee employee) {
		// TODO Auto-generated method stub
		boolean result = employeeDAO.createEmp(employee);
		if(result) {
			return "success";
		}
		return "failed";
	}

}
