package com.example.employeemanagement.service;

import com.example.employeemanagement.model.Department;
import com.example.employeemanagement.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository departmentRepository;

    public List<Department> getAllDepartments() {
        return departmentRepository.findAll();
    }

    public Department getDepartmentById(Long id) {
        return departmentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @Transactional
    public Department createDepartment(Department department) {
        return departmentRepository.save(department);
    }

    @Transactional
    public Department updateDepartment(Long id, Department department) {
        Department existing = getDepartmentById(id);
        existing.setName(department.getName());
        return departmentRepository.save(existing);
    }

    @Transactional
    public void deleteDepartment(Long id) {
        departmentRepository.deleteById(id);
    }
}
