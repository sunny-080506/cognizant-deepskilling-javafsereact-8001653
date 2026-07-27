package com.cognizant.ormlearn.repository;

import com.cognizant.ormlearn.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Hands-on 2: Permanent employees with fetch joins
    @Query("SELECT e FROM Employee e " +
           "LEFT JOIN FETCH e.department d " +
           "LEFT JOIN FETCH e.skillList " +
           "WHERE e.permanent = 1")
    List<Employee> getAllPermanentEmployees();

    // Hands-on 4: Average salary by department
    @Query("SELECT AVG(e.salary) FROM Employee e WHERE e.department.id = :deptId")
    double getAverageSalary(@Param("deptId") int departmentId);

    // Hands-on 5: Native query – all employees
    @Query(value = "SELECT * FROM employee", nativeQuery = true)
    List<Employee> getAllEmployeesNative();
}
