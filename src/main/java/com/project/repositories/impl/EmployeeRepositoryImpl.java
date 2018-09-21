package com.project.repositories.impl;

import com.project.model.Employee;
import com.project.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

@Repository
@Transactional
public class EmployeeRepositoryImpl implements EmployeeRepository {

	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void saveEmployee(Employee employee) throws RuntimeException {
		entityManager.persist(employee);
	}

	@Override
	public Employee findByName(String name) throws RuntimeException {
		List<Employee> employeeList = entityManager.createQuery("from Employee where name=:name", Employee.class)
							.setParameter("name", name)
							.getResultList();
		return (employeeList.size() == 0) ? null : employeeList.get(0);
	}

	@Override
	public Employee getEmployee(Long employeeId) throws RuntimeException {
		return entityManager.find(Employee.class, employeeId);
	}

	@Override
	public List<Employee> getAllEmployees() throws RuntimeException {
		return entityManager.createQuery("from Employee", Employee.class).getResultList();
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void addAllEmployees(List<Employee> employeeList) throws RuntimeException {
		entityManager.persist(employeeList);
	}

	@Transactional(propagation = Propagation.REQUIRED)
	public void deleteEmployee(Long id) throws RuntimeException {
		Employee employee = getEmployee(id);
		if (employee == null) {
			throw new RuntimeException("Employee with id: " + id + " not found in the DB");
		} else {
			entityManager.remove(employee);
		}
	}

	@Override
	@Transactional(propagation = Propagation.REQUIRED)
	public void updateEmployee(Long id, Employee employee) throws RuntimeException {
		Employee updatedEmployee = getEmployee(id);
		if (updatedEmployee == null) {
			throw new RuntimeException("Employee not found with id: " + id);
		} else {
			updatedEmployee.setName(employee.getName());
			updatedEmployee.setAge(employee.getAge());
			updatedEmployee.setSalary(employee.getSalary());
			entityManager.merge(updatedEmployee);
		}
	}

	@Override
	public void deleteAllEmployees() throws RuntimeException {
		entityManager.createQuery("delete from Employee").executeUpdate();
	}

}
