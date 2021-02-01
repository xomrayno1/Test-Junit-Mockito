package com.demo.dao;

import com.demo.entity.Student;
import com.demo.exception.NotAvailableException;

public class EducationDAO {
	public boolean authenticated(String username, String password) {
		return false;
	}
 
	public boolean isEnrolled(Student student) {
		return false;
	}
	public void update(Student student) {
		
	}
	public String getTranscript(Student student) throws NotAvailableException {
		return null;
	}
}
