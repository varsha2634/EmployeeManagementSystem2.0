package com.example.employeetaskmanagement.service;

import com.example.employeetaskmanagement.model.Employee;
import com.example.employeetaskmanagement.repository.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class EmployeeServiceTests {

    @Mock
    private EmployeeRepository employeeRepository;

    @InjectMocks
    private EmployeeServiceImpl employeeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindAllEmployees() {
        Employee emp1 = new Employee();
        emp1.setId("1");
        emp1.setName("John Doe");

        Employee emp2 = new Employee();
        emp2.setId("2");
        emp2.setName("Jane Doe");

        when(employeeRepository.findAll()).thenReturn(Arrays.asList(emp1, emp2));

        List<Employee> employees = employeeService.findAllEmployees();
        assertEquals(2, employees.size());
        verify(employeeRepository, times(1)).findAll();
    }

    @Test
    public void testFindEmployeeById() {
        Employee emp = new Employee();
        emp.setId("1");
        emp.setName("John Doe");

        when(employeeRepository.findById("1")).thenReturn(Optional.of(emp));

        Optional<Employee> foundEmployee = employeeService.findEmployeeById("1");
        assertTrue(foundEmployee.isPresent());
        assertEquals("John Doe", foundEmployee.get().getName());
        verify(employeeRepository, times(1)).findById("1");
    }

    @Test
    public void testSaveEmployee() {
        Employee emp = new Employee();
        emp.setName("John Doe");

        when(employeeRepository.save(any(Employee.class))).thenReturn(emp);

        Employee savedEmployee = employeeService.saveEmployee(emp);
        assertNotNull(savedEmployee);
        assertEquals("John Doe", savedEmployee.getName());
        verify(employeeRepository, times(1)).save(emp);
    }

    @Test
    public void testDeleteEmployee() {
        String empId = "1";
        doNothing().when(employeeRepository).deleteById(empId);

        employeeService.deleteEmployee(empId);
        verify(employeeRepository, times(1)).deleteById(empId);
    }
}
