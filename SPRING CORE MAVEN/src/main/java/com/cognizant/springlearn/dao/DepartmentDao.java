package com.cognizant.springlearn.dao;

import com.cognizant.springlearn.model.Department;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Component
public class DepartmentDao {
    private List<Department> departmentList;

    @PostConstruct
    private void init() {
        departmentList = new ArrayList<>();
    }

    public List<Department> getAllDepartments() {
        return departmentList;
    }
}
