package com.example.employeetaskmanagement.service;

import com.example.employeetaskmanagement.model.Employee;

import java.util.List;
import java.util.Optional;

public interface EmployeeService {
    List<Employee> getAllEmployees();
    Optional<Employee> getEmployeeById(String id);
    Employee saveEmployee(Employee employee);
    void deleteEmployee(String id);
}
