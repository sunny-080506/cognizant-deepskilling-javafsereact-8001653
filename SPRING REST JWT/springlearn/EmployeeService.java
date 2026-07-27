package com.cognizant.springlearn.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cognizant.springlearn.dao.EmployeeDao;
import com.cognizant.springlearn.exception.EmployeeNotFoundException;
import com.cognizant.springlearn.model.Employee;

@Service
public class EmployeeService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeService.class);
	
	@Autowired
	private EmployeeDao employeeDao;
	
	@Transactional
	public List<Employee> getAllEmployees() {
		LOGGER.info("START - getAllEmployees()");
		List<Employee> employees = employeeDao.getAllEmployees();
		LOGGER.info("END - getAllEmployees() - Size: {}", employees.size());
		return employees;
	}
	
	@Transactional
	public Employee getEmployee(Integer id) throws EmployeeNotFoundException {
		LOGGER.info("START - getEmployee() - id: {}", id);
		Employee employee = employeeDao.getEmployee(id);
		LOGGER.info("END - getEmployee()");
		return employee;
	}
	
	@Transactional
	public Employee addEmployee(Employee employee) {
		LOGGER.info("START - addEmployee() - employee: {}", employee);
		Employee savedEmployee = employeeDao.addEmployee(employee);
		LOGGER.info("END - addEmployee()");
		return savedEmployee;
	}
	
	@Transactional
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException {
		LOGGER.info("START - updateEmployee() - employee: {}", employee);
		Employee updatedEmployee = employeeDao.updateEmployee(employee);
		LOGGER.info("END - updateEmployee()");
		return updatedEmployee;
	}
	
	@Transactional
	public void deleteEmployee(Integer id) throws EmployeeNotFoundException {
		LOGGER.info("START - deleteEmployee() - id: {}", id);
		employeeDao.deleteEmployee(id);
		LOGGER.info("END - deleteEmployee()");
	}
}
