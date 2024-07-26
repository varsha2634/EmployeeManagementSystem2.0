package com.example.employeetaskmanagement.service;

import com.example.employeetaskmanagement.model.Employee;
import com.example.employeetaskmanagement.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;

public class AuthServiceImplTest {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private AuthServiceImpl authService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testAuthenticateSuccess() {
        Employee employee = new Employee();
        employee.setEmail("test@example.com");
        employee.setPassword("password");

        when(employeeRepository.findByEmail("test@example.com")).thenReturn(Optional.of(employee));

        Optional<Employee> result = authService.authenticate("test@example.com", "password");
        assertTrue(result.isPresent(), "Expected employee to be present");
        assertEquals("test@example.com", result.get().getEmail(), "Email should match");
    }

    @Test
    public void testAuthenticateFailure() {
        when(employeeRepository.findByEmail(anyString())).thenReturn(Optional.empty());

        Optional<Employee> result = authService.authenticate("test@example.com", "wrongpassword");
        assertFalse(result.isPresent(), "Expected no employee to be present");
    }
}
