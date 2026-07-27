package com.cognizant.springlearn.dao;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Repository;

import com.cognizant.springlearn.model.Department;

@Repository
public class DepartmentDao {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentDao.class);
	
	private static List<Department> departmentList;
	
	@Autowired
	public DepartmentDao() {
		LOGGER.info("START - DepartmentDao Constructor");
		
		ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
		@SuppressWarnings("unchecked")
		List<Department> departments = context.getBean("departmentList", List.class);
		departmentList = departments;
		
		LOGGER.debug("Departments loaded: {}", departmentList);
		LOGGER.info("END - DepartmentDao Constructor");
	}
	
	public List<Department> getAllDepartments() {
		LOGGER.info("START - getAllDepartments()");
		LOGGER.info("END - getAllDepartments() - Size: {}", departmentList.size());
		return departmentList;
	}
}

---

## ✅ GLOBAL EXCEPTION HANDLER
