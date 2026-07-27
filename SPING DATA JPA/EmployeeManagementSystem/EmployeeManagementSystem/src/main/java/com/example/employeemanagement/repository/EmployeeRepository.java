package com.example.employeemanagement.repository;

import com.example.employeemanagement.model.Employee;
import com.example.employeemanagement.projection.EmployeeDto;
import com.example.employeemanagement.projection.EmployeeProjection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNameContaining(String keyword);

    @Query("SELECT e FROM Employee e WHERE e.department.id = :deptId")
    List<Employee> findByDepartmentId(@Param("deptId") Long deptId);

    List<Employee> findByDepartmentName(@Param("deptName") String deptName);

    Page<Employee> findAll(Pageable pageable);

    @Query("SELECT e.id AS id, e.name AS name, e.email AS email FROM Employee e")
    List<EmployeeProjection> findAllProjected();

    @Query("SELECT new com.example.employeemanagement.projection.EmployeeDto(e.id, e.name, e.email) FROM Employee e")
    List<EmployeeDto> findAllDto();
}
