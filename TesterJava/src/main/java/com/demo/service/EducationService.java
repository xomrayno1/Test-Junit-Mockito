package com.demo.service;

import com.demo.dao.EducationDAO;
import com.demo.entity.Student;
import com.demo.exception.NotAvailableException;

public class EducationService {
	
	private EducationDAO  educationDAO;

	public EducationService(EducationDAO educationDAO) {
		super();
		this.educationDAO = educationDAO;
	}
	
	public boolean authenticated(Student student) {
		return educationDAO.authenticated(student.getUsername(), student.getPassword());
	}
	public boolean isEnrolled(Student student) {
		educationDAO.update(student);
		return student.isEnroled();
	}
	public void retriveTranscript(Student student) throws NotAvailableException {
		if(educationDAO.isEnrolled(student)) {
			student.setTranscript(educationDAO.getTranscript(student));
		}
	}
}
