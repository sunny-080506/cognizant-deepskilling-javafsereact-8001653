package com.cognizant.springlearn.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.exception.EmployeeNotFoundException;
import com.cognizant.springlearn.model.Employee;

@Repository
public class EmployeeDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeDao.class);
	
	private static List<Employee> employeeList;
	
	@Autowired
	public EmployeeDao() {
		LOGGER.info("START - EmployeeDao Constructor");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		@SuppressWarnings("unchecked")
		List<Employee> employees = context.getBean("employeeList", List.class);
		employeeList = employees;
		
		LOGGER.debug("Employees loaded: {}", employeeList);
		LOGGER.info("END - EmployeeDao Constructor");
	}
	
	public List<Employee> getAllEmployees() {
		LOGGER.info("START - getAllEmployees()");
		LOGGER.info("END - getAllEmployees() - Size: {}", employeeList.size());
		return employeeList;
	}
	
	public Employee getEmployee(Integer id) throws EmployeeNotFoundException {
		LOGGER.info("START - getEmployee() - id: {}", id);
		
		for (Employee employee : employeeList) {
			if (employee.getId().equals(id)) {
				LOGGER.info("END - getEmployee() - Found: {}", employee);
				return employee;
			}
		}
		
		LOGGER.error("Employee not found with id: {}", id);
		throw new EmployeeNotFoundException("Employee not found with id: " + id);
	}
	
	public Employee addEmployee(Employee employee) {
		LOGGER.info("START - addEmployee() - employee: {}", employee);
		employeeList.add(employee);
		LOGGER.info("END - addEmployee()");
		return employee;
	}
	
	public Employee updateEmployee(Employee employee) throws EmployeeNotFoundException {
		LOGGER.info("START - updateEmployee() - employee: {}", employee);
		
		for (int i = 0; i < employeeList.size(); i++) {
			if (employeeList.get(i).getId().equals(employee.getId())) {
				employeeList.set(i, employee);
				LOGGER.info("END - updateEmployee() - Updated");
				return employee;
			}
		}
		
		LOGGER.error("Employee not found for update: {}", employee.getId());
		throw new EmployeeNotFoundException("Employee not found with id: " + employee.getId());
	}
	
	public void deleteEmployee(Integer id) throws EmployeeNotFoundException {
		LOGGER.info("START - deleteEmployee() - id: {}", id);
		
		for (int i = 0; i < employeeList.size(); i++) {
			if (employeeList.get(i).getId().equals(id)) {
				employeeList.remove(i);
				LOGGER.info("END - deleteEmployee() - Deleted");
				return;
			}
		}
		
		LOGGER.error("Employee not found for deletion: {}", id);
		throw new EmployeeNotFoundException("Employee not found with id: " + id);
	}
}
