package com.example.demo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.modal.EmployeeModal;
import com.example.demo.repository.EmpRepository;
import com.example.demo.request.Employee;


@Service
public class RegisterService {
	
	 private EmpRepository empRepository ;
	 private String finalSalary = "15000";
	 private String baseSalary = null ;
	 private CalBaseSalaryService calBaseSalaryService;
	 private GenPassword genPassword ; 
	
	@Autowired
	public RegisterService(EmpRepository empRepository
			,CalBaseSalaryService calBaseSalaryService
			,GenPassword genPassword) {
		this.empRepository = empRepository;
		this.calBaseSalaryService = calBaseSalaryService;
		this.genPassword = genPassword ; 
		
	}
	public EmployeeModal newEmpoyee(Employee employeeRequest){
		BigDecimal salary = employeeRequest.getSalary();
	  	String passWord = employeeRequest.getPassWord();
	  	String email = employeeRequest.getEmail();
		if(salary == null) {
			salary = new BigDecimal(finalSalary) ;
		}else {
			 baseSalary = calBaseSalaryService.calBaseSalary(salary);
		}
		if(passWord == null || "".equals(passWord.trim()))
			passWord = genPassword.generate(8);
		EmployeeModal  emp = EmployeeModal.builder()
				.email(email) // recive email as a UserName
				.salary(salary)
				.basedSalary(baseSalary)
				.passWord(passWord)
				.build();
		empRepository.save(emp);
		return emp;
		
	}

	public Optional<EmployeeModal> getEmpoyee(int id) {
		Optional<EmployeeModal> employee = empRepository.findById(id);
		return employee;
	}

	public List<EmployeeModal> deleteEmpoyee(int id) {
		 empRepository.deleteById(id);
		 List<EmployeeModal> employee = empRepository.findAll();
			return employee;
	}

	public List<EmployeeModal> editEmpoyee(List<Employee> employeeRequest) {
		List<EmployeeModal> emp = employeeRequest.stream().map(mapRequest -> {
			String basedSalary = calBaseSalaryService.calBaseSalary(mapRequest.getSalary());
			return EmployeeModal.builder()
					.id(mapRequest.getId())
					.email(mapRequest.getEmail())
					.passWord(mapRequest.getPassWord())
					.basedSalary(basedSalary)
					.salary(mapRequest.getSalary())
					.build();
		}).collect(Collectors.toList());
		emp = empRepository.saveAll(emp);
		return emp;
	}

	

}
