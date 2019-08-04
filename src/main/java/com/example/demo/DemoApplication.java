package com.example.demo;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.modal.EmployeeModal;
import com.example.demo.repository.EmpRepository;


@SpringBootApplication

public class DemoApplication implements CommandLineRunner {
	
	@Autowired
	private EmpRepository repo ;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
		
	}

	@Override
	public void run(String... args) throws Exception {
		EmployeeModal  emp = EmployeeModal.builder()
		.passWord("12345")
		.email("A@test.com")
		.basedSalary("Gold")
		.salary(new BigDecimal(50000))
		.build();
		repo.save(emp);
		
	}

}
