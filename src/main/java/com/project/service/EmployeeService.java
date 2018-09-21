package com.project.service;


import com.project.model.Employee;

import java.util.List;

public interface EmployeeService {

	Employee findById(Long id);

	Employee findByName(String name);

	void saveEmployee(Employee employee);

	void updateEmployee(Employee employee);

	void deleteEmployeeById(Long id);

	List<Employee> findAllEmployees();

	void deleteAllEmployees();

	boolean isEmployeeExists(Employee employee);
}