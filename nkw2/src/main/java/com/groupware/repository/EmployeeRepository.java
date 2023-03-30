package com.groupware.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.groupware.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
	Employee findByEmployeename(String employeename);
}
