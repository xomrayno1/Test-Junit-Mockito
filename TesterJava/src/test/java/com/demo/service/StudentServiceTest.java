package com.demo.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.mockito.Mockito;

import com.demo.dao.StudentDAO;
import com.demo.entity.Student;

public class StudentServiceTest {

	
	//Mockito.mock(StudentDAO.class); có thể chạy mà ko cần MockitoJUnitRunner
	
	@Test // 2 bước để mock
	public void testSavingStudentSuccess() { 
		StudentDAO  studentDAO = Mockito.mock(StudentDAO.class); // (1) mock object
		StudentService studentService = new StudentService(studentDAO);
		Student student =
				new Student("Nguyen Chi Tam", "xomrayno5", "1234", true, "Transcript");
		Mockito.when(studentDAO.save(student))
					.thenReturn(true); // (2) mock hàm 
		
		assertTrue(studentService.saveStudent(student));
	}
	
	@Test
	public void testSavingStudentFaild() {
		StudentDAO  studentDAO = Mockito.mock(StudentDAO.class);
		StudentService studentService = new StudentService(studentDAO);
		Student student =
				new Student("Nguyen Chi Tam", "xomrayno5", "1234", true, "Transcript");
		Mockito.when(studentDAO.save(student))
			.thenReturn(false); 
		assertFalse(studentService.saveStudent(student));
	}
}
