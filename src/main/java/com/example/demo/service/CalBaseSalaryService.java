package com.example.demo.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CalBaseSalaryService {
	private String baseSalaryLV = "Silver"; 
	private BigDecimal baseSalarySilver = new BigDecimal("15000");
	private BigDecimal baseSalaryGold = new BigDecimal("30000");
	private BigDecimal baseSalaryPlatinum = new BigDecimal("50000");
	public String calBaseSalary(BigDecimal salary) {
		try {
			if(salary.compareTo(baseSalaryPlatinum) == 1 ) {
				baseSalaryLV = "Platinum";
			}else if(salary.compareTo(baseSalaryGold) == 1 ) {
				baseSalaryLV = "Gold";
			}else if(salary.compareTo(baseSalaryGold) < 0) {
				baseSalaryLV = "Silver";
			}
		} catch (Exception e) {
			log.error(e.getMessage());
		}
		return baseSalaryLV;
				
	}

}
