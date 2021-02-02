package com.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.skyscreamer.jsonassert.JSONAssert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.demo.controller.StudentController;
import com.demo.entity.Course;
import com.demo.service.StudentServiceDB;

@RunWith(SpringRunner.class)
@WebMvcTest(value = StudentController.class)
 
public class MockitoApplication {
	
	//@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@MockBean
	private StudentServiceDB studentService;

	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	Course mockCourse = new Course("Course1", "Spring", "10Steps",
			Arrays.asList("Learn Maven", "Import Project", "First Example",
					"Second Example"));

	String exampleCourseJson = "{\"name\":\"Spring\",\"description\":\"10Steps\",\"steps\":[\"Learn Maven\",\"Import Project\",\"First Example\",\"Second Example\"]}";

	@Test
	public void retrieveDetailsForCourse() throws Exception {

		Mockito.when(
				studentService.retrieveCourse(Mockito.anyString(),
						Mockito.anyString())).thenReturn(mockCourse);
		// truyền vào cái gì đều trả về mockCourse

		RequestBuilder requestBuilder = MockMvcRequestBuilders.get(
				"/api/v1/students/Student1/courses/Course1").accept(
				MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
  
//		Course course = new Course("Course1", "Spring", "10Steps", Arrays.asList("Learn Maven", "Import Project", "First Example",
//				"Second Example")); 
		String expected = "{id:Course1,name:Spring,description:10Steps}";
 
		//{"id":"Course1","name":"Spring","description":"10 Steps, 25 Examples and 10K Students","steps":["Learn Maven","Import Project","First Example","Second Example"]}
		//{"id":"Course1","name":"Spring","description":"10Steps","steps":["Learn Maven","Import Project","First Example","Second Example"]}
		
		System.out.println(expected );
		System.out.println(result.getResponse().getContentAsString());
		
		JSONAssert.assertEquals(expected // bằng nhau
						, result.getResponse().getContentAsString(), false);
		// false : ko nghiêm ngặt
		// true: nghiêm ngặt vì vậy => sai do result.getResponse() có step
	}

	@Test
	public void createStudentCourse() throws Exception {
		Course mockCourse = new Course("1", "Smallest Number", "1",
				Arrays.asList("1", "2", "3", "4"));

		// studentService.addCourse to respond back with mockCourse
		Mockito.when(
				studentService.addCourse(Mockito.anyString(),
						Mockito.any(Course.class)))
		.thenReturn(mockCourse);

		System.out.println(exampleCourseJson); // content add
		
		// Send course as body to /students/Student1/courses
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post("/api/v1/students/Student1/courses")
				.accept(MediaType.APPLICATION_JSON).content(exampleCourseJson)
				.contentType(MediaType.APPLICATION_JSON);

		MvcResult result = mockMvc.perform(requestBuilder).andReturn();

		MockHttpServletResponse response = result.getResponse();

		assertEquals(HttpStatus.CREATED.value(), response.getStatus()); // so sánh status

		assertEquals("http://localhost/api/v1/students/Student1/courses/1",
				response.getHeader(HttpHeaders.LOCATION)); // so sánh location trên header

	}
}
