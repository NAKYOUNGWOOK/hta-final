package com.groupware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupware.Domain.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {
//	Employee findByEmail(String email);
}
