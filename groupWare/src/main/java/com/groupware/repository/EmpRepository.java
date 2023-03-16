package com.groupware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupware.vo.Employee;

public interface EmpRepository extends JpaRepository<Employee, Integer> {
	Employee findbyEmail(String email);
}
