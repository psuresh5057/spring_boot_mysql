package com.spring.boot.azure.mysql.controller;

import com.spring.boot.azure.mysql.model.Department;
import com.spring.boot.azure.mysql.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/save_department")
    public ResponseEntity<String> saveDepartment(@RequestBody List<Department> departmentList) {
        // Logic to save department
        String status = departmentService.saveDepartment(departmentList);
        return ResponseEntity.status(HttpStatus.CREATED).body(status);
    }

    @GetMapping("/get_department/{departmentId}")
    public ResponseEntity<Department> getDepartmentById(@PathVariable Integer departmentId) {
        // Logic to get department by ID
        Department department = departmentService.getDepartmentById(departmentId);
        return ResponseEntity.ok(department);
    }

    @GetMapping("/get_all_departments")
    public ResponseEntity<List<Department>> getAllDepartments() {
        // Logic to get all departments
        List<Department> departments = departmentService.getAllDepartments();
        return ResponseEntity.ok(departments);
    }

    @GetMapping("/get_department_by_name/{departmentName}")
    public ResponseEntity<Department> getDepartmentByName(@PathVariable String departmentName) {
        // Logic to get department by name
        Department department = departmentService.getDepartmentByName(departmentName);
        return ResponseEntity.ok(department);
    }
}
