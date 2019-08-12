/**
 * 
 */
package com.example.demo.controller;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;

import com.example.demo.modal.EmployeeModal;
import com.example.demo.request.Employee;
import com.example.demo.service.CalBaseSalaryService;
import com.example.demo.service.GenPassword;
import com.example.demo.service.RegisterService;

import static org.mockito.Mockito.*;      

@ExtendWith(MockitoExtension.class)
@WebMvcTest(RegisterController.class)
public class RegisterControllerTest {
	
	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private TestRestTemplate restTemplate;
	
	@InjectMocks
    private RegisterService registerService;
	
	@InjectMocks
	private CalBaseSalaryService calBaseSalaryService;
	
	@InjectMocks
	private GenPassword genPassword;
	
	private static String baseSalary;
	
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		baseSalary = "20000";
	}
	
	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}
	
	@BeforeEach
	void setUp() throws Exception {
	}
	
	@AfterEach
	void tearDown() throws Exception {
	}

	/**
	 * Test method for
	 * {@link com.example.demo.controller.RegisterControlle#newEmpoyeer(com.example.demo.request.Employee)}.
	 */
	@Test
	void testNewEmpoyee() {
		Employee employeeSt = new Employee(1, "foo@hotmail.com", "password", "Gold", new BigDecimal("50000"));
	    EmployeeModal employeeStub = new EmployeeModal(1, "foo@hotmail.com", "password", "Gold", new BigDecimal("50000"));
		when(registerService.newEmpoyee(employeeSt)).thenReturn(employeeStub);
		 assertEquals(employeeStub,employeeSt); 
		 ResponseEntity<String> response = restTemplate.postForEntity("http://localhost:8080/registry",employeeSt, String.class);
		 assertEquals(employeeStub, response.getBody()); 
	}

	/**
	 * Test method for
	 * {@link com.example.demo.controller.RegisterController#getEmpoyee(int)}.
	 */
	@Test
	void testGetEmpoyee() {
		int id = 1 ; 
		EmployeeModal employeeStub = new EmployeeModal(1, "foo@hotmail.com", "password", "Gold", new BigDecimal("50000"));
		Optional<EmployeeModal> employee = Optional.of(employeeStub);
		when(registerService.getEmpoyee(id)).thenReturn(employee);
		ResponseEntity<String> response = restTemplate.getForEntity("http://localhost:8080/empoyee/" + "/"+id, String.class);
		assertEquals(employeeStub, response.getBody()); 
	}

	/**
	 * Test method for
	 * {@link com.example.demo.controller.RegisterController#deleteEmpoyee(int)}.
	 */
	@Test
	void testDeleteEmpoyee() {
		int id = 1;
		EmployeeModal employee1 = new EmployeeModal(1, "foo@hotmail.com", "password", "Gold", new BigDecimal("50000"));
		EmployeeModal employee2 = new EmployeeModal(2, "foo@hotmail.com", "password", "Gold", new BigDecimal("50000"));
		List<EmployeeModal> employee = new ArrayList<>();
		employee.add(employee1);
		employee.add(employee2);
		when(registerService.deleteEmpoyee(id)).thenReturn(employee);
		verify(registerService, times(1)).deleteEmpoyee(id); 
	}

	/**
	 * Test method for
	 * {@link com.example.demo.controller.RegisterController#editEmpoyee(java.util.List)}.
	 */
	@Test
	void testEditEmpoyee() {
		Employee employee1 = new Employee(1, "foo@hotmail.com", "password", "Gold", new BigDecimal("50000"));
		Employee employee2 = new Employee(2, "123@hotmail.com", "password", "", new BigDecimal("20000"));
		List<Employee> employee = new ArrayList<>();
		List<EmployeeModal> employeeModal = new ArrayList<>();
		employee.add(employee1);
		employee.add(employee2);
		when(registerService.editEmpoyee(employee)).thenReturn(employeeModal);
		verify(registerService, times(1)).editEmpoyee(employee); 
	}

}
