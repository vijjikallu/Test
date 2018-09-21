package com.project.repositories;

import com.project.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeeRepository {

    Employee findByName(String name) throws RuntimeException;

    void saveEmployee(Employee employee) throws RuntimeException;

    Employee getEmployee(Long noteId) throws RuntimeException;

    List<Employee> getAllEmployees() throws RuntimeException;

    void addAllEmployees(List<Employee> noteList) throws RuntimeException;

    void deleteEmployee(Long id) throws RuntimeException;

    void updateEmployee(Long id, Employee employee) throws RuntimeException;

    void deleteAllEmployees() throws RuntimeException;

}
