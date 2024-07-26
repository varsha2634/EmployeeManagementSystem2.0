package com.example.employeetaskmanagement.repository;

import com.example.employeetaskmanagement.model.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@DataMongoTest
public class EmployeeRepositoryTests {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Test
    public void testFindAll() {
        List<Employee> employees = employeeRepository.findAll();
        Assertions.assertTrue(employees.size() > 0, "The employee list should not be empty");
    }

    @Test
    public void testFindById() {
        Optional<Employee> employeeOpt = employeeRepository.findAll().stream().findFirst();
        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            Optional<Employee> foundEmployee = employeeRepository.findById(employee.getId());
            Assertions.assertTrue(foundEmployee.isPresent(), "Employee should be found by ID");
            Assertions.assertEquals(employee.getName(), foundEmployee.get().getName());
        } else {
            Assertions.fail("No employee found to test findById");
        }
    }

    @Test
    public void testSave() {
        Employee employee = new Employee();
        employee.setName("New Employee");
        employee.setEmail("new.employee@example.com");
        employee.setJobTitle("Tester");
        employee.setDepartment("QA");
        employee.setHireDate(LocalDate.of(2022, 3, 15));

        Employee savedEmployee = employeeRepository.save(employee);
        Assertions.assertNotNull(savedEmployee.getId(), "Saved employee should have an ID");
        Assertions.assertEquals("New Employee", savedEmployee.getName());
    }

    @Test
    public void testDeleteById() {
        Optional<Employee> employeeOpt = employeeRepository.findAll().stream().findFirst();
        if (employeeOpt.isPresent()) {
            Employee employee = employeeOpt.get();
            employeeRepository.deleteById(employee.getId());

            Optional<Employee> deletedEmployee = employeeRepository.findById(employee.getId());
            Assertions.assertFalse(deletedEmployee.isPresent(), "Employee should be deleted by ID");
        } else {
            Assertions.fail("No employee found to test deleteById");
        }
    }
}
