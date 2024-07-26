package com.example.employeetaskmanagement.service;

import com.example.employeetaskmanagement.model.Employee;
import com.example.employeetaskmanagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public Optional<Employee> authenticate(String email, String password) {
        Optional<Employee> employee = employeeRepository.findByEmail(email);
        if (employee.isPresent() && employee.get().getPassword().equals(password)) {
            return employee;
        }
        return Optional.empty();
    }
}
