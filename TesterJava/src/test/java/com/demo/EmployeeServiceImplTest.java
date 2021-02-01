package com.demo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.demo.dao.EmployeeDAO;
import com.demo.service.EmployeeService;
 // 2 phương pháp  
// khởi chạy toàn bộ spring sẽ chậm hơn,các bài cũng sẽ thất bại nếu có lỗi
//(1) được ưu tiên hơn
//@RunWith(MockitoJUnitRunner.class) @Mock , @InjectMocks 
//(2)
@SpringBootTest 
@RunWith(SpringRunner.class)
public class EmployeeServiceImplTest {
	 
	@MockBean
	private EmployeeDAO employeeDAO;
//	 
	@Autowired
	private EmployeeService employeeService;
	//@InjectMocks
	//private EmployeeServiceImpl employeeServiceImpl;
	
	@Before
	public void setUp() {
		//employeeService = new EmployeeServiceImpl(employeeDAO);
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void create_whenEmployeeExists() {
		Mockito.when(employeeDAO.createEmployee("xomrayno5@gmail.com"))
					.thenReturn(true);
		
		assertEquals("success", employeeService.createEmployee("xomrayno5@gmail.com"));
	}
	@Test
	public void create_whenEmployeeNotExists() {
		Mockito.when(employeeDAO.createEmployee("xomrayno5@gmail.com"))
					.thenReturn(false);
		
		assertEquals("failed", employeeService.createEmployee("xomrayno5@gmail.com"));
	}
	@Test
	public void create_EmployeeExists() {
		Mockito.when(employeeDAO.createEmployee("xomrayno5@gmail.com"))
				.thenReturn(true);
		assertEquals("success", employeeService.createEmployee("xomrayno5@gmail.com"));
		verify(employeeDAO).createEmployee("xomrayno5@gmail.com");
	}
}
