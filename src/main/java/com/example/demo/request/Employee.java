package com.example.demo.request;

import java.math.BigDecimal;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
	
	private Integer id ;
	private String email ;
	@NotNull
	private String passWord ;
	private String basedSalary ;
	private BigDecimal salary ;

}
