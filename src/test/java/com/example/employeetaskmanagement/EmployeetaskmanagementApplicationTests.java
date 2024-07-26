package com.example.employeetaskmanagement;

import com.example.employeetaskmanagement.model.Employee;
import com.example.employeetaskmanagement.repository.EmployeeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
class EmployeetaskmanagementApplicationTests {

	@Autowired
	private EmployeeRepository employeeRepository;

	@BeforeEach
	void setUp() {
		employeeRepository.deleteAll();

		Employee employee1 = new Employee();
		employee1.setName("John Doe");
		employee1.setEmail("john.doe@example.com");
		employee1.setJobTitle("Software Engineer");
		employee1.setDepartment("IT");
		employee1.setHireDate(LocalDate.of(2021, 1, 10));

		employeeRepository.save(employee1);
	}

	@Test
	void contextLoads() {
		// This test checks if the application context loads
	}

	@Test
	void testEmployeeRepository() {
		List<Employee> employees = employeeRepository.findAll();
		Assertions.assertFalse(employees.isEmpty(), "Employee repository should not be empty");
	}
}
