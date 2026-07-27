package com.cognizant.springlearn.controller;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cognizant.springlearn.exception.EmployeeNotFoundException;
import com.cognizant.springlearn.model.Employee;
import com.cognizant.springlearn.service.EmployeeService;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);
	
	@Autowired
	private EmployeeService employeeService;
	
	@GetMapping
	public List<Employee> getAllEmployees() {
		LOGGER.info("START - getAllEmployees()");
		List<Employee> employees = employeeService.getAllEmployees();
		LOGGER.info("END - getAllEmployees() - Size: {}", employees.size());
		return employees;
	}
	
	@GetMapping("/{id}")
	public Employee getEmployee(@PathVariable Integer id) throws EmployeeNotFoundException {
		LOGGER.info("START - getEmployee() - id: {}", id);
		Employee employee = employeeService.getEmployee(id);
		LOGGER.info("END - getEmployee()");
		return employee;
	}
	
	@PostMapping
	public Employee addEmployee(@RequestBody @Valid Employee employee) {
		LOGGER.info("START - addEmployee() - employee: {}", employee);
		Employee savedEmployee = employeeService.addEmployee(employee);
		LOGGER.info("END - addEmployee()");
		return savedEmployee;
	}
	
	@PutMapping
	public Employee updateEmployee(@RequestBody @Valid Employee employee) throws EmployeeNotFoundException {
		LOGGER.info("START - updateEmployee() - employee: {}", employee);
		Employee updatedEmployee = employeeService.updateEmployee(employee);
		LOGGER.info("END - updateEmployee()");
		return updatedEmployee;
	}
	
	@DeleteMapping("/{id}")
	public void deleteEmployee(@PathVariable Integer id) throws EmployeeNotFoundException {
		LOGGER.info("START - deleteEmployee() - id: {}", id);
		employeeService.deleteEmployee(id);
		LOGGER.info("END - deleteEmployee()");
	}
}
