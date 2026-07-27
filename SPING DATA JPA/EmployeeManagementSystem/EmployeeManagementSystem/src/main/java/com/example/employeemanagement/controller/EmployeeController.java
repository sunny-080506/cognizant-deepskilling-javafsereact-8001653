package com.example.employeemanagement.controller;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.projection.EmployeeDto;
import com.example.employeemanagement.projection.EmployeeProjection;
import com.example.employeemanagement.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @GetMapping
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable Long id) {
        return employeeService.getEmployeeById(id);
    }

    @PostMapping
    public Employee createEmployee(@RequestBody Employee employee,
                                   @RequestParam Long departmentId) {
        return employeeService.createEmployee(employee, departmentId);
    }

    @PutMapping("/{id}")
    public Employee updateEmployee(@PathVariable Long id,
                                   @RequestBody Employee employee,
                                   @RequestParam Long departmentId) {
        return employeeService.updateEmployee(id, employee, departmentId);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
    }

    @GetMapping("/search")
    public List<Employee> searchEmployees(@RequestParam String keyword) {
        return employeeService.searchByName(keyword);
    }

    @GetMapping("/by-department")
    public List<Employee> getByDepartment(@RequestParam Long deptId) {
        return employeeService.getEmployeesByDepartment(deptId);
    }

    @GetMapping("/by-department-name")
    public List<Employee> getByDepartmentName(@RequestParam String deptName) {
        return employeeService.getEmployeesByDepartmentName(deptName);
    }

    @GetMapping("/paginated")
    public Page<Employee> getEmployeesPaginated(@PageableDefault(size = 5) Pageable pageable) {
        return employeeService.getEmployeesPaginated(pageable);
    }

    @GetMapping("/projections")
    public List<EmployeeProjection> getEmployeeProjections() {
        return employeeService.getEmployeeProjections();
    }

    @GetMapping("/dtos")
    public List<EmployeeDto> getEmployeeDtos() {
        return employeeService.getEmployeeDtos();
    }
}
