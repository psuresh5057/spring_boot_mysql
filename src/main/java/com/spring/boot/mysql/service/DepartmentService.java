package com.spring.boot.mysql.service;

import com.spring.boot.mysql.model.Department;
import jakarta.validation.Valid;

import java.util.List;

public interface DepartmentService {
    String saveDepartment(@Valid List<Department> departmentList);

    Department getDepartmentById(Integer id);

    Department getDepartmentByName(String departmentName);

    List<Department> getAllDepartments();
}
