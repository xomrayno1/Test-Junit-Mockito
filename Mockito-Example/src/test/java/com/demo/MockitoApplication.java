package com.demo;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.demo.repository.StudentRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
//@WebMvcTest
public class MockitoApplication {
	
	//@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@MockBean
	private StudentRepository studentRepo;
	
	
 
	
	@Before
	public void setUp() {
		mockMvc = MockMvcBuilders.webAppContextSetup(context).build();
	}
	@Test
	public void contextLoads() throws Exception {
		Mockito.when(studentRepo.findAll()).thenReturn(
					Collections.emptyList()
				);
		MvcResult mvcResult = mockMvc.perform(
					MockMvcRequestBuilders.get("/api/v1/students")
									.accept(MediaType.APPLICATION_JSON)
				).andReturn();
		System.out.println(mvcResult.getResponse());
		Mockito.verify(studentRepo).findAll(); 
	}
}
