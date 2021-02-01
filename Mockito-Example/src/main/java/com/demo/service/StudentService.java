package com.demo.service;

import java.util.List;

import com.demo.entity.Student;

public interface StudentService {
	
	List<Student> findAll();
	
	Student findById(long id);
	
	Student createStudent(Student student);
	
	Student updateStudent(Student student);
	
	void deleteStudent(Student student);
	
	

}
