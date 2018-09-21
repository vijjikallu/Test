package com.project.service;

import java.util.List;

import com.project.model.Employee;
import com.project.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service("employeeService")
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee findById(Long id) throws RuntimeException {
		return employeeRepository.getEmployee(id);
	}

	public Employee findByName(String name) {
		return employeeRepository.findByName(name);
	}

	public void saveEmployee(Employee employee) {
		employeeRepository.saveEmployee(employee);
	}

	public void updateEmployee(Employee employee){
		saveEmployee(employee);
	}

	public void deleteEmployeeById(Long id){
		employeeRepository.deleteEmployee(id);
	}

	public List<Employee> findAllEmployees(){
		return employeeRepository.getAllEmployees();
	}

	public boolean isEmployeeExists(Employee employee) {
		return findByName(employee.getName()) != null;
	}

	public void deleteAllEmployees() {
		employeeRepository.deleteAllEmployees();
	}

}
