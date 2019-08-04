package com.example.demo.modal;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.stereotype.Service;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table (name="Employee")
public class EmployeeModal {
	
	@Id @GeneratedValue (strategy = GenerationType.IDENTITY)
	private Integer id ;
	@NotNull
	@Column (name="Email")
	private String email ;
	@Column (name="PassWord")
	private String passWord ;
	@Column (name="BasedSalary")
	private String basedSalary ;
	@Column (name="Salary")
	private BigDecimal salary ;

}
