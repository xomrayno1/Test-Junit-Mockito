package com.demo.service;

import com.demo.dao.StudentDAO;
import com.demo.entity.Student;

public class StudentService {
	private StudentDAO studentDAO;

	public StudentService(StudentDAO studentDAO) {
		 
		this.studentDAO = studentDAO;
	}
	
	public boolean saveStudent(Student student) {
		//validation
		return studentDAO.save(student);
	}
	 
}
