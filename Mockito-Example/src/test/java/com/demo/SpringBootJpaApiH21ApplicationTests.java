package com.demo;


import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.demo.repository.StudentRepository;



//@SpringBootTest
@RunWith(SpringRunner.class)
@SpringBootTest
class SpringBootJpaApiH21ApplicationTests {
 

	//@Autowired
	private MockMvc mockMvc;
	
	@Autowired
	private WebApplicationContext context;
	
	@MockBean
	private StudentRepository studentRepo;
	
	
  
}
