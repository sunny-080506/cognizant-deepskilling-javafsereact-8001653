package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.projection.EmployeeDto;
import com.example.employeemanagement.projection.EmployeeProjection;
import com.example.employeemanagement.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final DepartmentService departmentService;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Transactional
    public Employee createEmployee(Employee employee, Long departmentId) {
        employee.setDepartment(departmentService.getDepartmentById(departmentId));
        return employeeRepository.save(employee);
    }

    @Transactional
    public Employee updateEmployee(Long id, Employee employee, Long departmentId) {
        Employee existing = getEmployeeById(id);
        existing.setName(employee.getName());
        existing.setEmail(employee.getEmail());
        existing.setDepartment(departmentService.getDepartmentById(departmentId));
        return employeeRepository.save(existing);
    }

    @Transactional
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> searchByName(String keyword) {
        return employeeRepository.findByNameContaining(keyword);
    }

    public List<Employee> getEmployeesByDepartment(Long deptId) {
        return employeeRepository.findByDepartmentId(deptId);
    }

    public List<Employee> getEmployeesByDepartmentName(String deptName) {
        return employeeRepository.findByDepartmentName(deptName);
    }

    public Page<Employee> getEmployeesPaginated(Pageable pageable) {
        return employeeRepository.findAll(pageable);
    }

    public List<EmployeeProjection> getEmployeeProjections() {
        return employeeRepository.findAllProjected();
    }

    public List<EmployeeDto> getEmployeeDtos() {
        return employeeRepository.findAllDto();
    }

    @Transactional
    public void batchUpdateEmployees(List<Employee> employees) {
        employeeRepository.saveAll(employees);
    }
}
