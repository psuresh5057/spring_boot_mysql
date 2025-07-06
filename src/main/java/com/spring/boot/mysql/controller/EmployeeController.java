package com.spring.boot.mysql.controller;

import com.spring.boot.mysql.model.Employee;
import com.spring.boot.mysql.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;


    @PostMapping(value = "/save")
    public ResponseEntity<String> createEmployee(@Valid @RequestBody List<Employee> employee) {
        String status=  employeeService.saveEmployee(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body(status);
    }

    @PostMapping(value = "/update")
    public ResponseEntity<String> updateEmployee(@Valid @RequestBody List<Employee> employeeList) {
        String status = employeeService.updateEmployee(employeeList);
        return ResponseEntity.ok(status);
    }

    @GetMapping(value = "/get_employees_by_department_id/{departmentId}")
    public ResponseEntity<List<Employee>> getEmployeesListBasedOnDepartmentId(@PathVariable Integer departmentId) {
        List<Employee> employeeList = employeeService.getEmployeesListBasedOnDepartmentId(departmentId);
        if (employeeList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(employeeList);
    }

    @GetMapping(value = "/get_all_employees")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        List<Employee> employeeList = employeeService.getAllEmployees();
        if (employeeList.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return ResponseEntity.ok(employeeList);
    }
}
