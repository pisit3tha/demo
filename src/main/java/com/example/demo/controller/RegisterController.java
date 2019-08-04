package com.example.demo.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.modal.EmployeeModal;
import com.example.demo.service.CalBaseSalaryService;
import com.example.demo.service.GenPassword;
import com.example.demo.service.RegisterService;
import com.example.demo.request.Employee;

import lombok.extern.slf4j.Slf4j;

@RestController
@SuppressWarnings({ "rawtypes", "unchecked" })
@Slf4j
@RequestMapping("${services.endpoint.version}") ///registry-service/v1
public class RegisterController {
	
	
	private RegisterService registerService;
	
	@Autowired
	public RegisterController(
		RegisterService registerService,
		CalBaseSalaryService calBaseSalaryService,
		GenPassword genPassword) {
		this.registerService = registerService;
	}
	
	  @RequestMapping(value = "/registry" ,  method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity newEmpoyeer(@RequestBody Employee employeeRequest ) {
		  EmployeeModal employee = new EmployeeModal();
	    	try {
			employee = registerService.newUser(employeeRequest);
			} catch (RuntimeException e) {
				new RuntimeException("Employee not registry");
				log.error(e.getMessage());
			}
	    	return new ResponseEntity(employee , HttpStatus.OK);
		    	
	}
	  
	  @RequestMapping(value = "/empoyee/{id}" ,  method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity getEmpoyee(@PathVariable int id) {
		  EmployeeModal employee = new EmployeeModal();
		  try {
			   employee = registerService.getEmpoyee(id).orElseThrow(() -> new RuntimeException("Employee not found"));
		} catch (Exception e2) {
			log.error(e2.getMessage());
		}
	    	return new ResponseEntity(employee , HttpStatus.OK);
	}
	  
	  @RequestMapping(value = "/delete/{id}" ,  method = RequestMethod.DELETE,produces = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity deleteEmpoyee(@PathVariable int id) {
		  List<EmployeeModal> employee = null;
		  try {
			   employee = registerService.deleteEmpoyee(id);
		} catch (Exception e) {
			log.error(e.getMessage());
		}
	    	return new ResponseEntity(employee , HttpStatus.OK);
	}
	  
	  @RequestMapping(value = "/edit" ,  method = RequestMethod.PATCH,produces = MediaType.APPLICATION_JSON_VALUE)
	  public ResponseEntity editEmpoyee(@RequestBody  List<Employee> employeeRequest) {
		  List<EmployeeModal> employee = null;
		  try {
			   employee = registerService.editEmpoyee(employeeRequest);
		} catch (RuntimeException e2) {
			new RuntimeException("Employee not edit");
			log.error(e2.getMessage());
		}
	    	return new ResponseEntity(employee , HttpStatus.OK);
	}

	
	 
	
	 
	
	 
	
	 
	 
}
