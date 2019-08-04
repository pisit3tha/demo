package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.modal.EmployeeModal;

@Repository
public interface EmpRepository extends JpaRepository<EmployeeModal, Integer> {

}
