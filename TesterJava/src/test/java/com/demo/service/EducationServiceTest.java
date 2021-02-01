package com.demo.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.MockitoJUnitRunner;
import org.mockito.stubbing.Answer;

import com.demo.dao.EducationDAO;
import com.demo.entity.Student;
import com.demo.exception.NotAvailableException;

@RunWith(MockitoJUnitRunner.class)
public class EducationServiceTest {
	//inject có thể thông qua 3 cái : attribute, setter getter,  constructor
	@InjectMocks // inject cái mockobject kia vào educationService
	private EducationService educationService;
	@Mock // thực hiện mock object
	private EducationDAO educationDAO;
	
	
	@Test
	public void testAuthenticationSuccess() {
		Student student =
				new Student("Nguyen Chi Tam", "xomrayno5", "1234", true, "Transcript");
		Mockito.when(educationDAO.authenticated(student.getUsername(), student.getPassword()))
					.thenReturn(true);
		assertTrue(educationService.authenticated(student));
	}
	@Test
	public void testAuthenticationFaild() {
		Student student =
				new Student("Nguyen Chi Tam", "xomrayno5", "1234", true, "Transcript");
		Mockito.when(educationDAO.authenticated(student.getUsername(), student.getPassword()))
					.thenReturn(false);
		assertFalse(educationService.authenticated(student));
	}	
	@Test
	public void testEnrollmentSuccess() {
		Student student =
				new Student("Nguyen Chi Tam", "xomrayno5", "1234", true, "Transcript");
//		Mockito.when(educationDAO.authenticated(student.getUsername(), student.getPassword()))
//					.thenReturn(true);
		doAnswer(new Answer<Object>() {

			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable {
				// TODO Auto-generated method stub
				Object[] arguments  = invocation.getArguments();
				((Student)arguments[0]).setEnroled(true);
				return null;
			}
		}).when(educationDAO).update(student);
				
		assertTrue(educationService.isEnrolled(student));
		verify(educationDAO).update(student);  //check xem hàm này có chạy k 
		// đúng thì chạy bt 
		//sai thì sẽ fail testcase
		//verify(educationDAO,times(2)).update(student);
		//hàm update có chạy 2 lần k 
		
	}
	
	@Test(expected = NotAvailableException.class) // muốn throw exception
	public void testRetrieveTranscript() throws NotAvailableException {
		Student student =
				new Student("Nguyen Chi Tam", "xomrayno5", "1234", true, "Transcript");
		doThrow(new NotAvailableException()).when(educationDAO).getTranscript(student);
		when(educationDAO.isEnrolled(student)).thenReturn(true);
		//when(educationDAO.getTranscript(student)).thenReturn("New Transcript");
		// khi mock exception k can mock object
		educationService.retriveTranscript(student);
		assertEquals(student.getTranscript() , "New Transcript");
	}
}
