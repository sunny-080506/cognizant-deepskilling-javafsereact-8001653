package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.exception.EmployeeNotFoundException;
import com.cognizant.springlearn.model.Employee;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeDao {
    private List<Employee> employeeList;

    @PostConstruct
    private void init() {
        employeeList = new ArrayList<>();
    }

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public void updateEmployee(Employee employee) throws EmployeeNotFoundException {
        boolean found = false;
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId().equals(employee.getId())) {
                employeeList.set(i, employee);
                found = true;
                break;
            }
        }
        if (!found) {
            throw new EmployeeNotFoundException();
        }
    }

    public void deleteEmployee(int id) throws EmployeeNotFoundException {
        boolean removed = employeeList.removeIf(e -> e.getId() == id);
        if (!removed) {
            throw new EmployeeNotFoundException();
        }
    }
}
